package com.msita.training.dao;

import com.msita.training.entity.Order;
import com.msita.training.entity.OrderProduct;
import com.msita.training.entity.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class OrderDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Transactional
    public void saveOrder(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }
    @Transactional
    public void saveOrderProduct(OrderProduct orderProduct) {
        sessionFactory.getCurrentSession().save(orderProduct);
    }
}
