package com.mock.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


import com.mock.project.model.Block;
import com.mock.project.model.Order;




import com.mock.project.model.Status;

import com.mock.project.model.Order;




@Repository
public class OrderDAOImpl extends GenericDAOImplementation<Order, Long> implements OrderDAO{

	@PersistenceContext
	private EntityManager em;
	

	 @SuppressWarnings("unchecked")
	 @Override 
	 public List<Order> findAll() {
	//	 System.out.println("hey");
	List<Order> l=new ArrayList<Order>();
	//System.out.println("malvika");
	Query query=em.createQuery("from Order where block_id is null");
	//System.out.println("mm");
	List<Order>l1=query.getResultList();
	//System.out.println("mmee");
	//System.out.println("oshin");
	for(Order i:l1){
		//System.out.println("aish");
		//System.out.println(i);
	}
//	System.out.println("madie");
	return query.getResultList(); 
	 }

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findAll(int traderId) {

		Query query = em.createQuery("from Order where trader_id =:traderId");
		query.setParameter("traderId", traderId);

		return query.getResultList();
	}

	

	@Override
	public void updateStatus(long block_id, List order_id) {
		for (int i = 0; i < order_id.size(); i++) {

			long o_id = (Long) order_id.get(i);
			Query query = em.createQuery("update Order set block_id =:block_id" + " where order_id = :o_id");
			query.setParameter("block_id", block_id);
			query.setParameter("o_id", o_id);
		}

	}

	@Override
	public void updateBlock(Status changeStatus, List block_id) {
		for (int i = 0; i < block_id.size(); i++) {

			long b_id = (Long) block_id.get(i);
			Query query = em.createQuery("update order set status =:status" + "where block_id = :b_id");
			query.setParameter("status", changeStatus);
			query.setParameter("b_id", b_id);
		}
	}

	@Override
	public List<Order> findOrder(int orderId) {
		// TODO Auto-generated method stub
		//System.out.println("asdjdsak: "+orderId);
		List<Order> orders=new ArrayList<Order>();
			Query query=em.createQuery("from Order where order_Id=:orderId"+" and block_id is null");
		query.setParameter("orderId",orderId);
			//System.out.println(query);
		orders=query.getResultList();
		//System.out.println(orders.get(0));
		
		return orders;
		
	}

	@Override
	public void addBlock(Block block) {
		// TODO Auto-generated method stub
		em.persist(block);
	}

}
