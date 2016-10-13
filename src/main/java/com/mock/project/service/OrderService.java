package com.mock.project.service;

import java.util.List;


import com.mock.project.model.*;


public interface OrderService {
	
	List<Order> display();
	
	public void addOrder(Order d);
	void updateStatus(long block_id,List order_id);

}
