package com.mock.project.main;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.mock.project.config.AppConfig;
import com.mock.project.model.Block;
import com.mock.project.model.Order;


import com.mock.project.service.OrderService;
import com.mock.project.service.BrokerService;

public class AllocatedOrder {

	public static void main(String[] args) {
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);// Application
																										// context-eager
																										// loading

		container.registerShutdownHook();
		System.out.println("Inside main");
		OrderService order1service = (OrderService) container.getBean("Order service");
		BrokerService bs = (BrokerService) container.getBean("Broker service");
		Order order = new Order();
		order.setSymbol("GOOGL");
		order.setAccountType("Cash");
		order.setBlockId(1L);
		order.setExecutedDate(new Date());
		order.setQtyExecuted(50);
		order.setStatus("SentforExecution");
		// order1service.save(order);
		Block block = new Block();
		block.setBlockId(11440L);
		block.setQtyExecuted(220);
		block.setExecutedDate(new Date("10/18/2016"));
		block.setStatus("PartiallyAllocated");
		bs.saveblock(block);
		order1service.allocateorder(block);
		System.out.println("Inside   line 42 main1");

		container.close();
	}
	
	public void allocate(Block block)
	{
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		

container.registerShutdownHook();

OrderService order1service = (OrderService) container.getBean("Order service");

order1service.allocateorder(block);

	}

}
