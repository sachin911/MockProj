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
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;


import com.mock.project.model.*;



public class MarshallAndSend {

	private JmsTemplate jmsTemplate;

	private JAXBContext jaxbContext;
	private Marshaller jaxbMarshaller;

	
		
	public void marshallAndSendBlock(Block block) throws JAXBException{
		String convertedObj = marshal(block);
		getJmsTemplate().convertAndSend("blockQueue", convertedObj);
	}
			
	@SuppressWarnings("resource")
	public void sendExecutedBlock(List<Block> blockList) throws URISyntaxException, Exception, JAXBException{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
		MarshallAndSend ms= (MarshallAndSend) context
				.getBean("MessageProducer");

		
		Object broker = BrokerFactory.createBroker(new URI("broker:(tcp://localhost:61616)"));
		((AbstractApplicationContext) broker).start();
		
		Date current=new Date();
		
		/*Block obj=new Block("BUY","sachin",300L,"MARKET","OPEN",200.0,300.0,100L,current,120.0); 
		Block obj1=new Block("BUY1","narasimhan",300L,"MARKET1","OPEN1",200.0,300.0,100L,current,120.0);
		List<Block> blockList = new ArrayList<Block>();
		blockList.add(obj);
		blockList.add(obj1);
		
		ms.sendExecutedBlock(blockList);
		
		//ms.sendEmployee();
*/		
		
		if(blockList == null){
			System.out.println("The list is empty. Please send a list of blocks------------");
			System.exit(0);
		}
		
		for(Block iter : blockList){
			System.out.println("The Block being sent is" + iter);
			System.out.println("The Block being sent is" + iter);
			marshallAndSendBlock(iter);
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
