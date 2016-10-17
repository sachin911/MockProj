package com.mock.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mock.project.model.Status;

import com.mock.project.model.Order;

@Repository
public class OrderDAOImpl extends GenericDAOImplementation<Order, Long> implements OrderDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findAll(int traderId) {

		Query query = em.createQuery("from Order where trader_id =:traderId");
		query.setParameter("traderId", traderId);

		return query.getResultList();
	}

	@Override
	public void updateStatus(long block_id, List order_id) {
		for (int i = 0; i < order_id.size(); i++) {

			long o_id = (Long) order_id.get(i);
			Query query = em.createQuery("update Order set block_id =:block_id" + " where order_id = :o_id");
			query.setParameter("block_id", block_id);
			query.setParameter("o_id", o_id);
		}

	}

	@Override
	public void updateBlock(Status changeStatus, List block_id) {
		for (int i = 0; i < block_id.size(); i++) {

			long b_id = (Long) block_id.get(i);
			Query query = em.createQuery("update order set status =:status" + "where block_id = :b_id");
			query.setParameter("status", changeStatus);
			query.setParameter("b_id", b_id);
		}
	}

}
