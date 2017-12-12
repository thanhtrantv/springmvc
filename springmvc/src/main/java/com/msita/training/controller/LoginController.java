package com.msita.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msita.training.service.LoginService;
import com.msita.training.vo.ResponseView;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String goToFormLogin() {
		return "login";
	}
	
	@ResponseBody
	@RequestMapping(value="/authenticate",method=RequestMethod.POST)
	public String login(@RequestParam("username") String username,@RequestParam("password") String password) {
		ResponseView view=new ResponseView();
		boolean rs=loginService.login(username, password);
		if(rs==true) {
			view.setCodes("200");
			view.setMess("Login Successful");
		}else {
			view.setCodes("403");
			view.setMess("Login Failure");
		}
		return "home-page";
	}
}
