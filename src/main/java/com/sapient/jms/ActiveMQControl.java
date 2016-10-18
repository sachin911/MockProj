package com.sapient.jms;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

public class ActiveMQControl {
	
	BrokerService broker;
	
	public void startBroker() throws URISyntaxException, Exception{
		broker = BrokerFactory.createBroker(new URI("broker:(tcp://localhost:61616)"));
		if(!broker.isStarted()){
			broker.start();
		}

	}
	
	public void stopBroker() throws Exception{
		broker.stop();
	}
	
}
