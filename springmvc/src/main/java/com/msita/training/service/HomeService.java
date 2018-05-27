package com.msita.training.service;

import com.msita.training.dao.ProductDAO;
import com.msita.training.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
    @Autowired
    private ProductDAO productDAO;

    public List<Product> getProducts(){
        return productDAO.getProducts();
    }

    public Product getProduct(int id){
        return productDAO.getProduct(id);
    }
}
