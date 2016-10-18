package com.sapient.dao;


import com.sapient.model.Securities;

public interface SecuritiesDAO extends GenericDAO<Securities, String> {
	public Securities findByPrimaryKey(String id);
}
