package com.sapient.service;

import java.util.ArrayList;
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
import com.sapient.dao.SecuritiesDAO;
import com.sapient.model.Block;
import com.sapient.model.Securities;

@Service("brokerService")
@Transactional(propagation = Propagation.REQUIRED)
public class BrokerServiceImpl implements BrokerService {
	public BrokerServiceImpl() {

	}
@Autowired
	BlockDAO blockDAO;
	SecuritiesDAO securitiesDAO;

	@Override
	public void StartExecution() {

		List<Block> blockList = new ArrayList<>();
		blockList = blockDAO.findAll();
		for (Block blocks : blockList) {
			if (!blocks.getStatus().equalsIgnoreCase("Completed")) {
				Securities securities = new Securities();

				securities = securitiesDAO.findByPrimaryKey(blocks.getSymbol());
				// if null then alert
				double MaxPriceSpread = securities.getMax_price_spread();
				int MaxOrderPerOrder = securities.getMax_executions();
				double LastTradedPrice = securities.getLast_trade_price();
				// double LimitPrice=blocks.getLimit_price();
				// double StopPrice=blocks.getStop_price();
				String type = blocks.getType();
				long tempExecutedQty;
				if (blocks.getExecuted_quantity().equals(null)) {
					tempExecutedQty = 0;
				} else {
					tempExecutedQty = blocks.getExecuted_quantity();
				}
				Long TotalQtyToExecute = blocks.getTotal_quantity() - tempExecutedQty;

				String side = blocks.getSide();
				Long QtyExecuted;

				double PriceExecuted;

				if (type.equalsIgnoreCase("market")) {
					double minPrice = LastTradedPrice - (LastTradedPrice * MaxPriceSpread / 100);
					double maxPrice = LastTradedPrice + (LastTradedPrice * MaxPriceSpread / 100);
					PriceExecuted = RandomPrice(minPrice, maxPrice);
					System.out.println(PriceExecuted);
					// int
					// minQty=TotalQtyToExecute-(TotalQtyToExecute*MaxOrderPerOrder);
					QtyExecuted = RandomQty(1L, Math.min(TotalQtyToExecute, MaxOrderPerOrder));
					System.out.println(QtyExecuted);
				}
				if (type.equalsIgnoreCase("stop")) {

				}
				if (type.equalsIgnoreCase("limit")) {

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
