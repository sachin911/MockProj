package com.mock.project.dao;

import java.util.List;

import com.mock.project.model.Block;
import com.mock.project.model.Order;




import com.mock.project.model.Status;


import com.mock.project.model.Order;



public interface OrderDAO extends GenericDAO<Order, Long>
{
	List<Order> findAll(int traderId);
	List<Block> recommend(List<Integer> selectedOrders);
	void addToThisBlock(Order order, Integer selectedBlock);
	List<Block> findAllBlocks(int traderId);
	List<Block> findAllBlocksHistory(int traderId);
	List<Order> findOrder(int orderId);
	void updateStatus(long block_id,List order_id);
	void updateBlock(Status changeStatus, List<Block> block_id);
	void addBlock(Block block);
	Block findBlock(int blockId);
	void allocateorder(Block block);
	List<Order> findOrdersInBlock(int blockId);
	List<Order> findAll();
	void deleteBlock(Block b);
	List<Order> getOrdersInBlock(Long block_id);

	
}

