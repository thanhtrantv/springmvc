package com.msita.training.service;

import com.msita.training.dao.OrderDAO;
import com.msita.training.entity.Order;
import com.msita.training.entity.OrderProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDAO orderDAO;

    public void saveOrder(Order order) {
        orderDAO.saveOrder(order);
    }
    public void saveOrderProduct(OrderProduct orderProduct) {
        orderDAO.saveOrderProduct(orderProduct);
    }
}
