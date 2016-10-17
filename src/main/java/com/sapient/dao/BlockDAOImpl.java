package com.sapient.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sapient.model.Block;
@Repository
public class BlockDAOImpl extends GenericDAOImpl<Block, Long> implements BlockDAO {
	@PersistenceContext
	private EntityManager em;
	@Override
	public List<Block> findAll() {
		System.out.println("teast");
		return em.createQuery("from Block").getResultList();
	}

}
