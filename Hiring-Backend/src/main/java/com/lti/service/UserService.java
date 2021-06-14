package com.lti.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Candidate;
import com.lti.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public long addCandidate(Candidate candidate) {
		if(userRepository.isUserPresent(candidate.getMobileNo()))
			throw new ServiceException("candidate already present !");
		else {
			Candidate updatedCandidate = (Candidate) userRepository.save(candidate);
			return updatedCandidate.getCid();
		}
	}
	
}
