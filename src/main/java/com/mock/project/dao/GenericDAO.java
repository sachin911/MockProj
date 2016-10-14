package com.mock.project.dao;

import java.util.List;


public interface GenericDAO<T> {

	void add(T entity);

	void delete(T entity);

	List<T> findAll();

	T findByPrimaryKey(T id);


}
