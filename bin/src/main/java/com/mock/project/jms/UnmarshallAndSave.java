package com.mock.project.jms;

import java.io.ByteArrayInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import com.mock.project.config.AppConfig;
import com.mock.project.main.AllocatedOrder;
import com.mock.project.model.*;
import com.mock.project.service.BrokerService;
import com.mock.project.service.BrokerServiceImpl;

/*
 * This is the service that listens to the processBlockChannel and activates whenever there is an item in it.
 * This will unmarshall the string into block object and saves it into the DB
 */
public class UnmarshallAndSave {
	private JmsTemplate jmsTemplate;
	private JAXBContext jaxbContext;
	private Marshaller jaxbMarshaller;
	private Unmarshaller jaxbUnmarshaller = null;

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
//		ServiceActivator springIntExample = (ServiceActivator) context.getBean("springIntExample");

	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}


	public void processBlocksFromQueue(String blockAsString) {

		System.out.println(blockAsString);
//		ApplicationContext ac = new AnnotationConfigApplicationContext();
//		BrokerService brokerService = ac.getBean(BrokerService.class);
		try {
			System.out.println("reached the unmarshal");
			
			Block blockToSave = unmarshal(blockAsString);
			
			System.out.println("go from unmarshal");
			
			saveTheBlocks(blockToSave);
			
			// save the unmarshalled block object to the database
		} 
		catch (JAXBException e) {
			e.printStackTrace();
		}
		finally {
			//container.close();
		}
	}
	
	
	public void saveTheBlocks(Block block){
		
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(com.mock.project.config.AppConfig.class);
		container.registerShutdownHook();
		
		System.out.println("comes from unmarshal");
		
		BrokerService brokerService = container.getBean(BrokerService.class);
		
		//BrokerService brokerService  = (BrokerService) container.getBean("brokerService");
		System.out.println("reached here before the service");
		brokerService.saveblock(block);
		AllocatedOrder ao=new AllocatedOrder();
		ao.allocate(block);
	
		container.close();
	}
	
	public Block unmarshal(String objectAsString) throws JAXBException {
		jaxbContext = JAXBContext.newInstance(Block.class);
		jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		try {
			return (Block) jaxbUnmarshaller.unmarshal(new ByteArrayInputStream(objectAsString.getBytes()));
		} catch (JAXBException e) {
			// LOGGER.error("Exception occured while marshalling", e);
			System.out.println("error occured");
		}
		return null;
	}
	
	
	
}
