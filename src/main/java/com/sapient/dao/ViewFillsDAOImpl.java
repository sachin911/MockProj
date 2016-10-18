package com.sapient.dao;

import java.util.List;
import com.sapient.model.ViewFills;

public class ViewFillsDAOImpl  extends GenericDAOImpl<ViewFills, Long> implements ViewFillsDAO {

	@Override
	public List<ViewFills> findAll() {
		
		return em.createQuery("from ViewFills").getResultList();
	}

}
