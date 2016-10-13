package com.mock.project.dao;

import java.util.List;


public interface GenericTraderDAO<T> {

	void add(T entity);

	void delete(T entity);
	
	List<T> findAll();

	void update(T entity);

	



}
