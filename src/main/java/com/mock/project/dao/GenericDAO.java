package com.mock.project.dao;

import java.util.List;


import com.mock.project.model.Order;


public interface GenericDAO<T,ID> {
//
//	T add(T entity);
//
//	void delete(T entity);

	//List<T> findAll(int id);

	T findByPrimaryKey(T id);

	List<T> findAll(List id);



}
