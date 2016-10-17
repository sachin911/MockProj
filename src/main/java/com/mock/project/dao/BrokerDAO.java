package com.mock.project.dao;

import com.mock.project.model.Block;
import com.mock.project.model.Order;

public interface BrokerDAO extends GenericDAO<Order, Long>{

	void updateBlock(Block block);

}
