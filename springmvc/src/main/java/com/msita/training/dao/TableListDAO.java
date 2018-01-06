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
	public int countOrder(){
		return  (int) sessionFactory.getCurrentSession().createQuery("select count(*) from Order").uniqueResult();		
	}
	
	@Transactional
	public void addOrder(){
		Order order=new Order();
		order.setIdOrder("00"+countOrder());
		order.setIdStatus("CTT");
		order.setSum(0);
		//sessionFactory.getCurrentSession().
		String hql = "INSERT INTO Order(idorder,idStatus,sum)";
		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("idOrder", "00"+countOrder());
		query.setParameter("idStatus", "CTT");
		query.setParameter("sum", 0);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
		//return (Table) sessionFactory.getCurrentSession().createQuery("from Table where idtable="+id).uniqueResult();		
	}
	
	@Transactional
	public void addItem(String idItem,String idOrder){
		OrderItem item = new OrderItem();
		OrderItemKey key=new OrderItemKey();
		item.setKey(key);
		item.getKey().setIdItem(idItem);
		item.getKey().setIdOrder(idOrder);
		item.setIdStatus("CL");
		sessionFactory.getCurrentSession().save(item);
		//sessionFactory.getCurrentSession().persist(arg0);
		//sessionFactory.getCurrentSession().
//		String hql = "INSERT INTO OrderItem(key.idOrder,key.idItem)";
//		Query query =  sessionFactory.getCurrentSession().save(arg0)createQuery(hql);
//		query.setParameter("key.idorder", idOrder);
//		query.setParameter("key.iditem", idItem);
//		int result = query.executeUpdate();
//		System.out.println("Rows affected: " + result);
		//return (Table) sessionFactory.getCurrentSession().createQuery("from Table where idtable="+id).uniqueResult();		
	}
	
}
