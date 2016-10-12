package com.mock.pm.dao;

import java.util.List;

public interface GenericPMDAO<T> {
	
	void add(T object);
	void remove(T object);
	void update(T object);
	List<T> displayAll(T object);

}
