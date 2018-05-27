package com.msita.training.controller;

import com.msita.training.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by thanhtran on 5/27/2018.
 */
@Controller
@RequestMapping("/productDetail")
public class ProductController {

    @Autowired
    private HomeService homeService;

    @RequestMapping(method = RequestMethod.GET)
    public String productDetail(@RequestParam("id") int id,ModelMap model) {
        System.out.println(id);
        model.addAttribute("product",homeService.getProduct(id));
        homeService.getProduct(id);
        return "productDetail";
    }

}
