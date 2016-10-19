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
	public Order edit(Order object) {
		em.persist(object);
		return object;
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
	public List<Order> findAllByID(Long id) {
		Query query = em.createQuery("from Order where pm_id =:pid");
		query.setParameter("pid", id);
		List<Order> orders = new ArrayList<Order>();

		orders = query.getResultList();
		if(orders.isEmpty() == false){
			return orders;
		} else {
			System.out.println("ERROR! no orders with this id IN SYSTEM");
			return orders;
		}
	}

	@Override
	public List<Order> findAllStatusNew(Long pmId,Status status) {
		List<Order> list = new ArrayList<>();

		Query query = em.createQuery("from Order where pm_id= :pmId and status= :status");

		query.setParameter("pmId", pmId);
		query.setParameter("status", status.toString());
		list = query.getResultList();

		System.out.println(list);
		return list;

	}

	public Long getTraderId(String username) {
		//System.out.println("Trader name in pm dao = " + username);
		Query query = em.createQuery("from User where username =:username");
		query.setParameter("username", username);
		List<User> userList = new ArrayList<User>();
		userList = query.getResultList();
		//System.out.println("User list = " + userList.size());
		User u = userList.get(0);
		//System.out.println("User object = " + u.toString());
		return u.getId();
	}

	// @Override
	// public void updateStatus(Status status,List orderid) {
	// List<Order> getOrders=new ArrayList();
	// getOrders=findAll(orderid);
	// for(int i=0; i<orderid.size();i++){
	//
	// Long o_id= (Long) orderid.get(i);
	// Query query=em.createQuery("update Order set status =:status" + " where
	// orderid = :o_id");
	//
	//
	// query.setParameter("status", status);
	// query.setParameter("o_id", o_id);
	//
	// }

	// @Override
	// public void updateStatus(String status, List order_id) {
	// // TODO Auto-generated method stub
	// for(int i=0; i<order_id.size();i++){
	//
	// Long o_id= (Long) order_id.get(i);
	// Query query=em.createQuery("update Order set status =:status" + " where
	// orderid = :o_id");
	//
	//
	// query.setParameter("status", status);
	// query.setParameter("o_id", o_id);
	//
	// }
	//

}

// @Override
// public Object add(Object entity) {
// // TODO Auto-generated method stub
// return null;
// }

// @Override
// public void delete(Object object) {
// // TODO Auto-generated method stub
//
// }
//
// @Override
// public Object edit(Object object) {
// // TODO Auto-generated method stub
// return null;
// }
//
// @Override
// public Object ammend(Object object) {
//// // TODO Auto-generated method stub
// return null;
// }
////