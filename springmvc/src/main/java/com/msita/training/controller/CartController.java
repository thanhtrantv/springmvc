package com.msita.training.controller;

import com.msita.training.entity.Product;
import com.msita.training.entity.User;
import com.msita.training.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanhtran on 5/27/2018.
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private HomeService homeService;

    @RequestMapping(method = RequestMethod.GET)
    public String cart(ModelMap model) {
        return "cart";
    }

    @RequestMapping(value="/addProduct",method=RequestMethod.POST)
    public String addProduct(@RequestParam("id") int id,
                        HttpServletRequest request) {
        String page= "cart";
        Product product = homeService.getProduct(id);
        List<Product> lst = (List<Product>) request.getSession().getAttribute("cart");
        boolean isExist = false;
        if(lst == null){
            lst =new ArrayList<>();
        }else{

            for(Product prod : lst){
                if(prod.getProductId()==id){
                    prod.setQuantity(prod.getQuantity()+1);
                    isExist = true;
                }
            }
        }
        if(!isExist)
            lst.add(product);
        request.getSession().setAttribute("cart",lst);
        return "redirect:/"+page;
    }
}
