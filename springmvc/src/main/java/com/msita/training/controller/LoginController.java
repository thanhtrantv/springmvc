package com.msita.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msita.training.entity.User;
import com.msita.training.service.LoginService;
import com.msita.training.vo.ResponseView;
//import com.msita.training.vo.User;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String goToFormLogin() {
		return "login";
	}
	
	//@ResponseBody
	@RequestMapping(value="/authenticate",method=RequestMethod.POST)
	public String login(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		String page= "home-page";
		User rs=loginService.login(username, password);
		if(rs!=null) {
			page="home";
		}else {
			page="error";
		}
		return "redirect:/"+page;
	}
}
