package com.sapient.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.sapient.dao.BlockDAO;
import com.sapient.dao.SecuritiesDAO;
import com.sapient.jms.MarshallAndSend;
import com.sapient.dao.ViewFillsDAO;
import com.sapient.model.Block;
import com.sapient.model.Securities;
import com.sapient.model.ViewFills;

@Service("brokerService")
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class BrokerServiceImpl implements BrokerService {

	@Autowired
	BlockDAO blockDAO;
	@Autowired
	SecuritiesDAO securitiesDAO;
	@Autowired
	ViewFillsDAO viewFillsDAO;

	private static final Logger logger = Logger.getLogger(BrokerServiceImpl.class);

	@Async
	@Override
	public void StartExecution() {
		System.out.println("------------------------Entered Broker Service --------------------------------------");
		List<Block> blockList = new ArrayList<>();
		// blockList = blockDAO.findAll();
		blockList = blockDAO.findOpenPartial();
		System.out.println(blockList);

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MarshallAndSend send = (MarshallAndSend) context.getBean("MessageProducer");

		for (Block blocks : blockList) {
			System.out.println(blocks);
			// delete this condition
			String lowerCaseStatus = blocks.getStatus().toLowerCase();
			if (!lowerCaseStatus.equalsIgnoreCase("Completed") && !lowerCaseStatus.equalsIgnoreCase("Expired")) {
				// System.out.println(blocks.getStatus());
				Securities securities = new Securities();
				ViewFills viewFills = new ViewFills();

				// get similar block_id and set remaining quantity
				Long remainingQty = blocks.getTotal_quantity() - blocks.getExecuted_quantity();

				securities = securitiesDAO.findByPrimaryKey(blocks.getSymbol());
				if (securities == null) {
					System.out.println("securities not present");
				} else {
					double MaxPriceSpread = securities.getMax_price_spread();
					int MaxOrderPerOrder = securities.getMax_executions();
					double LastTradedPrice = securities.getLast_trade_price();
					double LimitPrice = blocks.getLimit_price();
					double stopPrice = blocks.getStop_price();
					String side = blocks.getSide();
					String type = blocks.getType();
					System.out.println("type" + type);
					/*
					 * long tempExecutedQty = 0L; if
					 * (blocks.getExecuted_quantity().equals(null) ||
					 * blocks.getExecuted_quantity().equals(0)) {
					 * tempExecutedQty = 0; } else { tempExecutedQty =
					 * blocks.getExecuted_quantity(); }
					 */

					long QtyExecuted = 0L;
					long maxQtyExecuted = 0L;

					double priceExecuted = 0.0;
					double priceSpred = RandomPrice(0.0, MaxPriceSpread);
					double minPrice = LastTradedPrice - (LastTradedPrice * priceSpred / 100);
					double maxPrice = LastTradedPrice + (LastTradedPrice * priceSpred / 100);
					maxQtyExecuted = RandomQty(0, (long) MaxOrderPerOrder);
					if (type.equalsIgnoreCase("market")) {

						priceExecuted = RandomPrice(minPrice, maxPrice);
						// System.out.println("priceExecuted " + priceExecuted);
						QtyExecuted = Math.min(maxQtyExecuted, remainingQty);
					}

					else if (type.equalsIgnoreCase("limit")) {
						if (side.equalsIgnoreCase("buy")) {
							priceExecuted = RandomPrice(Math.min(LimitPrice, minPrice), Math.max(LimitPrice, minPrice));
							QtyExecuted = Math.min(maxQtyExecuted, remainingQty);
						} else {
							priceExecuted = RandomPrice(Math.min(LimitPrice, maxPrice), Math.max(LimitPrice, maxPrice));
							QtyExecuted = Math.min(maxQtyExecuted, remainingQty);
						}
					}
					// if (type.equalsIgnoreCase("stop"))
					else if (type.equalsIgnoreCase("stop limit")) {
						if (stopPrice >= minPrice && stopPrice >= maxPrice) {
							priceExecuted = stopPrice;
							QtyExecuted = Math.min(maxQtyExecuted, remainingQty);
						} else {
							priceExecuted = 0;
							QtyExecuted = 0;
						}
					}

					else {
						priceExecuted = LastTradedPrice;
						QtyExecuted = Math.min(maxQtyExecuted, remainingQty);
						// System.out.println("Type not covered in broker
						// system");
					}

					// Setting the Fields
					// System.out.println("Sock Name: "+blocks.getSymbol() );

					// System.out.println("Total Q " +
					// blocks.getTotal_quantity());
					logger.info("Total Q " + blocks.getTotal_quantity());

					// System.out.println("Executed Q " + QtyExecuted);
					logger.info("Executed Q " + QtyExecuted);
					if (QtyExecuted != 0) {
						blocks.setExecuted_price(priceExecuted);
						// System.out.println("priceExecuted " + priceExecuted);
						blocks.setExecuted_date(new Date());
					}

					blocks.setExecuted_quantity(QtyExecuted + blocks.getExecuted_quantity());
					System.out.println(
							"TotalQtyToExecute " + (blocks.getTotal_quantity() - blocks.getExecuted_quantity()));
					if ((QtyExecuted + blocks.getExecuted_quantity()) == blocks.getTotal_quantity())
						blocks.setStatus("Completed");
					else if (QtyExecuted == 0 && !(lowerCaseStatus.equals("partial")))
						blocks.setStatus("Open");
					else
						blocks.setStatus("Partial");
					System.out.println("Staus: " + blocks.getStatus());

					// blocks.setTotal_quantity(TotalQtyToExecute);
					blockDAO.save(blocks);
					try {
						send.marshallAndSendBlock(blocks);
					} catch (JAXBException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					if (QtyExecuted != 0) {
						viewFills.setExecutedPrice(priceExecuted);
						viewFills.setExecutedDate(new Date());
					} else {
						viewFills.setExecutedPrice(0);
						viewFills.setExecutedDate(blocks.getExecuted_date());
					}
					viewFills.setQtyExecuted(QtyExecuted);
					viewFills.setBlock_Id(blocks.getId());
					viewFills.setRemainingQty(blocks.getTotal_quantity() - blocks.getExecuted_quantity());
					viewFills.setStatus(blocks.getStatus());
					viewFillsDAO.save(viewFills);

					securities.setLast_trade_price(priceExecuted);
					securitiesDAO.save(securities);

				}
			}
		}
	}

	// private Long getFinalRemainingQty(Long id) {
	// Long reminingQty = 0L;
	//
	// return reminingQty;
	// }

	/*
	 * private int min(int totalQtyToExecute, int maxOrderPerOrder) { if
	 * (totalQtyToExecute <= maxOrderPerOrder) return totalQtyToExecute; else
	 * return maxOrderPerOrder; }
	 */

	double RandomPrice(double min, double max) {
		Random r = new Random();
		return (r.nextInt((int) ((max - min) * 100 + 1)) + min * 100) / 100.0;
	}

	long RandomQty(long i, long max) {
		Random r = new Random();
		return (long) (r.nextInt((int) (max - i + 1)) + i);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void saveblock(Block block) {

		System.out.println("reached the service");
		blockDAO.save(block);
		boolean transactionActive = TransactionSynchronizationManager.isActualTransactionActive();
		if (transactionActive) {
			System.out.println("reached the service");
			System.out.println(blockDAO.save(block));
		}

	}

	@Override
	public List<Block> findALL() {
		return blockDAO.findAll();

	}

	@Override
	public void expireblocks() {
		// TODO Auto-generated method stub

		blockDAO.expire();

	}

	@Override
	public Block findByPrimaryKey(long id) {
		return blockDAO.findByPrimaryKey(id);

	}

	@Override
	public List<Block> openPartialView() {
		return blockDAO.findOpenPartial();

	}
}
