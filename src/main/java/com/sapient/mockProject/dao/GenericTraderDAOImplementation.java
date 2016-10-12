package com.sapient.mockProject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericTraderDAOImplementation<T> implements GenericTraderDAO<T> {

	@PersistenceContext
	private EntityManager em;

	@Override

	public void add(T entity) {
		em.persist(entity);

	}

	@Override
	public void delete(T entity) {

		em.remove(entity);

	}

	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Override public List<T> findAll() {
	 * 
	 * return em.createQuery("from User").getResultList(); }
	 */

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub

	}
}
