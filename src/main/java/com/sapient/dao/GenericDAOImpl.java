package com.sapient.dao;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;


import com.sapient.model.User;

//@Repository
//@org.springframework.transaction.annotation.Transactional(propagation=Propagation.REQUIRED)


//@Repository
//@org.springframework.transaction.annotation.Transactional(propagation=Propagation.REQUIRED)
//@Transactional(propagation = Propagation.REQUIRED)
public  class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private final Class<T> type;

	@PersistenceContext
	protected EntityManager em;

	public GenericDAOImpl() {
	//	this.type = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	
		this.type = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		//System.out.println(this.type);
	}

	public GenericDAOImpl(Class<T> type, EntityManager em) {
		this.type = type;
		this.em = em;
	}

	@Override
	public T save(T entity) {
		EntityTransaction trxn=em.getTransaction();
		try {
			trxn.begin();
			em.persist(entity);
			trxn.commit();
			
		} catch (Exception e) {
			trxn.begin();
			trxn.rollback();
			trxn.commit();
		}
		
		return entity;
	}

	@Override
	public void delete(T entity) {
		
		
		EntityTransaction trxn=em.getTransaction();
		try {
			trxn.begin();
			em.remove(entity);
			trxn.commit();
			
		} catch (Exception e) {
			trxn.rollback();
			
		}
		
	}

	@Override
	public T findByPrimaryKey(ID id) {
	
		return em.find(type, id);
	}

	
	

	

}