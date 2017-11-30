package com.msita.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msita.training.dao.LoginDAO;
import com.msita.training.vo.User;

@Service
public class LoginService {
	
	@Autowired
	private LoginDAO loginDAO;
	
	public boolean login(String username,String pass) {
		boolean rs=false;
		
		User user=loginDAO.login(username);
		
		if(user!=null) {
			if(user.getPassword().equals(pass)) {
				rs=true;
			}
		}
		return rs;
	}
}
