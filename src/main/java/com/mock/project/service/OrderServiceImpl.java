package com.mock.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.project.dao.OrderDAO;
import com.mock.project.model.*;


@Service("Order service")
@Transactional
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDAO dao;
	
	@Override
	public List<Order> display() {
		
		return dao.findAll();
	}
	@Override
	public void updateStatus(long block_id, List order_id) {
		
		dao.updateStatus(block_id, order_id);
		
	}

}
