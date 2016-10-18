package com.mock.project.service;

import java.util.List;

import com.mock.project.model.*;



public interface OrderService {

	
	List<Order> displaylist(int traderId);

	List<Order> displaylist();
	
	List<Block> displayBlock(int i);

	

	void updateStatusInOrder(long block_id,List order_id);

	public void addOrder(Order d);
	void updateStatus(String status, List block_id);

	 public List<Block> recommend(List<Integer> selectedOrders);


	Order findOrderByOrderId(int orderId);


	Block findBlockByBlockId(int blockId);


}