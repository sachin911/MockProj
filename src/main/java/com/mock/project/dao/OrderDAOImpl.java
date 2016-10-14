package com.mock.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mock.project.model.Order;



@Repository
public class OrderDAOImpl extends GenericTraderDAOImplementation<Order> implements OrderDAO{

	
	private EntityManager em;

	 @SuppressWarnings("unchecked")
	 @Override 
	 public List<Order> findAll() {
		 System.out.println("hey");
	List<Order> l=new ArrayList<Order>();
	System.out.println("malvika");
	List<Order> l1=( em.createQuery("from orders")).getResultList();
	System.out.println(l1);
	System.out.println("oshin");
	for(Order i:l1){
		System.out.println("aish");
		System.out.println(i);
	}
	System.out.println("madie");
	return em.createQuery("from order where block_id is null").getResultList(); 
	 }

	@Override
	public void updateStatus(long block_id,List order_id) {
		for(int i=0; i<order_id.size();i++){
			
			long o_id=(Long) order_id.get(i);
		    em.createQuery("update order set block_id =:block_id" + " where order_id = :o_id");
		}

		
	}
	 
}
