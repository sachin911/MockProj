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


@Service("Trader service")
@Transactional
public class TraderServiceImpl implements TraderService {

	@Autowired

	private OrderDAO dao=new OrderDAOImpl();
	static private List<Order> listOforder;
	
    @Override
    public void addToBlock(List<Order> listOforder) {
    	TraderServiceImpl.listOforder=listOforder;
          // System.out.println("addtoblock:::::"+listOforder);
           
    }
   @Override
    public void addToSelectedBlock(Integer selectedBlock) {
	  // System.out.println("selected");
	  // System.out.println("addtoselectedblock:::::"+TraderServiceImpl.listOforder);
             for(Order order:listOforder){
            	// System.out.println(order);
                    dao.addToThisBlock(order,selectedBlock);
             }
          //   System.out.println("selectedblock");
    }       

	@Override
	public void createBlock(List<Order> orders)
	{
		
		//conditions to be checked
		Boolean openStatus=false;
		Boolean symbolStatus=false;
		Boolean sideStatus=false;
		Boolean orderTypeStatus=false;
		
		//Fields of the block
		String blockSymbol=orders.get(0).getSymbol();
		String blockSide=orders.get(0).getSide();
		//System.out.println(blockSide);
		Date blockCreationDate=new Date();
		Date blockExecutionDate=null;
		String orderType=orders.get(0).getOrderType();
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
			//System.out.println("here"+ order);
			orderId.add(order.getOrderId());
			
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
			
			if((order.getOrderType()).equals(orderType))
			{
				
				orderTypeStatus=true;
			}
			else
			{
				
				orderTypeStatus=false;
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
			if((order.getSide()).equals(blockSide))
			{
				//System.out.println("success"+ blockSide);
				sideStatus=true;
				
			}
			
			else
			{
				//System.out.println("fail"+ blockSide);
				sideStatus=false;
				break;
			}
			
			quantityPlaced+=order.getQtyPlaced();
			
			limitPrice.add(order.getLimitPrice());
			stopPrice.add(order.getStopPrice());
		}
		
		//System.out.println(openStatus+" "+sideStatus+ " "+ symbolStatus);
		
		if(openStatus && sideStatus && symbolStatus && orderTypeStatus)
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
			
		
			//System.out.println(block);
			dao.addBlock(block);
			
		//	System.out.println("asdkdasjas: "+block.getBlockId());
			
			dao.updateStatus(block.getBlockId(),orderId);
			//insert all the orders into block
			//Write Code Here
			//write the value of block_id in order Table
		
		
		
		}
		
		else
		{
			System.out.println("Block Creation Failed");
			
		}
		
		
		
		
	
	
		
		
		
	}

}
