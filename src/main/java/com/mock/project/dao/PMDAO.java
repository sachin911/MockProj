package com.mock.project.dao;


import java.util.List;

import com.mock.project.model.Order;
import com.mock.project.model.Status;

public interface PMDAO<Order> extends GenericDAO<Order,Long> {




	List<Order> findAll(Long pmid);
	public void updateStatus(Status status,List order_id);

	Order edit(Order object);

	Order ammend(Order object);

	List<Order> findAll();
	
	List<Order> findAllByName(String name, Long id);
	
	List<Order> findAllByID(Long id);
	
	public Long getTraderId(String traderName);

}
