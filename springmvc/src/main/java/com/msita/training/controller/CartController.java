package com.msita.training.controller;

import com.msita.training.entity.*;
import com.msita.training.service.HomeService;
import com.msita.training.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by thanhtran on 5/27/2018.
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private HomeService homeService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public String cart(ModelMap model) {
        return "cart";
    }
    @RequestMapping(value="/removeProduct",method=RequestMethod.POST)
    public String removeProduct(@RequestParam("id") int id,
                             HttpServletRequest request) {
        String page= "cart";
        List<Product> lst = (List<Product>) request.getSession().getAttribute("cart");
        if(lst == null){
            lst =new ArrayList<>();
        }else{
            int prodPos = 0;
            for(Product prod : lst){
                if(prod.getProductId()==id){
                    break;
                }
                prodPos+=1;
            }
            lst.remove(prodPos);
        }
        request.getSession().setAttribute("cart",lst);
        return "redirect:/"+page;
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

    @RequestMapping(value="/checkout",method=RequestMethod.GET)
    public String checkout(HttpServletRequest request) {
        String page= "completed";
        List<Product> lst = (List<Product>) request.getSession().getAttribute("cart");
        if(lst == null){
            page = "home";
        }else{
            Order order =  new Order();
            List<OrderProduct> lstOrderProduct = new ArrayList<>();
            int sum = 0;
            for(Product prod : lst){
                sum+=(prod.getQuantity()*prod.getPrice());
                OrderProduct orderProduct=new OrderProduct();

                OrderProductKey key =new OrderProductKey();
                key.setIdo(order.getIdo());
                key.setIdp(prod.getProductId());

                orderProduct.setKey(key);

                orderProduct.setPrice(prod.getPrice());
                orderProduct.setQuantity(prod.getQuantity());
                if(order.getLstOrderProduct()==null)
                    order.setLstOrderProduct(new ArrayList<>());
                lstOrderProduct.add(orderProduct);
            }
            order.setSum(sum);
            orderService.saveOrder(order);
            for(OrderProduct orderProduct : lstOrderProduct){
                orderProduct.getKey().setIdo(order.getIdo());
                orderService.saveOrderProduct(orderProduct);
            }
        }
        return "redirect:/"+page;
    }
}
