package com.mock.project.dao;


import java.lang.reflect.ParameterizedType;
import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



public class GenericDAOImplementation<T,ID extends Serializable> implements GenericDAO<T,ID> {
	
	private final Class<T> type;
	@PersistenceContext
	private EntityManager em;

	
	@SuppressWarnings("unchecked")
	public GenericDAOImplementation() {
        //            this.type = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        
                        this.type = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
                        //System.out.println(this.type);
        }

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

	@Override
	public T findByPrimaryKey(T id) {
		// TODO Auto-generated method stub
		return null;
	} 



}
