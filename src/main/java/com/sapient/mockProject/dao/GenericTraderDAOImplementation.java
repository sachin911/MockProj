package com.sapient.mockProject.dao;


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
	public void remove(T object) {

		em.remove(object);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> displayAll(T object, String table) {

		return em.createQuery("from " + table).getResultList();

	}


}
