package com.mock.project.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.project.dao.BrokerDAO;
import com.mock.project.dao.BrokerDAOImpl;
import com.mock.project.dao.OrderDAO;
import com.mock.project.dao.OrderDAOImpl;
import com.mock.project.model.Block;

@Service("Broker service")
@Transactional
public class BrokerServiceImpl implements BrokerService {
	
	@Autowired
	private BrokerDAO dao = new BrokerDAOImpl();

	@Override
	public void saveblock(Block block) {
		System.out.println("In broker serviceimpl");
		dao.saveBlock(block);		
	}
	
}
