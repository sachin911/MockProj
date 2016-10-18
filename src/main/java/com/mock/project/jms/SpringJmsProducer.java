package com.mock.project.jms;

import javax.jms.Destination;

import org.springframework.jms.core.JmsTemplate;

public class SpringJmsProducer {
 private Destination destination;
 private JmsTemplate jmsTemplate;

 public SpringJmsProducer(Destination destination, JmsTemplate jmsTemplate) {
	super();
	this.destination = destination;
	this.jmsTemplate = jmsTemplate;
}
 
 
}
