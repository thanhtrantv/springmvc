package com.msita.training.dao;

import com.msita.training.entity.Product;
import com.msita.training.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Transactional
    public List<Product> getProducts() {
        return (List<Product>) sessionFactory.getCurrentSession().createQuery("from Product").list();
    }
    @Transactional
    public Product getProduct(int id) {
        return (Product) sessionFactory.getCurrentSession().get(com.msita.training.entity.Product.class, id);
    }
}
