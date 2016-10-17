package com.mock.project.dao;


import java.util.List;

import com.mock.project.model.Order;

public interface PMDAO<Order> extends GenericDAO<Order,List> {


	public void delete(Order object);
	Order edit(Order object);
	Order ammend(Order object);

	public void updateStatus(List order_id, String status);


}
