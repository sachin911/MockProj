package com.sapient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.dao.ViewFillsDAO;
import com.sapient.model.ViewFills;
@Service("viewfillsservice")
@Transactional(propagation = Propagation.REQUIRED)
public class ViewFillsServiceImpl implements ViewFillsService{

	@Autowired
	ViewFillsDAO viewFillsDAO;
	@Override
	public void saveblock(ViewFills viewFills) {
		viewFillsDAO.save(viewFills);
		
	}

	@Override
	public List<ViewFills> findALL() {
		
		return viewFillsDAO.findAll();
	}

}
