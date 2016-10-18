package com.mock.project.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.project.dao.Order1DAO;
import com.mock.project.model.Block;
import com.mock.project.model.Order1;

@Service("Order1Service")
@Transactional
public class Order1ServiceImpl implements Order1Service {

	@Autowired
	private Order1DAO dao;
	

	/*
	 * @Override public List<Order> displaylist() { System.out.println("hello");
	 * return dao.findAll(); }
	 * 
	 * @Override public List<Order> display(int traderId) {
	 * 
	 * return dao.findAll(traderId);
	 * 
	 * }
	 * 
	 * @Override public void updateStatusInOrder(long block_id, List order_id) {
	 * 
	 * dao.updateStatus(block_id, order_id);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public void updateStatus(String status, List block_id) { Status
	 * currentStatus = Status.valueOf(status); Status changeStatus;
	 * switch(currentStatus){ case New : changeStatus = Status.Open; break; case
	 * Open : changeStatus = Status.Pending; break; default : changeStatus =
	 * Status.Error; } dao.updateBlock(changeStatus, block_id); }
	 * 
	 * @Override public void addOrder(Order d) { dao.add(d);
	 * 
	 * }
	 */
	@Override
	public void allocateorder(Block block) {
		System.out.println("inside order service");
		dao.allocateorder(block);

		// TODO Auto-generated method stub

	}

	/*
	 * @Override public List<Order> displaylist() { // TODO Auto-generated
	 * method stub return null; }
	 * 
	 * @Override public List<Order> display(int traderId) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public void updateStatusInOrder(long block_id, List order_id) {
	 * // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public void addOrder(Order d) { // TODO Auto-generated method
	 * stub
	 * 
	 * }
	 * 
	 * @Override public void updateStatus(String status, List block_id) { //
	 * TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * 
	 */
	@Override
	public void save(Order1 order) {
		// TODO Auto-generated method stub
		dao.add(order);
	}

	@Override
	public void updatereceivedblock(Block block) {
		// TODO Auto-generated method stub
		
		
	}
}
