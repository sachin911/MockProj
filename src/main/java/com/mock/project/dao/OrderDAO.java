package com.mock.project.dao;

import java.util.List;

import com.mock.project.model.Order;


public interface OrderDAO extends GenericDAO<Order>
{
	List<Order> findAll();
	
	public void updateStatus(long block_id,List order_id);
}
