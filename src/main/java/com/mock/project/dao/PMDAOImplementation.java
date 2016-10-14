package com.mock.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.mock.project.model.Order;

public class PMDAOImplementation implements PMDAO<Order> {

	private List<String> type;
	@PersistenceContext
	private EntityManager em;
	
	
	public PMDAOImplementation(List<String> type, EntityManager em) {
		super();
		this.type = type;
		this.em = em;
	}
	
	public PMDAOImplementation(List<String> type) {
		super();
		this.type = type;
	}


	public PMDAOImplementation() {
		super();
	}

	@Override
	public Order add(Order object) {
		System.out.println("DAO : " + object);
		em.persist(object);
		return object;	
	}
	
	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(Order object) {
		EntityTransaction trxn = em.getTransaction();
		try {
			trxn.begin();
			em.remove(object);
			trxn.commit();
		} catch (Exception e) {
			trxn.rollback();
		}
		
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

	
}