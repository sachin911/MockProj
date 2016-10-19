package com.mock.project.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.mock.project.model.Order;
import com.mock.project.model.Portfolio;
import com.mock.project.model.Status;



public interface PMServices {


//	public void editOrder(Order order);
//	public void ammendOrder(Order order);
	public void findOrderForUpdate(Long id);
	

	public void addPort(Portfolio p);
	public List<Order> findAllOrdersInPortfolio(String name, Long pmid);
	public List<Order> findAllOrdersInPortfolio(Long id);
	public Long getTraderId(String traderName);
	public Long getPortfolioId(String portfolioName);
	void updateStatus(List order_id);
	List<Order> displayForPMAfterSend(Long pmId);
	
	List<String> getTraderNameList();
	public String getUserName(Long id);
	public List<Order> displayPendingForPM(Long pmId);
	
}
