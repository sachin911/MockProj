package com.mock.project.jms;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class SpringIntegrationJms {

	private JmsTemplate jmsTemplate;
	private JAXBContext jaxbContext;
	private Marshaller jaxbMarshaller;

	@SuppressWarnings("resource")
	public void sendEmployee() throws JAXBException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
		SpringIntegrationJms springIntExample = (SpringIntegrationJms) context
				.getBean("springIntExample");

//		springIntExample.sendEmployee();
//		Employee emp = new Employee(1, "Joe", 37);
//		Employee emp1 = new Employee(2, "Chandler", 37);
//		List<Employee> empList = new ArrayList<Employee>();
//		empList.add(emp);
//		empList.add(emp1);
//		
//		for (Employee iter : empList) {
//			System.out.println("Queue employee " + iter + " for processing");
//			String str = marshal(iter);
//			getJmsTemplate().convertAndSend("blockQueue", str);
//		}
		
		

	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

//	public void processEmployee(Employee emp) {
//		System.out.println("Blocks: " + emp + " processed");
//	}
//
//	public String marshal(Employee object) throws JAXBException {
//		OutputStream stream = new ByteArrayOutputStream();
//		jaxbContext = JAXBContext.newInstance(Employee.class);
//		jaxbMarshaller = jaxbContext.createMarshaller();
//		jaxbMarshaller.marshal(object, stream);
//
//		return stream.toString();
//	}

}
