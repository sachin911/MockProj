package com.mock.project.jms;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import com.mock.project.model.*;

public class MarshallAndSend {

	private JmsTemplate jmsTemplate;

	private JAXBContext jaxbContext;
	private Marshaller jaxbMarshaller;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws URISyntaxException, Exception {

	}

	public void marshallAndSendBlock(Block block) throws JAXBException {
		String convertedObj = marshal(block);
		getJmsTemplate().convertAndSend("blockQueue", convertedObj);
	}


	public void sendExecutedBlock(List<Block> blockList) throws URISyntaxException, Exception, JAXBException {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
		 MarshallAndSend ms= (MarshallAndSend) context.getBean("MessageProducer");

		 Object broker = BrokerFactory.createBroker(new
		 URI("broker:(tcp://localhost:61616)"));
		 ((BrokerService) broker).start();

		Date current = new Date();

		if (blockList == null) {
			System.out.println("The list is empty. Please send a list of blocks------------");
			System.exit(0);
		}

		for (Block iter : blockList) {
			System.out.println("The Block being sent is" + iter);
			ms.marshallAndSendBlock(iter);
		}
	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public String marshal(Block object) throws JAXBException {
		OutputStream stream = new ByteArrayOutputStream();
		jaxbContext = JAXBContext.newInstance(Block.class);
		jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.marshal(object, stream);

		return stream.toString();
	}

}
