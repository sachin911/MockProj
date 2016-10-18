package com.sapient.service;

import java.util.List;

import com.sapient.model.ViewFills;

public interface ViewFillsService {
	void saveblock(ViewFills viewFills);
	List<ViewFills> findALL();
}
