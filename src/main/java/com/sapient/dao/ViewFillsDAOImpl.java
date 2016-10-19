package com.sapient.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sapient.model.ViewFills;
@Repository
public class ViewFillsDAOImpl  extends GenericDAOImpl<ViewFills, Long> implements ViewFillsDAO {

	@Override
	public List<ViewFills> findAll() {
		
		return em.createQuery("from ViewFills").getResultList();
	}

}
