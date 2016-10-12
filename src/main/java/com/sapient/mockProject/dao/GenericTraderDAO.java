package com.sapient.mockProject.dao;

import java.util.List;

<<<<<<< HEAD
public interface GenericTraderDAO<T> {

	void add(T entity);

	void delete(T entity);

	/* List < T > findAll(); */
	void update(T entity);
=======


public interface GenericTraderDAO<T> {
	
	void add(T object);
	void remove(T object);
	List<T> displayAll(T object);
	void update(T object);
	
>>>>>>> refs/remotes/origin/NishchithHebbar

}
