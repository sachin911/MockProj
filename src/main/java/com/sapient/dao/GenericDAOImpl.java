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

//@Repository
//@org.springframework.transaction.annotation.Transactional(propagation=Propagation.REQUIRED)

public abstract class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private Class<T> type;
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		// TODO Auto-generated constructor stub
		this.type = (Class<T>)((ParameterizedType)this.getClass()
				.getGenericSuperclass())
				.getActualTypeArguments()[1];
				
	}
	
	public GenericDAOImpl(Class<T> type, EntityManager em) {
		this.type = type;
		this.em = em;
	}

	@Override
	//@org.springframework.transaction.annotation.Transactional(propagation=Propagation.REQUIRED)
	public T save(T entity) {
		
		//em.persist(em.contains(entity) ? entity : em.merge(entity));
		em.persist(entity);
		
		return entity;
	}

	@Override
	public void delete(T entity) {

//		EntityTransaction trxn = em.getTransaction();
//		try {
//			trxn.begin();
		em.remove(em.contains(entity) ? entity : em.merge(entity));
			//em.remove(entity);
//			trxn.commit();
//
//		} catch (Exception e) {
//			trxn.rollback();
//
//		}

	}

	@Override
	public T findByPrimaryKey(ID id) {

		return em.find(type, id);
	}

	/*@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {

	return em.createQuery("from ShoppingCart").getResultList();
	}*/
	
	
	
	
}