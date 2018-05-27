package com.msita.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by thanhtran on 5/27/2018.
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    @RequestMapping(method = RequestMethod.GET)
    public String cart(ModelMap model) {
        return "cart";
    }
}
