package com.sapient.jms;

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

import com.sapient.config.AppConfig;
import com.sapient.model.Block;
import com.sapient.service.BrokerService;
import com.sapient.service.BrokerServiceImpl;

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
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		ServiceActivator springIntExample = (ServiceActivator) context.getBean("springIntExample");

	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}


	public void processBlocksFromQueue(String blockAsString) {

		
//		ApplicationContext ac = new AnnotationConfigApplicationContext();
//		BrokerService brokerService = ac.getBean(BrokerService.class);
		try {
			System.out.println(unmarshal(blockAsString));
			
			Block blockToSave = unmarshal(blockAsString);
			saveTheBlocks(blockToSave);
			// save the unmarshalled block object to the database
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//container.close();
		}
		
		
		System.out.println(blockAsString);
	}
	
	public void saveTheBlocks(Block block){
		
		AbstractApplicationContext container = new AnnotationConfigApplicationContext(com.sapient.config.AppConfig.class);
		container.registerShutdownHook();
		//BrokerService brokerService = container.getBean(BrokerService.class);
		
		BrokerService brokerService  = (BrokerService) container.getBean("brokerService");
		System.out.println("reached here before the service");
		brokerService.saveblock(block);
	
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
