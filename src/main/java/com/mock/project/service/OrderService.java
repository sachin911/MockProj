package com.mock.project.service;

import java.util.List;

import com.mock.project.model.*;



public interface OrderService {

	
	List<Order> displaylist(int traderId);

	List<Order> displaylistPendingOrder(int traderId);
	
	List<Block> displayBlock(int i);

	List<Order> findOrders(Long block_id);
	

	void updateStatusInOrder(long block_id,List order_id);

	public void addOrder(Order d);
	void updateStatus(String status, List block_id);

	 public List<Block> recommend(List<Integer> selectedOrders);


	Order findOrderByOrderId(int orderId);


	Block findBlockByBlockId(int blockId);

	void allocateorder(Block block);

	List<Order> findOrdersInBlock(int blockId);

	List<Block> displayBlockHistory(int traderId);

	void removeBlock(Block b);

	void removeOrderFromBlock(List<Integer> orderId);

	

	


}