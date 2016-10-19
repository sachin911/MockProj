package com.sapient.dao;


import java.util.List;

import com.sapient.model.Block;

public interface BlockDAO extends GenericDAO<Block, Long> {

	void expire();
 Block findByPrimaryKey(long id);
List<Block>  findOpenPartial();
}
