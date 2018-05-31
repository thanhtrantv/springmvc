package com.msita.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    @RequestMapping(method = RequestMethod.GET)
    public String homePage(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("cart");
        return "redirect:/home";
    }

}
