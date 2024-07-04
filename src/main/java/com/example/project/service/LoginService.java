package com.example.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.project.entity.LoginEntity;
import com.example.project.repository.LoginRepository;

@Component
public class LoginService {
	
	@Autowired
	LoginRepository loginrepo;
	
	public boolean loginValidation(String email, String password) { 
		List<LoginEntity> loginList = loginrepo.findAll();
		
		for(LoginEntity login : loginList) {
			if(login.getPassword().equals(password) && login.getUserName().equals(email)) {
				System.out.println("set login as true");
				return true;
			}
		}
		System.out.println("set login as false");
		return false;
	}

}
