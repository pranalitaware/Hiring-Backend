package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.lti.entity.Registration;
import com.lti.repository.AdminRepository;

public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;


	public List<Registration> RegisterRequestAction() {
		try {
			List<Registration> list = adminRepository.fetchRegistrationRequestForAdmin();
			return list;
		}
		catch(EmptyResultDataAccessException e) {
			throw new ServiceException("No rows !!");
		}
	}
}
