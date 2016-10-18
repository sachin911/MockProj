package com.sapient.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.model.Block;

@Repository
@Transactional
public class BlockDAOImpl extends GenericDAOImpl<Block, Long> implements BlockDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Block> findAll() {
		//System.out.println("teast");
		return em.createQuery("from Block").getResultList();
	}
	@Override
	public void expire() {
		// TODO Auto-generated method stub
		System.out.println("Expiring open quantities");
		Query query=em.createQuery("update Block set status='Expired' where (total_quantity-executed_quantity)>0 and status='Sent for execution'");
		query.executeUpdate();
		
	}

/*	public void updateBlock() {
		em.c
	}
*/
}
