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
		
		Query query = em.createQuery("update Block set status =:status, executed_quantity =:executed_quantity, executed_date =:executed_date, executed_price =:executed_price" + " where block_id = :b_id");		
		query.setParameter("b_id", b_id);
		query.setParameter("status", "complete");
		query.setParameter("executed_quantity", 50);
		query.setParameter("executed_date", new Date());
		query.setParameter("executed_price", 123);
		query.executeUpdate();
	}

}
