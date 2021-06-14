/*package com.lti.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Login;
import com.lti.entity.Registration;
import com.lti.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public long register(Registration user) {
		if(userRepository.isUserPresent(user.getMobileNo()))
			throw new ServiceException("user already registered !");
		else {
			Registration updateuser = (Registration) userRepository.save(user);
			return updateuser.getUserId();
		}
	}
	
	public Login login(long customerId, String password) {
		try {
			long id = userRepository.fetchIdByLoginIdAndPassword( customerId, password);
			Login loginDetails = userRepository.find(Login.class, id);
			return loginDetails;
		}
		catch(EmptyResultDataAccessException e) {
			throw new ServiceException("Invalid id/password");
		}
	}

	
}
*/