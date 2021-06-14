package com.lti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Candidate;
import com.lti.entity.Panellist;
import com.lti.model.CanListStatus;
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
	/*
	@GetMapping("/fetchAllCandidates")
	public List<CanListStatus> fetchAllCandidates(){
		try {
			List<Candidate> canList = userService.fetchAllCandidates();
			List<CanListStatus> canListStatus = new ArrayList<CanListStatus>();
			
			for(Candidate c : canList) {
				CanListStatus canStatus = new CanListStatus();
				canStatus.setStatus(true);
				canStatus.setMessage("Candidate list retrived");
				canStatus.setCid(c.getCid());
				canStatus.setFirstName(c.getFirstName());
				canStatus.setMiddleName(c.getMiddleName());
				canStatus.setLastName(c.getLastName());
				canStatus.setMobileNo(c.getMobileNo());
				canStatus.setEmailId(c.getEmailId());
				canStatus.setDateOfBirth(c.getDateOfBirth());
				canStatus.setResume(c.getResume());
				canStatus.setFeedback(c.getFeedback());
				canStatus.setRating(c.getRating());
				canStatus.setSelStatus(c.getSelStatus());
				
			}
		}
		catch(ServiceException e){
			
		}
	}*/
}
