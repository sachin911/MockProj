package com.mock.project.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mock.project.dao.GenericDAO;
import com.mock.project.dao.GenericDAOImplementation;
import com.mock.project.dao.OrderDAO;
import com.mock.project.dao.OrderDAOImpl;
import com.mock.project.model.Block;
import com.mock.project.model.Order;


@Service("Order service")
@Transactional
public class TraderServiceImpl implements TraderService{

	@Autowired
	private OrderDAO dao;
	@Override
	public List<Order> display() {
		
		System.out.println(dao.findAll());
		return dao.findAll();
	}
	@Override
	public void updateStatus(long block_id, List order_id) {
		
		dao.updateStatus(block_id, order_id);
		
	}
	
	@Override
	public void createBlock(List<Order> orders) {
			
			//conditions to be checked
			Boolean openStatus=false;
			Boolean symbolStatus=false;
			Boolean sideStatus=false;
			
			
			//Fields of the block
			String blockSymbol=orders.get(0).getSymbol();
			String blockSide=orders.get(0).getSide();
			Date blockCreationDate=new Date();
			Date blockExecutionDate=null;
			String orderType=null;
			Double blockLimitPrice=0.0;
			Double blockStopPrice=0.0;
			String blockStatus="New";
			int quantityPlaced=0;
			int quantityExecuted=0;
			
			
			//for selecting the limit and stop price 
			List<Double> limitPrice=new ArrayList<>();
			List<Double> stopPrice=new ArrayList<>();
			List<Long>	orderId=new ArrayList<>();
			
			for(Order order: orders)
			{
				
				orderId.add(orders.get(0).getOrderId());
				
				//Checking whether the status of all the orders is OPEN
				if((order.getStatus()).equals("Open"))
				{
					openStatus=true;
				}
				else
				{
					
					openStatus=false;
					break;
				}
				
				
				//Checking whether the symbol of all orders are same
				if((order.getSymbol()).equals(blockSymbol))
				{
					symbolStatus=true;
					
				}
				
				else
				{
					
					symbolStatus=false;
					break;
				}
				
				
				//Checking whether the side is same
				if((order.getSymbol()).equals(blockSide))
				{
					sideStatus=true;
					
				}
				
				else
				{
					
					sideStatus=false;
					break;
				}
				
				quantityPlaced+=order.getQtyPlaced();
				
				limitPrice.add(order.getLimitPrice());
				stopPrice.add(order.getStopPrice());
			}
			
			
			
			if(openStatus && sideStatus && symbolStatus)
			{
				if(blockSide.equals("Buy"))
				{
					blockLimitPrice=Collections.min(limitPrice);
					blockStopPrice=Collections.max(stopPrice);
					
				}
				
				else if(blockSide.equals("Sell"))
				{
					blockLimitPrice=Collections.max(limitPrice);
					blockStopPrice=Collections.min(stopPrice);
					
				}
				
				Block block =new Block();
				block.setOrderDate(blockCreationDate);
				block.setExecutedDate(blockExecutionDate);
				block.setSymbol(blockSymbol);
				block.setSide(blockSide);
				block.setOrderType(orderType);
				block.setStatus(blockStatus);
				block.setQtyPlaced(quantityPlaced);
				block.setQtyExecuted(quantityExecuted);
				block.setStopPrice(blockStopPrice);
				block.setLimitPrice(blockLimitPrice);
				
				
			
			
			}
			
			else
			{
				System.out.println("Block Creation Failed");
				
			}
			
			
			
		
	}
	


}
