package com.msita.training.service;

import com.msita.training.dao.OrderDAO;
import com.msita.training.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderDAO orderDAO;

    public void saveOrder(Order order) {
        orderDAO.saveOrder(order);
    }
}
