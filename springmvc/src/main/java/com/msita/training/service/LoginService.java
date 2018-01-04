package com.msita.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msita.training.dao.LoginDAO;
import com.msita.training.entity.Role;
import com.msita.training.entity.User;
//import com.msita.training.vo.User;

@Service
public class LoginService {
	
	@Autowired
	private LoginDAO loginDAO;
	
	public User login(String username,String pass) {
		User rs=null;
		User user=loginDAO.login(username);
		if(user!=null) {
			Role role=user.getRole();
			if(role!=null) {
				System.out.println("The role user is : "+role.getIdRole());
			}
			if(user.getPassword().equals(pass)) {
				rs=user;
			}
		}
		return rs;
	}
}
