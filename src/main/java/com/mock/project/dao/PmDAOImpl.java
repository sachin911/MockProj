package com.mock.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mock.project.model.Order;
import com.mock.project.model.Status;

@Repository
public class PmDAOImpl extends GenericDAOImplementation<Order, Long> implements PMDAO<Order> {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")

	@Override
	public List<Order> findAll(Long pmid) {
		List<Order> list = new ArrayList<>();
		Query query = em.createQuery("from Order where pm_id= :pmid");
		query.setParameter("pmid", pmid);

		list = query.getResultList();
		//System.out.println(list);
		return list;

	}
	
		

	
	
	@Override
	public Order edit(Order object) {
		em.persist(object);
		return object;
	}
	@Override
	public Order ammend(Order object) {
		em.persist(object);
		return object;
	}
	
	public void remove(Order object) {
		em.remove(object);
	}

	@Override
	public Order findByPrimaryKey(Order id) {
		// TODO Auto-generated method stub
		return null;
	}

	// @Override
	// public void updateStatus(Status status,List orderid) {
	// List<Order> getOrders=new ArrayList();
	// getOrders=findAll(orderid);
	// for(int i=0; i<orderid.size();i++){
	//
	// Long o_id= (Long) orderid.get(i);
	// Query query=em.createQuery("update Order set status =:status" + " where
	// orderid = :o_id");
	//
	//
	// query.setParameter("status", status);
	// query.setParameter("o_id", o_id);
	//
	// }

	// @Override
	// public void updateStatus(String status, List order_id) {
	// // TODO Auto-generated method stub
	// for(int i=0; i<order_id.size();i++){
	//
	// Long o_id= (Long) order_id.get(i);
	// Query query=em.createQuery("update Order set status =:status" + " where
	// orderid = :o_id");
	//
	//
	// query.setParameter("status", status);
	// query.setParameter("o_id", o_id);
	//
	// }
	//

}

// @Override
// public Object add(Object entity) {
// // TODO Auto-generated method stub
// return null;
// }

// @Override
// public void delete(Object object) {
// // TODO Auto-generated method stub
//
// }
//
// @Override
// public Object edit(Object object) {
// // TODO Auto-generated method stub
// return null;
// }
//
// @Override
// public Object ammend(Object object) {
//// // TODO Auto-generated method stub
// return null;
// }
////
