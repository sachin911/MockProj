package com.mock.project.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.mock.project.model.Order;
import com.mock.project.model.Portfolio;



public interface PMServices {

//	public void saveOrder(Order order);
//	public void editOrder(Order order);
//	public void ammendOrder(Order order);
//	public List<Order> findAllOrders();
//	public Order findByPrimaryKey(Long id);
	List<Order> displayForPM(Long pmid);
	public void addPort(Portfolio p);
}
