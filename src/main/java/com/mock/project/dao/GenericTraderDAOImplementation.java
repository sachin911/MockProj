package com.mock.project.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



public class GenericTraderDAOImplementation<T> implements GenericTraderDAO<T> {

	@PersistenceContext
	private EntityManager em;

	@Override


	public void add(T object) {

		em.persist(object);


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

	public void remove(T object) {

		em.remove(object);

	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/*@SuppressWarnings("unchecked")
	@Override
	public List<T> displayAll(T object) {

		return em.createQuery("from User").getResultList();

	}*/




}
