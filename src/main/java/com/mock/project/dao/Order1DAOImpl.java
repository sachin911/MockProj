package com.mock.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mock.project.model.Block;
import com.mock.project.model.Order1;
import com.mock.project.model.Status;

@Repository
public class Order1DAOImpl extends GenericDAOImplementation<Order1, Long> implements Order1DAO {

	@PersistenceContext
	private EntityManager em;

	/*@SuppressWarnings("unchecked")
	@Override*/
	/*public List<Order1> findAll() {
		System.out.println("hey");
		List<Order> l = new ArrayList<Order>();
		System.out.println("malvika");
		Query query = em.createQuery("from Order where block_id is null");
		System.out.println("mm");
		List<Order> l1 = query.getResultList();
		System.out.println("mmee");
		System.out.println("oshin");
		for (Order i : l1) {
			System.out.println("aish");
			System.out.println(i);
		}
		System.out.println("madie");
		return query.getResultList();
	}
*/
	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Override public List<Order> findAll(int traderId) {
	 * 
	 * Query query = em.createQuery("from order where traderId = :traderId");
	 * query.setParameter("traderId", traderId); return query.getResultList(); }
	 * 
	 * 
	 * @Override public void updateStatus(long block_id,List order_id) { for(int
	 * i=0; i<order_id.size();i++){
	 * 
	 * long o_id=(Long) order_id.get(i); Query query =
	 * em.createQuery("update order set block_id =:block_id" +
	 * " where order_id = :o_id"); query.setParameter("block_id", block_id);
	 * query.setParameter("o_id", o_id); }
	 * 
	 * 
	 * }
	 * 
	 * @Override public void updateBlock(Status changeStatus, List block_id) {
	 * for(int i=0; i<block_id.size();i++){
	 * 
	 * long b_id=(Long) block_id.get(i); Query query =
	 * em.createQuery("update order set status =:status" +
	 * "where block_id = :b_id"); query.setParameter("status", changeStatus);
	 * query.setParameter("b_id", b_id); } }
	 */

	@Override
	@SuppressWarnings("unchecked")

	public void allocateorder(Block block) {
		int executedQty=(int) block.getQtyExecuted();
		List<Order1> list = new ArrayList<Order1>();
		Query query = em.createQuery("from Order1 where blockId = :id order by orderDate");
		query.setParameter("id", block.getBlockId());
		list = query.getResultList();
		for (Order1 order1 : list) {
		int q=order1.getQtyPlaced();
		Status status = null;
			if((q<= executedQty) && (executedQty>0))
			{
				System.out.println(em);
				System.out.println("Inside first loop");
				System.out.println(q);
				executedQty=executedQty-q;
				
				Query query1 = em.createQuery("Update Order1 set qtyExecuted=:qty1, status=:status1 where orderId=:oid");
				query1.setParameter("qty1",q);
				query1.setParameter("status1",status.Completed.toString());
				query1.setParameter("oid",order1.getOrderId());
				System.out.println(query1.executeUpdate());
				System.out.println(executedQty + q);
				//query1.executeUpdate();

			}
			else if(q>=executedQty && executedQty>0){
				executedQty=q-executedQty;
				System.out.println("Inside second loop");
				Query query1 = em.createQuery("Update Order1 set qtyExecuted=:qty2, status=:status2 where orderId=:oid");
				query1.setParameter("qty2",executedQty);
				query1.setParameter("status2", status.PartiallyAllocated.toString());
				query1.setParameter("oid",order1.getOrderId());
				System.out.println(query1.executeUpdate());
				//query1.executeUpdate();
				executedQty=0;
				System.out.println(executedQty);
			}
			else{
				Query query2 = em.createQuery("update Order1 set status=:status3 where orderId=:oid");
				query2.setParameter("status3", status.UnAllocated.toString());
				query2.setParameter("oid",order1.getOrderId());
				System.out.println(query2.executeUpdate());
				//query2.executeUpdate();
			}}
		System.out.println("Inside OrderDAO");

	}


}
