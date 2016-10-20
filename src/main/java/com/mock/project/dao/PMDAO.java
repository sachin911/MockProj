package com.mock.project.dao;


import java.util.List;

import com.mock.project.model.Order;
import com.mock.project.model.Status;

public interface PMDAO<Order> extends GenericDAO<Order,Long> {




	
	public void updateStatus(Status status,List order_id);

	void edit(Order order);

	Order ammend(Order object);

	List<Order> findAll();
	
	List<Order> findAllByName(String name, Long id);
	
	List<Order> findAllOrdersByID(Long id);
	
	List<Order> findAllStatusNew(Long pmId,Status status);
	public Long getPortfolioId(String portfolioName);
	public Long getTraderId(String traderName);
	public List<String> getTraderNameList();
	
	//Fetch a user's name based on ID
	public String getUserNameFromID(Long id);

	public void findOrderForDrop(Long id);
	public Order findOrderForEdit(Long id);
}
