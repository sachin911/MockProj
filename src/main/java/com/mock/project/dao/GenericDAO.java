package com.mock.project.dao;

import java.util.List;


public interface GenericDAO<T,ID> {

	T add(T entity);

	void delete(T entity);

	List<T> findAll();




}
