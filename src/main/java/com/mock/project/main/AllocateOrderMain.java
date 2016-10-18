package com.mock.project.main;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.mock.project.config.AppConfig;
import com.mock.project.model.Block;
import com.mock.project.model.Order1;
import com.mock.project.service.BrokerService;
import com.mock.project.service.Order1Service;

public class AllocateOrderMain {

	public static void main(String[] args) {
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);// Application
																										// context-eager
																										// loading

		container.registerShutdownHook();
		System.out.println("Inside main");
		Order1Service order1service = (Order1Service) container.getBean("Order1Service");
		BrokerService bs = (BrokerService) container.getBean("Broker service");
		Order1 order = new Order1();
		order.setSymbol("GOOGL");
		order.setAccountType("Cash");
		order.setBlockId(1L);
		order.setExecutedDate(new Date());
		order.setQtyExecuted(50);
		order.setStatus("SentforExecution");
		// order1service.save(order);
		Block block = new Block();
		block.setBlockId(8L);
		block.setQtyExecuted(220);
		block.setExecutedDate(new Date("10/18/2016"));
		block.setStatus("PartiallyAllocated");
		bs.saveblock(block);
		//order1service.allocateorder(block);
		System.out.println("Inside main1");

		container.close();
	}
	

}
