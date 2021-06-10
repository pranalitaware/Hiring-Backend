package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Login;
import com.lti.entity.Registration;
import com.lti.model.RegisterStatus;
import com.lti.model.Status;
import com.lti.repository.UserRepository;
import com.lti.service.ServiceException;
import com.lti.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public RegisterStatus register(@RequestBody Registration user) {

		try {

			long id = userService.register(user);
			RegisterStatus regStatus = new RegisterStatus();
			regStatus.setStatus(true);
			regStatus.setMessage("Registration successfull!!!");
			regStatus.setUserId(id);
			return regStatus;
		}
		catch(ServiceException e) {
			RegisterStatus regStatus = new RegisterStatus();
			regStatus.setStatus(false);
			regStatus.setMessage(e.getMessage());
			return regStatus;
		}
	}

	@PostMapping("/userlogin")
	public Status login(@RequestBody Login login) {
		try {
			
			Login loginDetails = userService.login(login.getCustomerId(), login.getPassword());
			Status loginStatus = new Status();
			loginStatus.setStatus(true);
			loginStatus.setMessage("Login successful!");
			
			return loginStatus;
		}
		catch(ServiceException e) {
			Status loginStatus = new Status();
			loginStatus.setStatus(false);
			loginStatus.setMessage(e.getMessage());		
			return loginStatus;
		}
	}


}
