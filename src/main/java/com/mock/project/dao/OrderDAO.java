package com.mock.project.dao;

import java.util.List;

import com.mock.project.model.Status;
import com.sapient.mockProject.pojo.Order;


public interface OrderDAO extends GenericDAO<Order>
{
	List<Order> findAll();
	
	void updateStatus(long block_id,List order_id);
	void updateBlock(Status changeStatus, List block_id);
}
