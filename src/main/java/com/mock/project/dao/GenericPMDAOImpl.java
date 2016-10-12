package com.mock.project.dao;

import java.util.List;

import javax.persistence.EntityManager;

public class GenericPMDAOImpl<T> implements GenericPMDAO<T> {

	private EntityManager em;
	
	@Override
	public void add(T object) {
		em.persist(object);
	}

	@Override
	public void remove(T object) {
		em.remove(object);
	}

	@Override
	public void update(T object) {
		em.merge(object);
	}

	@Override
	public List<T> displayAll(T object, String table) {
		return em.createQuery("from " + table + " ").getResultList();
	}
	
	

}
