package com.example.project.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.service.LoginService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class LoginController {
	
	@Autowired
	LoginService login;

	@GetMapping(value = "/check/{userName}/{password}")
	boolean verify(@PathVariable("userName") String userName, @PathVariable("password") String password) {
		return login.loginValidation(userName, password);
		
	}
}
