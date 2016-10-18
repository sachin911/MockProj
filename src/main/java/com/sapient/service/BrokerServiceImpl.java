package com.sapient.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.dao.BlockDAO;
import com.sapient.dao.BlockDAOImpl;
import com.sapient.dao.SecuritiesDAO;
import com.sapient.dao.ViewFillsDAO;
import com.sapient.model.Block;
import com.sapient.model.Securities;
import com.sapient.model.ViewFills;

@Service("brokerService")
@Transactional(propagation = Propagation.REQUIRED)
public class BrokerServiceImpl implements BrokerService {
	public BrokerServiceImpl() {

	}

	@Autowired
	BlockDAO blockDAO;
	@Autowired
	SecuritiesDAO securitiesDAO;

	/*
	 * @Autowired ViewFillsDAO viewFillsDAO;
	 */
	@Override
	public void StartExecution() {

		List<Block> blockList = new ArrayList<>();
		blockList = blockDAO.findAll();
		for (Block blocks : blockList) {
			System.out.println(blocks);
			if (!blocks.getStatus().equalsIgnoreCase("Completed")) {
				// System.out.println(blocks.getStatus());
				Securities securities = new Securities();
				// ViewFills viewFills=new ViewFills();
				/*
				 * securities.setSecurity_symbol("GOOG");
				 * securities.setLast_trade_price(12.0);
				 * securities.setMax_price_spread(20.0);
				 * securities.setMax_executions(100);
				 */
				// System.out.println(securitiesDAO.toString());
				securities = securitiesDAO.findByPrimaryKey(blocks.getSymbol());
				/* viewFills.setRemainingQty(blocks.getTotal_quantity()); */
				// if null then alert
				if (securities == null) {
					System.out.println("securities not present");
				} else {
					double MaxPriceSpread = securities.getMax_price_spread();
					int MaxOrderPerOrder = securities.getMax_executions();
					double LastTradedPrice = securities.getLast_trade_price();
					double LimitPrice = blocks.getLimit_price();
					double StopPrice = blocks.getStop_price();
					String side = blocks.getSide();
					String type = blocks.getType();
					long tempExecutedQty;
					if (blocks.getExecuted_quantity().equals(null) || blocks.getExecuted_quantity().equals(0)) {
						tempExecutedQty = 0;
					} else {
						tempExecutedQty = blocks.getExecuted_quantity();
					}
					System.out.println("Total Q " + blocks.getTotal_quantity());

					System.out.println("Executed Q " + tempExecutedQty);

					Long TotalQtyToExecute = Math.max(0, blocks.getTotal_quantity() - tempExecutedQty);
					System.out.println("TotalQtyToExecute " + TotalQtyToExecute);

					Long QtyExecuted = 0L;

					double priceExecuted = 0.0;

					if (type.equalsIgnoreCase("market")) {
						double minPrice = LastTradedPrice - (LastTradedPrice * MaxPriceSpread / 100);
						double maxPrice = LastTradedPrice + (LastTradedPrice * MaxPriceSpread / 100);
						priceExecuted = RandomPrice(minPrice, maxPrice);
						System.out.println("priceExecuted " + priceExecuted);
						// int
						// minQty=TotalQtyToExecute-(TotalQtyToExecute*MaxOrderPerOrder);

						// if (TotalQtyToExecute <= 20) {
						// QtyExecuted = TotalQtyToExecute;
						// } else {
						QtyExecuted = RandomQty(0L, Math.min(TotalQtyToExecute, MaxOrderPerOrder));
						// }
						System.out.println("QtyExecuted " + QtyExecuted);
					}
					if (type.equalsIgnoreCase("stop")) {

					}
					if (type.equalsIgnoreCase("limit")) {

					}

					if (QtyExecuted == blocks.getTotal_quantity())
						blocks.setStatus("Completed");
					else if (QtyExecuted == 0 && !(blocks.getStatus().equals("Partial")))
						blocks.setStatus("Open");
					else
						blocks.setStatus("Partial");
					TotalQtyToExecute = blocks.getTotal_quantity() - QtyExecuted;
					// Setting the Fields
					blocks.setExecuted_date(new Date());
					blocks.setExecuted_price(priceExecuted);
					blocks.setExecuted_quantity(QtyExecuted);
					blocks.setTotal_quantity(TotalQtyToExecute);

					blockDAO.save(blocks);
					/*
					 * viewFills.setExecutedDate(new Date());
					 * viewFills.setExecutedPrice(priceExecuted);
					 * viewFills.setQtyExecuted(QtyExecuted);
					 * viewFills.setBlock_Id(blocks.getId());
					 * viewFills.setRemainingQty(remainingQty);
					 */
				}
			}
		}
	}

	/*
	 * private int min(int totalQtyToExecute, int maxOrderPerOrder) { if
	 * (totalQtyToExecute <= maxOrderPerOrder) return totalQtyToExecute; else
	 * return maxOrderPerOrder; }
	 */

	double RandomPrice(double min, double max) {
		Random r = new Random();
		return (r.nextInt((int) ((max - min) * 100 + 1)) + min * 100) / 100.0;
	}

	Long RandomQty(Long i, Long max) {
		Random r = new Random();
		return (long) (r.nextInt((int) (max - i + 1)) + i);
	}

	@Override
	public void saveblock(Block block) {

		System.out.println("reached the service");
		blockDAO.save(block);

	}

	@Override
	public List<Block> findALL() {
		return blockDAO.findAll();

	}
}
