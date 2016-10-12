package com.mock.project.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



public class GenericDAOImplementation<T> implements GenericDAO<T> {

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
	public List<T> findAll() {

		return em.createQuery("from Order").getResultList();

	}



	public void remove(T object) {

		em.remove(object);

	}




}
