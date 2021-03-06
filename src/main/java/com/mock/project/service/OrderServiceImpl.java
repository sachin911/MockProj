package com.mock.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.project.dao.OrderDAO;

import com.mock.project.dao.OrderDAOImpl;
import com.mock.project.model.*;





@Service("Order service")
@Transactional
public class OrderServiceImpl implements OrderService{

	@Autowired

	private OrderDAO dao=new OrderDAOImpl();
	@Override
	public List<Order> displaylistPendingOrder(int traderId) {
		//System.out.println("hello");
		return dao.findAllOrders(traderId);
	}

	@Override
	public List<Order> displaylist(int traderId) {
		//System.out.println("inside Service");
		return dao.findAll(traderId);

	}
	@Override
	public void updateStatusInOrder(long block_id, List order_id) {
		
		dao.updateStatus(block_id, order_id);
		
	}

	
	
	public void updateStatus(String status, List block_id) {
		Status currentStatus = Status.valueOf(status);
		Status changeStatus;
		switch(currentStatus){
		case New : changeStatus = Status.Open; break;
		case Open : changeStatus = Status.Pending; break;
		default : changeStatus = Status.Error;
		}
		dao.updateBlock(changeStatus, block_id);
	}

	@Override
	public void addOrder(Order d) {
		dao.add(d);

	}
	public List<Block> recommend(List<Integer> selectedOrders) {
		return dao.recommend(selectedOrders);

	}
	

	@Override
	public Order findOrderByOrderId(int orderId)
	{
		Order order=dao.findOrder(orderId).get(0);
		return order;
	}

	@Override
	public List<Block> displayBlock(int traderId) {
		// TODO Auto-generated method stub
		return dao.findAllBlocks(traderId);
	}
	
	@Override
	public List<Block> displayBlockHistory(int traderId) {
		// TODO Auto-generated method stub
		return dao.findAllBlocksHistory(traderId);
	}
	
	@Override
	public Block findBlockByBlockId(int blockId)
	{
		Block block=dao.findBlock(blockId);
		return block;
	}
	@Override
	public void allocateorder(Block block) {
		System.out.println("inside order service");
		dao.allocateorder(block);

		// TODO Auto-generated method stub

	}

	@Override
	public List<Order> findOrdersInBlock(int blockId) {
		return dao.findOrdersInBlock(blockId);
		
	}

	@Override
	public void removeBlock(Block b) {
		
		dao.deleteBlock(b);
		
	}

	@Override
	public List<Order> findOrders(Long block_id) {
		System.out.println("Method call works");
	return	dao.getOrdersInBlock(block_id);
		
	}

	@Override
	public void removeOrderFromBlock(List<Integer> orderId) {
		dao.removeOrderFromBlock(orderId);
		
	}

	

}