package com.sapient.service;

import java.util.List;

import com.sapient.model.Block;

public interface BrokerService {
void StartExecution();
void saveblock(Block block);
List<Block> findALL();
void expireblocks();
public Block findByPrimaryKey(long id);
List<Block>  openPartialView();
}
