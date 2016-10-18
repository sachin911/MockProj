package com.mock.project.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mock.project.model.Block;
import com.mock.project.model.Order;

@Repository
public class BrokerDAOImpl extends GenericDAOImplementation<Order, Long> implements BrokerDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void saveBlock(Block block) {
		
		System.out.println("In brokerdaoimpl");
		long b_id = (Long) block.getBlockId();
		System.out.println(b_id);
		
		Query query = em.createQuery("update Block set executed_date =:executed_date, qty_executed =:qty_executed, status =:status" + " where block_id = :b_id");		
		query.setParameter("b_id", b_id);
		query.setParameter("executed_date", new Date());
		query.setParameter("qty_executed", 100);
		query.setParameter("status", "complete");
		query.executeUpdate();
	}

}
