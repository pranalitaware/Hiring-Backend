package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Candidate;
import com.lti.entity.Panellist;
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
	
	@PostMapping("/panellist")
	public Status addPanellist(@RequestBody Panellist panellist) {
		
		userService.addPanellist(panellist);
		Status panStatus = new Status();
		panStatus.setStatus(true);
		panStatus.setMessage("Panellist added");
		
		return panStatus;
	}
	
	@GetMapping("/fetchAllCandidates")
	public List<Candidate> fetchAllCandidates(){
		try {
			List<Candidate> list = userService.fetchAllCandidates();
			Status status = new Status();
			status.setStatus(true);
			status.setMessage("fetched all candidates");
			return list;
		}
		catch(ServiceException e){
			Status status = new Status();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return list;
		}
	}
}
