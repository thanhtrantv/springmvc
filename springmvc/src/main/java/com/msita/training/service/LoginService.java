package com.msita.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msita.training.dao.LoginDAO;
import com.msita.training.entity.User;

@Service
public class LoginService {
	
	@Autowired
	private LoginDAO loginDAO;
	
	public User login(String username,String pass) {
		User rs=null;
		User user=loginDAO.login(username);
		if(user!=null && user.getPassword().equals(pass)) {
			rs=user;
		}
		return rs;
	}
}
