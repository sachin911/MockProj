package com.mock.project.dao;

import com.mock.project.model.Order;

public interface PMDAO<Order> extends GenericDAO<Order,Long> {

	public void delete(Order object);
	Order edit(Order object);
	Order ammend(Order object);

}
