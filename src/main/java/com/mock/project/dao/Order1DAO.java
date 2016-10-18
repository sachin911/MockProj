package com.mock.project.dao;

import java.util.List;

import com.mock.project.model.Block;
import com.mock.project.model.Order;
import com.mock.project.model.Order1;
import com.mock.project.model.Status;


import com.mock.project.model.Order;



public interface Order1DAO extends GenericDAO<Order1, Long>
{
	//List<Order1> findAll(int traderId);
	

	/*void updateStatus(long block_id,List order_id);
	void updateBlock(Status changeStatus, List block_id);*/
    void allocateorder(Block block);
}
