package com.mock.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.mock.project.dao.PmDAO;
import com.mock.project.dao.PMDAO;

@Service("Send to trader service")
@Transactional

public class PMSendToTraderImpl implements PMSendToTrader {
	
	@Autowired
	private PMDAO dao;
	
	@Override
	public void updateStatus(List order_id,String status) {
		
		dao.updateStatus(order_id, status);
	}

}
