package com.mock.project.service;

import java.util.List;

import com.mock.project.model.Block;
import com.mock.project.model.Order;

public interface TraderService {
	
	List<Order> display();
	
	List<Block> recommendationsToAddToBlock(Order order);
	
	void updateStatus(long block_id,List order_id);
	
	void createBlock(List<Order> orders);
	

}
