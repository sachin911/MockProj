package com.mock.project.service;

import java.util.List;

import javax.persistence.Query;

import com.mock.project.dao.PMDAO;
import com.mock.project.model.Order;

public class PMServiceImplementation implements PMServices {

	private PMDAO dao;
	
	@Override
	public void saveOrder(Order order) {
		dao.add(order);		
	}

	@Override
	public void editOrder(Order order) {
		dao.edit(order);	
	}

	@Override
	public void ammendOrder(Order order) {
		dao.ammend(order);
	}

	@Override
	public List<Order> findAllOrders() {
		return dao.findAll();
	}

	@Override
	public Order findByPrimaryKey(Long id) {
		return (Order) dao.findByPrimaryKey(id);
	}

public List<Order> displayForPM(Long pmid) {
		
		return dao.findAll(pmid);
	}
}
