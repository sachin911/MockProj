package com.mock.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mock.project.model.Order;
import com.mock.project.model.Portfolio;
import com.mock.project.model.Status;
import com.mock.project.model.User;

@Repository
public class PmDAOImpl extends GenericDAOImplementation<Order, Long> implements PMDAO<Order> {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")


	@Override
	public void edit(Order order) {
		Long o_id = (Long) order.getOrderId();
		Query query = em.createQuery("update Order set order_type=:orderType, qualifier=:orderqual, account_type=:acctype, qty_placed=:qtyPlaced, trader_id=:trader, portfolio_id=:portfolio, stop_price=:stop, limit_price=:limit where order_id=:orderId");
		query.setParameter("orderId", o_id);
		query.setParameter("orderType", order.getOrderType());
		query.setParameter("orderqual", order.getQualifier());
		query.setParameter("acctype", order.getAccountType());
		query.setParameter("qtyPlaced", order.getQtyPlaced());
		query.setParameter("trader", order.getTraderId());
		query.setParameter("portfolio", order.getPortfolioId());
		query.setParameter("stop", order.getStopPrice());
		query.setParameter("limit", order.getLimitPrice());
		
		System.out.println("update query" + query.executeUpdate());
	}

	@Override
	public Order ammend(Order object) {
		em.persist(object);
		return object;
	}

	public void remove(Order object) {
		em.remove(object);
	}

	@Override
	public Order findByPrimaryKey(Order id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findAllByName(String name, Long id) {

		Query query = em.createQuery("from Portfolio where portfolio_name =:pname");
		query.setParameter("pname", name);
		System.out.println(query.toString());
		Portfolio p = new Portfolio();
		Long pid = null;
		List<Portfolio> correspondingPortfolioInList = query.getResultList();
		if(correspondingPortfolioInList.isEmpty() == false){
			p = correspondingPortfolioInList.get(0);
			pid = p.getPortfolio_id();
		} else {
			System.out.println("ERROR! PORTFOLIO WITH THIS NAME DOES NOT EXIST IN SYSTEM. NAME = " + name);
		}

		if(pid != null) {
			Query query2 = em.createQuery("from Order where portfolioId =:p_id" + " and PM_ID =:pm_id");
			query2.setParameter("p_id", pid);
			query2.setParameter("pm_id", id);
			System.out.println(query2.toString());
			List<Order> correspondingOrders = query2.getResultList();
			System.out.println("IN PMDAOIMPL: FOUND THESE ORDERS FOR THIS PM ID: " + id + "    " + correspondingOrders.toString());
			return correspondingOrders;
		} else {
			System.out.println("PORTFOLIO ID IS NULL. CANNOT FETCH ORDERS");
			return null;
		}
	}

	public void updateStatus(Status status, List order_id) {
		for (int i = 0; i < order_id.size(); i++) {
			Long o_id = (Long) order_id.get(i);
			Query query = em.createQuery("update Order set status=:status where order_id=:o_id");
			query.setParameter("status", status.toString());
			query.setParameter("o_id", o_id);
			System.out.println("update query" + query.executeUpdate());
		}
	}

	@Override
	public List<Order> findAllOrdersByID(Long id) {
		Query query = em.createQuery("from Order where pm_id =:pid order by order_date desc");
		query.setParameter("pid", id);
		List<Order> orders = new ArrayList<Order>();

		orders = query.getResultList();
		if(orders.isEmpty() == false){
			return orders;
		} else {
			
			return orders;
		}
	}

	@Override
	public List<Order> findAllStatusNew(Long pmId,Status status) {
		List<Order> list = new ArrayList<>();

		Query query = em.createQuery("from Order where pm_id= :pmId and status= :status order by order_date desc");

		query.setParameter("pmId", pmId);
		query.setParameter("status", status.toString());
		list = query.getResultList();

		
		return list;

	}

	public Long getTraderId(String username) {
	
		Query query = em.createQuery("from User where username =:username");
		query.setParameter("username", username);
		List<User> userList = new ArrayList<User>();
		userList = query.getResultList();
		
		User u = userList.get(0);
		
		return u.getId();
	}
	
	public Long getPortfolioId(String portfolio_name) {
		
		Query query = em.createQuery("from Portfolio where portfolio_name =:portfolio_name");
		query.setParameter("portfolio_name", portfolio_name);
		List<Portfolio> portfolioList = new ArrayList<Portfolio>();
		portfolioList = query.getResultList();
		Portfolio p = portfolioList.get(0);
		return p.getPortfolio_id();
	}

	public List<String> getTraderNameList() {
		Query query = em.createQuery("from User where user_type = 'TRADER' or user_type = 'PMTRADER'");
		List<User> userList = new ArrayList<User>();
		userList = query.getResultList();
		System.out.println("User list = " + userList.size());
		List<String> traderNameList = new ArrayList<String>();
		for(User u: userList){
			traderNameList.add(u.getName());
		}
		System.out.println("trader name list = " + traderNameList);
		return traderNameList;
	}


	
	public String getUserNameFromID(Long id) {
		System.out.println("In getUserNameFromID about to create query");
		Query query = em.createQuery("from User where user_id =:uid");
		query.setParameter("uid", id);
		List<User> userList = new ArrayList<User>();
		userList = query.getResultList();
		User u = userList.get(0);
		return u.getName();
	}

	@Override
	public void findOrderForDrop(Long id) {
		
		Query query = em.createQuery("update Order set status=:status where order_id=:o_id");
		query.setParameter("o_id", id);
		query.setParameter("status", "Cancel");
		System.out.println("update query" + query.executeUpdate());
	}
	
	@Override
	public Order findOrderForEdit(Long id) {
		Query query = em.createQuery("from Order where order_id =:oid");
		query.setParameter("oid", id);
	      Order orders = new Order();
		orders = (Order) query.getSingleResult();
		System.out.println(orders);
		return orders;
		
	}


	@Override
	public List<Order> findAllHoldingsInPortfolio(String name, Long id) {
		Query query = em.createQuery("from Portfolio where portfolio_name =:pname");
		query.setParameter("pname", name);
		System.out.println(query.toString());
		Portfolio p = new Portfolio();
		Long pid = null;
		List<Portfolio> correspondingPortfolioInList = query.getResultList();
		if(correspondingPortfolioInList.isEmpty() == false){
			p = correspondingPortfolioInList.get(0);
			pid = p.getPortfolio_id();
		} else {
			System.out.println("ERROR! PORTFOLIO WITH THIS NAME DOES NOT EXIST IN SYSTEM. NAME = " + name);
		}

		if(pid != null) {
			Query query2 = em.createQuery("from Order where portfolioId =:p_id" + " and PM_ID =:pm_id" + " and (status=:thisstat" + " or status=:thatstat" + ")" );
			query2.setParameter("p_id", pid);
			query2.setParameter("pm_id", id);
			query2.setParameter("thisstat", "Partial");
			query2.setParameter("thatstat", "Completed");
			System.out.println(query2.toString());
			List<Order> correspondingOrders = query2.getResultList();
			System.out.println("IN PMDAOIMPL: FOUND THESE ORDERS FOR THIS PM ID WITH STATUS EXECUTED OR PARTIALLY EXECUTED: " + id + "    " + correspondingOrders.toString());
			return correspondingOrders;
		} else {
			System.out.println("PORTFOLIO ID IS NULL. CANNOT FETCH ORDERS");
			return null;
		}
	}

	@Override
	public List<Order> findAllHoldings(Long id) {
		Query query = em.createQuery("from Order where pm_id =:pid" + " and (status=:thisstat" + " or status=:thatstat" + ")");
		query.setParameter("pid", id);
		query.setParameter("thisstat", "Partial");
		query.setParameter("thatstat", "Completed");
		
		List<Order> orders = new ArrayList<Order>();

		orders = query.getResultList();
		if(orders.isEmpty() == false){
			return orders;
		} else {	
			System.out.println("FOUND NO ORDERS THAT HAVE EXECUTED AS STATUS");
			return orders;
		}
	}
}

