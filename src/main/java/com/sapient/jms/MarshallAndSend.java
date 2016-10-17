package com.sapient.jms;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import com.sapient.model.Block;
import com.sapient.model.Employee;


public class MarshallAndSend {

	private JmsTemplate jmsTemplate;

	private JAXBContext jaxbContext;
	private Marshaller jaxbMarshaller;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws URISyntaxException, Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MarshallAndSend ms= (MarshallAndSend) context
				.getBean("MessageProducer");

		ActiveMQControl mq = new ActiveMQControl();
		mq.startBroker();

		ms.sendEmployee();
	}
	
	
	public void marshallAndSendBlock(Block block) throws JAXBException{
		String convertedObj = marshal(block);
		getJmsTemplate().convertAndSend("blockQueue", convertedObj);
	}
	
	
	//testing purpose
	public void sendEmployee() throws JAXBException {
		Employee emp = new Employee(1, "Joe", 37);
		Employee emp1 = new Employee(2, "Chandler", 37);
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(emp);
		empList.add(emp1);
		for (Employee iter : empList) {
			System.out.println("Queue employee " + iter + " for processing");
			String str = marshal(iter);
			getJmsTemplate().convertAndSend("blockQueue", str);
		}

	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}


	//this is for testing
	public String marshal(Employee object) throws JAXBException {
		OutputStream stream = new ByteArrayOutputStream();
		jaxbContext = JAXBContext.newInstance(Employee.class);
		jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.marshal(object, stream);

		return stream.toString();
	}

	
	public String marshal(Block object) throws JAXBException {
		OutputStream stream = new ByteArrayOutputStream();
		jaxbContext = JAXBContext.newInstance(Block.class);
		jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.marshal(object, stream);

		return stream.toString();
	}

	
}
