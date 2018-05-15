package com.msita.training.controller;

import com.msita.training.entity.Product;
import com.msita.training.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @RequestMapping(method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("listProduct",homeService.getProducts());
        return "home";
    }


}
