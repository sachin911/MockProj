package com.mock.project.service;

import java.util.List;

import com.mock.project.model.Order;

public interface TraderService {

	public void createBlock(List<Order> orders, int traderId);

	void addToBlock(List<Order> listOforder);

	void addToSelectedBlock(Integer selectedBlock);
}
