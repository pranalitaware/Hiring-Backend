package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Registration;
import com.lti.repository.AdminRepository;

@Service
@Transactional
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
