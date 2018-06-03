package com.msita.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by thanhtran on 6/3/2018.
 */
@Controller
@RequestMapping("/completed")
public class CompletedOrderController {
    @RequestMapping(method = RequestMethod.GET)
    public String competed(ModelMap model) {
        return "completed";
    }
}
