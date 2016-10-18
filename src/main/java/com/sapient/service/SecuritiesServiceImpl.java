package com.sapient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.dao.SecuritiesDAO;
import com.sapient.model.Securities;
@Service("securitiesService")
@Transactional(propagation = Propagation.REQUIRED)
public class SecuritiesServiceImpl implements SecuritiesService {
	@Autowired
	SecuritiesDAO securitiesDAO;
	@Override
	public List<Securities> findALL() {
		return securitiesDAO.findAll();
		
	
}
	@Override
	public void savesecurities(Securities security) {
		securitiesDAO.save(security);
		
	}
	@Override
	public Securities findByPrimaryKey(String id) {
		
		return securitiesDAO.findByPrimaryKey(id);
	}
}
