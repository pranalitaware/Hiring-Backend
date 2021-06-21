package com.lti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Candidate;
import com.lti.entity.Interview;
import com.lti.entity.Panellist;
import com.lti.model.CanListStatus;
import com.lti.model.CandidateStatus;
import com.lti.model.IntStatus;
import com.lti.model.Status;
import com.lti.service.ServiceException;
import com.lti.service.UserService;

@RestController
@CrossOrigin
public class UserController {


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
				canStatus.setLevel(c.getLevel());
				
				canListStatus.add(canStatus);
			}
			
			return canListStatus;
		}
		catch(ServiceException e){
			List<CanListStatus> canListStatus = new ArrayList<CanListStatus>();
			CanListStatus canStatus = new CanListStatus();
			canStatus.setStatus(false);
			canStatus.setMessage("Candidate list empty");
			
			canListStatus.add(canStatus);
			return canListStatus;	
		}
	}
	
	@GetMapping("/searchCandidateId")
	public Candidate searchCanById(@RequestParam ("cid") long cid) {
		try {
			Candidate candidate = userService.getCandidateById(cid);
			CanListStatus canListStatus = new CanListStatus();
			canListStatus.setStatus(true);
			canListStatus.setMessage("Candidate Present");
			return candidate;
		}
		catch(ServiceException e) {
			Candidate candidate = userService.getCandidateById(cid);
			CanListStatus canListStatus = new CanListStatus();
			canListStatus.setStatus(false);
			canListStatus.setMessage("Candidate not present");
			return candidate;
		}
	}
	
	@GetMapping("/searchCandidateName")
	public Candidate searchCanByName(@RequestParam ("firstName") String firstName) {

			Candidate candidate = userService.getCandidateByName(firstName);
			return candidate;
	}
	
	@GetMapping("/searchPanellistId")
	public Panellist searchPanById(@RequestParam ("pid") long pid) {
		
			Panellist panellist = userService.getPanellistById(pid);
			return panellist;
	}
	
	@GetMapping("/searchPanellistName")
	public Panellist searchPanByName(@RequestParam ("firstName") String firstName) {

			Panellist panellist = userService.getPanellistByName(firstName);
			return panellist;
	}
	
	@GetMapping("/linkCandidatePanellist")
	public void linkCanPan(@RequestParam ("cid") long cid, @RequestParam long pid) {
		
			userService.linkCanPan(cid,pid);
	}
	
	@PostMapping("/addCandidateDetail")
	public CandidateStatus addCandidateDetail(@RequestBody Candidate candidate) {
	
		try {
			long cid = userService.addCandidateDetail(candidate.getCid(),candidate.getRating(),candidate.getFeedback(),candidate.getSelStatus());
			CandidateStatus canStatus = new CandidateStatus();
			canStatus.setStatus(true);
			canStatus.setMessage("Details saved successfully!!!");
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
	
	@PostMapping("/mapCanPan")
	public IntStatus mapCanPan(@RequestBody Interview interview) {
		
		try {
			userService.mapCanPan(interview);
			IntStatus intStatus = new IntStatus();
			intStatus.setMessage("compound key added");
			intStatus.setStatus(true);
			return intStatus;
		}
		catch(ServiceException e){
			IntStatus intStatus = new IntStatus();
			intStatus.setMessage(e.getMessage());
			intStatus.setStatus(false);
			return intStatus;
		}
		
	}
}
