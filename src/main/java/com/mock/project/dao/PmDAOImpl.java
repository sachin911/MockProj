package com.mock.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mock.project.model.Order;

@Repository
public class PmDAOImpl implements PMDAO {

	private EntityManager em;

	 @SuppressWarnings("unchecked")

	@Override
	public List<Order> findAll(List oid) {
		
		 return em.createQuery("from order where order_id=:o_id").getResultList();
	}

	@Override
	public void updateStatus(List orderid,String status) {
		
		
		List<Order> getOrders=new ArrayList();
		getOrders=findAll(orderid);
for(int i=0; i<getOrders.size();i++){
			
			Order o_id= getOrders.get(i);
			 Query query=em.createQuery("update order set status =:open" + " where orderid = :o_id");
			 
			  
			query.setParameter("open", status);
			query.setParameter("orderid", o_id);

     }


	}

//	@Override
//	public Object add(Object entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Object findByPrimaryKey(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object edit(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object ammend(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
