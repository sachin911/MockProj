package com.sapient.mockProject.dao;

import java.util.List;



public interface GenericTraderDAO<T> {
	
	void add(T object);
	void remove(T object);
	List<T> displayAll(T object, String table);
	

}
