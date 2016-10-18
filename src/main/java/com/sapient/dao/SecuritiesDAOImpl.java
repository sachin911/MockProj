package com.sapient.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sapient.model.Securities;
@Repository
public class SecuritiesDAOImpl  extends GenericDAOImpl<Securities, String> implements SecuritiesDAO {
	@PersistenceContext
	private EntityManager em;
	@Override
	public List<Securities> findAll() {
		return em.createQuery("from Securities").getResultList();
		
	}
	@Override
	public Securities findByPrimaryKey(String id) {

		return  em.find(Securities.class, id);
	}

	}

