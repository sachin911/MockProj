package com.mock.project.dao;


import java.util.List;

import com.mock.project.model.Order;
import com.mock.project.model.Status;

public interface PMDAO<Order> extends GenericDAO<Order,Long> {




	List<Order> findAll(Long pmid);
	//public void updateStatus(String status,List order_id);

	Order edit(Order object);

	Order ammend(Order object);

	List<Order> findAll();


}
