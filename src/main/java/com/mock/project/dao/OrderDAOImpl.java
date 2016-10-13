package com.mock.project.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.sapient.mockProject.pojo.Order;

@Repository
public class OrderDAOImpl extends GenericDAOImplementation<Order> implements OrderDAO{

	
	private EntityManager em;

	 @SuppressWarnings("unchecked")
	 @Override 
	 public List<Order> findAll() {
	
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
