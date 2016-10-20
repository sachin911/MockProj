package com.mock.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;


import com.mock.project.model.Block;
import com.mock.project.model.Order;




import com.mock.project.model.Status;
import com.mock.project.service.TraderService;
import com.mock.project.service.TraderServiceImpl;
import com.mock.project.model.Order;




@Repository
public class OrderDAOImpl extends GenericDAOImplementation<Order, Long> implements OrderDAO{

	@PersistenceContext
	private EntityManager em;

	

	 @SuppressWarnings("unchecked")
	 @Override 
	 public List<Order> findAll() {
	//	 System.out.println("hey");
	List<Order> l=new ArrayList<Order>();

	
	Query query=em.createQuery("from Order where block_id is null and status=:stat");
	query.setParameter("stat", "Open");
	List<Order>l1=query.getResultList();
	
	
	for(Order i:l1){
		
		System.out.println(i);
	}
	

	return query.getResultList(); 
	 }

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findAll(int traderId) {


		Query query = em.createQuery("from Order where trader_id =:traderId");

		query.setParameter("traderId", traderId);

		return query.getResultList();
	}



	@Override
	public void updateStatus(long block_id, List order_id) {
		for (int i = 0; i < order_id.size(); i++) {
			System.out.println("dask");
			long o_id = (Long) order_id.get(i);
			Query query = em.createQuery("update Order set block_id =:block_id" + " where order_id = :o_id");
			query.setParameter("block_id", block_id);
			query.setParameter("o_id", o_id);
			query.executeUpdate();
		}

	}

	 
		@Override
		public void updateBlock(Status changeStatus, List<Block> block_id) {

			

			for (int i = 0; i < block_id.size(); i++) {

				long b_id =   block_id.get(i).getBlockId();


				Query query = em.createQuery("update Block set status =:changeStatus" + " where block_id =:b_id");

				query.setParameter("changeStatus", changeStatus.toString());
				query.setParameter("b_id", b_id);
				query.executeUpdate();
				
			}
			



		} 

	@Override
    public void addToThisBlock(Order order, Integer selectedBlock) {
		System.out.println("updatingblockid");
           Query query = em.createQuery("update Order set block_id =:block_id" + " where order_id = :o_id" );
           query.setParameter("o_id", order.getOrderId());
           query.setParameter("block_id", selectedBlock);
           query.executeUpdate();
           System.out.println("updated");
    }



	@Override

    public List<Block> recommend(List<Integer> selectedOrders) 
    {
           List<Order> checkedOrdersList=new ArrayList<Order>();
           List<Order> checkedOrders=new ArrayList<Order>();
           String symbol = null,side = null,status = null;
           int i,c=0;
           for(Integer order_id:selectedOrders)
           {
           
           TypedQuery<Order> query1=em.createQuery("from Order where order_id=:order_id",Order.class);
           query1.setParameter("order_id", order_id);
           checkedOrders=(List<Order>)query1.getResultList();
           Order order=checkedOrders.get(0);
           symbol=order.getSymbol();
           side=order.getSide();
           status=order.getStatus();
           checkedOrdersList.add(order);
           }
           System.out.println("here");
           for(Order c1: checkedOrders){
                  System.out.println(c1);
           }
           System.out.println("OrderDAOImpl"+side);
           TypedQuery<Block> query=em.createQuery("from Block where symbol=:symbol" + " and side=:side"+ " and status=:status",Block.class);
           query.setParameter("status", status);
           query.setParameter("symbol", symbol);
           query.setParameter("side", side);
           
           List<Block> blocks=query.getResultList();
           System.out.println("hey");
           
           Order check=checkedOrdersList.get(0);
           System.out.println("check" + check);
    
           for(i=0;i<checkedOrdersList.size();i++)
           {
                  if(check.getStatus()==(checkedOrdersList.get(i)).getStatus()&&check.getSide()==(checkedOrdersList.get(i)).getSide()&&check.getSymbol()==(checkedOrdersList.get(i)).getSymbol())
                  { c=0;
                  System.out.println("not break");
                 
                  TraderService object=new TraderServiceImpl();
                  for(Order o:checkedOrdersList){
                	  System.out.println(o);
                  }
                  object.addToBlock(checkedOrdersList);

}
                  
                  else
                  {c=1;
                  System.out.println("break");
                  break;}
           }
           if(c==1)      
           return null;
           else{
                  System.out.println("Else");
           return  blocks;}
    }




	public List<Order> findOrder(int orderId) {
		// TODO Auto-generated method stub
		//System.out.println("asdjdsak: "+orderId);
		List<Order> orders=new ArrayList<Order>();
		Query query=em.createQuery("from Order where order_Id=:orderId"+" and block_id is null");
		query.setParameter("orderId",orderId);
		//System.out.println(query);
		orders=query.getResultList();
		//System.out.println(orders.get(0));

		return orders;

	}

	@Override
	public void addBlock(Block block) {
		// TODO Auto-generated method stub
		em.persist(block);
	}

	@Override

	public Block findBlock(int blockId) {
		List<Block> blocks=new ArrayList<Block>();
		Query query=em.createQuery("from Block where block_Id=:blockId");
	query.setParameter("blockId",blockId);
		//System.out.println(query);
	blocks=query.getResultList();
	//System.out.println(orders.get(0));
	Block block = blocks.get(0);
	return block;
	}

	public List<Block> findAllBlocks(int traderId) {
		Query query = em.createQuery("from Block where status=:stat");
		query.setParameter("stat", "New");

		return query.getResultList();

	}
	
	public List<Block> findAllBlocksHistory(int traderId) {
		Query query = em.createQuery("from Block where status!=:stat");
		query.setParameter("stat", "New");

		return query.getResultList();

	}

	@Override
	public void allocateorder(Block block) {
		// TODO Auto-generated method stub
		int executedQty=(int) block.getQtyExecuted();
		List<Order> list = new ArrayList<Order>();
		Query query = em.createQuery("from Order where blockId = :id order by orderDate");
		query.setParameter("id", block.getBlockId());
		list = query.getResultList();
		for (Order order1 : list) {
		int q=order1.getQtyPlaced();
		Status status = null;
			if((q<= executedQty) && (executedQty>0))
			{
				System.out.println(em);
				System.out.println("Inside first loop");
				System.out.println(q);
				executedQty=executedQty-q;
				
				Query query1 = em.createQuery("Update Order set qtyExecuted=:qty1, status=:status1 where orderId=:oid");
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
				Query query1 = em.createQuery("Update Order set qtyExecuted=:qty2, status=:status2 where orderId=:oid");
				query1.setParameter("qty2",executedQty);
				query1.setParameter("status2", status.PartiallyAllocated.toString());
				query1.setParameter("oid",order1.getOrderId());
				System.out.println(query1.executeUpdate());
				//query1.executeUpdate();
				executedQty=0;
				System.out.println(executedQty);
			}
			else{
				Query query2 = em.createQuery("update Order set status=:status3 where orderId=:oid");
				query2.setParameter("status3", status.Open.toString());
				query2.setParameter("oid",order1.getOrderId());
				System.out.println(query2.executeUpdate());
				//query2.executeUpdate();
			}}
		System.out.println("Inside OrderDAO");

		
	}

	@Override
	public List<Order> findOrdersInBlock(int blockId) {
		Query query = em.createQuery("from Order where block_id=:bid");
		query.setParameter("bid", blockId);

		return query.getResultList();
	}

	@Override
	public void deleteBlock(Block b) {
		List<Order> list = new ArrayList<Order>();
		Query query1 = em.createQuery("from Order where blockId = :id");
		query1.setParameter("id", b.getBlockId());
		list = query1.getResultList();
		for(Order o:list){
			Query query2 = em.createQuery("update Order set block_id = null" + " where order_id = :o_id" );
	        query2.setParameter("o_id", o.getOrderId());
	       
	        query2.executeUpdate();
		}
		
		b = em.merge(b);  
		em.remove(b); 
		
	}

	


}