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

import com.sapient.model.Securities;

//@Repository
//@org.springframework.transaction.annotation.Transactional(propagation=Propagation.REQUIRED)

public class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private Class<T> type;

	@PersistenceContext
	protected EntityManager em;

	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		// TODO Auto-generated constructor stub
		this.type = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];

	}

	public GenericDAOImpl(Class<T> type, EntityManager em) {
		this.type = type;
		this.em = em;
	}

	@Override
	@org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRES_NEW)
	public T save(T entity) {
		System.out.println("should be saving now");
		em.persist(em.contains(entity) ? entity : em.merge(entity));
		System.out.println("done savinh");
		return entity;
	}

	@Override
	public T saveService(T entity) {
		EntityTransaction trxn = em.getTransaction();

		try {
			trxn.begin();
			em.persist(em.contains(entity) ? entity : em.merge(entity));
			trxn.commit();
			System.out.println("saved");
		} catch (Exception e) {
			try {
				trxn.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		
			e.printStackTrace();
			System.out.println("not saved");
		}

		return entity;
	}

	@Override
	public void delete(T entity) {

		// EntityTransaction trxn = em.getTransaction();
		// try {
		// trxn.begin();
		em.remove(em.contains(entity) ? entity : em.merge(entity));
		// em.remove(entity);
		// trxn.commit();
		//
		// } catch (Exception e) {
		// trxn.rollback();
		//
		// }

	}

	@Override
	public T findByPrimaryKey(ID id) {
	
		return  em.find(type, id);
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Override public List<T> findAll() {
	 * 
	 * return em.createQuery("from ShoppingCart").getResultList(); }
	 */

}