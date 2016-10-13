package com.mock.project.dao;

import java.util.List;

import com.sapient.mockProject.pojo.Order;


public interface OrderDAO extends GenericTraderDAO<Order>
{
	List<Order> findAll();
	
	void updateStatus(long block_id,List order_id);
}
