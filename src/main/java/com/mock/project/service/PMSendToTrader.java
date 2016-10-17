package com.mock.project.service;

import java.util.List;

import com.mock.project.model.Order;

public interface PMSendToTrader {

	void updateStatus(List order_id, String status);
	
}
