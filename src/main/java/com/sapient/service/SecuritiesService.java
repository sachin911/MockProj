package com.sapient.service;

import java.util.List;

import com.sapient.model.Block;
import com.sapient.model.Securities;

public interface SecuritiesService {
	List<Securities> findALL();
	void savesecurities(Securities security);
	public Securities findByPrimaryKey(String id);
}
