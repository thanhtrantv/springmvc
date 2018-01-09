package com.msita.training.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.msita.training.entity.Item;
import com.msita.training.entity.Order;
import com.msita.training.entity.OrderItem;
import com.msita.training.entity.OrderItemKey;
import com.msita.training.entity.Status;
import com.msita.training.entity.Table;

@Repository
public class TableListDAO extends BaseDAO{
	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional
	public List<Table> findAllListTable(){
		return (List<Table>) sessionFactory.getCurrentSession().createQuery("from Table").list();		
	}
	
	@Transactional
	public List<Item> findAllItem(){
		return (List<Item>) sessionFactory.getCurrentSession().createQuery("from Item").list();	
	}
	
	@Transactional
	public Table findTableById(int id){
		return (Table) sessionFactory.getCurrentSession().createQuery("from Table where idtable="+id).uniqueResult();		
	}
	@Transactional
	public Order findOrderById(String id){
		
		Query query= sessionFactory.getCurrentSession().createQuery("from Order where idOrder=:idOrder");
		query.setParameter("idOrder", id);
		return (Order) query.uniqueResult();		
	}
	@Transactional
	public void updateOrder(Order order){
		sessionFactory.getCurrentSession().update(order);
	}
	@Transactional
	public Long countOrder(){
		return  (Long ) sessionFactory.getCurrentSession().createQuery("select count(*) from Order").uniqueResult();		
	}
	
	@Transactional
	public void addOrder(int idTable){
		Order order=new Order();
		order.setIdOrder("00"+(countOrder()+1));
		order.setIdStatus("CTT");
		order.setSum(0);
		order.setIdUser("user1");
		order.setIdTable(idTable);
		sessionFactory.getCurrentSession().save(order);
	}
	
	@Transactional
	public void addItem(String idItem,String idOrder){
		OrderItem item = new OrderItem();
		OrderItemKey key=new OrderItemKey();
		item.setKey(key);
		item.getKey().setIdItem(idItem);
		item.getKey().setIdOrder(idOrder);
		item.setIdStatus("CL");
		item.setQuantity(1);
		sessionFactory.getCurrentSession().save(item);
	}
	
	@Transactional
	public boolean checkExistingItem(String idItem,String idOrder) {
		Query query = sessionFactory.getCurrentSession().createQuery("select count(*) from OrderItem where idItem=:idItem and idOrder=:idOrder");
		query.setParameter("idOrder", idOrder);
		query.setParameter("idItem", idItem);
		Long count=(Long) query.uniqueResult();
		if(count>0)
			return true;
		return false;
	}
	
	@Transactional
	public OrderItem getOrderItemByIdOrderAndIdItem(String idItem,String idOrder) {
		Query query=sessionFactory.getCurrentSession().createQuery("from OrderItem where idOrder = :idOrderSet and idItem = :idItemSet");
		query.setParameter("idOrderSet", idOrder);
		query.setParameter("idItemSet", idItem);
		return (OrderItem) query.list().get(0);
	}
	
	@Transactional
	public void updateQuantity(String idItem,String idOrder) {
		OrderItem orderItem=getOrderItemByIdOrderAndIdItem(idItem,idOrder);
		orderItem.setQuantity(orderItem.getQuantity()+1);		
		sessionFactory.getCurrentSession().update(orderItem);
	}
}
