package com.mock.project.dao;

import java.util.List;


import com.mock.project.model.Status;


import com.mock.project.model.Order;



public interface OrderDAO extends GenericDAO<Order, Long>
{
	List<Order> findAll(int traderId);
	

	void updateStatus(long block_id,List order_id);
	void updateBlock(Status changeStatus, List block_id);

}
