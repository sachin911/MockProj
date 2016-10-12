package com.sapient.mockProject.dao;

<<<<<<< HEAD
=======

>>>>>>> refs/remotes/origin/NishchithHebbar
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

<<<<<<< HEAD
=======

>>>>>>> refs/remotes/origin/NishchithHebbar
public class GenericTraderDAOImplementation<T> implements GenericTraderDAO<T> {

	@PersistenceContext
	private EntityManager em;

	@Override
<<<<<<< HEAD

	public void add(T entity) {
		em.persist(entity);
=======
	public void add(T object) {

		em.persist(object);
>>>>>>> refs/remotes/origin/NishchithHebbar

	}

	@Override
<<<<<<< HEAD
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
=======
	public void remove(T object) {

		em.remove(object);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> displayAll(T object) {

		return em.createQuery("from User").getResultList();

	}

	@Override
	public void update(T object) {
		// TODO Auto-generated method stub
		
	}

>>>>>>> refs/remotes/origin/NishchithHebbar
}
