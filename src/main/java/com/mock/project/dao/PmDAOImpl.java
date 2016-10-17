package com.mock.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
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
		
		Query query= em.createQuery("from Order where pmid=:pmid");
		 query.setParameter("pmid",pmid);
			return query.getResultList();
	 
	 
	 }

	@Override
	public void updateStatus(Status status,List orderid) {
		//List<Order> getOrders=new ArrayList();
		//getOrders=findAll(orderid);
    for(int i=0; i<orderid.size();i++){
			
			Long o_id= (Long) orderid.get(i);
			 Query query=em.createQuery("update Order set status =:status" + " where orderid = :o_id");
			 
			  
			query.setParameter("status", status);
			query.setParameter("o_id", o_id);

     }


	}


//	@Override
//	public Object add(Object entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public void delete(Object object) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Object edit(Object object) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Object ammend(Object object) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
}
