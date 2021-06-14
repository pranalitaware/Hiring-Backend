package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Candidate;
import com.lti.model.CandidateStatus;
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
	
	@PostMapping("/candidate")
	public CandidateStatus addCandidate(@RequestBody Candidate candidate) {

		try {

			long cid = userService.addCandidate(candidate);
			CandidateStatus canStatus = new CandidateStatus();
			canStatus.setStatus(true);
			canStatus.setMessage("Candidate added!!!");
			canStatus.setCid(cid);
			return canStatus;
		}
		catch(ServiceException e) {
			CandidateStatus canStatus = new CandidateStatus();
			canStatus.setStatus(false);
			canStatus.setMessage(e.getMessage());
			return canStatus;
		}
	}
}
