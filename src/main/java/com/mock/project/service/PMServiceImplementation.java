package com.mock.project.service;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.project.dao.PMDAO;
import com.mock.project.model.Order;
import com.mock.project.model.Portfolio;
import com.mock.project.model.Status;

@Service("PMService")
@Transactional

public class PMServiceImplementation implements PMServices {

	@Autowired
	private PMDAO dao;

	@Override
	public List<Order> findAllOrdersInPortfolio(String name) {
		return dao.findAllByName(name);
	}

	public List<Order> displayForPM(Long pmid) {
		return dao.findAll(pmid);
	}

	@Override
	public void addPort(Portfolio p) {
		dao.add(p);

	}

	@Override
	public void updateStatus(List order_id) {
		//System.out.println("orderid in impl" + order_id);
		Status changeStatus;
		changeStatus=Status.Open;
		dao.updateStatus(changeStatus, order_id);
	}

	/*

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
	public Order findByPrimaryKey(Long id) {
		return (Order) dao.findByPrimaryKey(id);
	}

	@Override
	public List<Order> findAllOrders() {
		return dao.findAll();
	}
	*/
}
