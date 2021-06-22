package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Candidate;
//import com.lti.entity.Interview;
import com.lti.entity.Panellist;
import com.lti.enums.SelStatus;
import com.lti.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	EmailService emailService;

	public long addCandidate(Candidate candidate) {
		if(userRepository.isUserPresent(candidate.getMobileNo()))
			throw new ServiceException("candidate already present !");
		else {
			Candidate updatedCandidate = (Candidate) userRepository.save(candidate);
			return updatedCandidate.getCid();
		}
	}
	
	public void addPanellist(Panellist panellist) {
		userRepository.save(panellist);
	}

	public List<Candidate> fetchAllCandidates() {
		try {
			List<Candidate> canList = userRepository.fetchAllCandidates();
			return canList;
		}
		catch(EmptyResultDataAccessException e) {
			throw new ServiceException("No entries for candidates !!");
		}
	}

	public Candidate getCandidateById(long cid) {
		Candidate candidate = userRepository.fetchCandidateById(cid);
		return candidate;
	}

	public Candidate getCandidateByName(String firstName) {
		Candidate candidate = userRepository.fetchCandidateByName(firstName);
		return candidate;
	}

	public Panellist getPanellistById(long pid) {
		Panellist panellist = userRepository.fetchPanellistById(pid);
		return panellist;
	}
	
	public Panellist getPanellistByName(String firstName) {
		Panellist panellist = userRepository.fetchPanellistByName(firstName);
		return panellist;
	}

	public void linkCanPan(long cid, long pid) {
		userRepository.linkCanPan(cid, pid);
	}

	public long addCandidateDetail(long cid, double rating, String feedback, SelStatus selStatus) {
		Candidate candidate = userRepository.find(Candidate.class, cid);
		candidate.setRating(rating);
		candidate.setFeedback(feedback);
		candidate.setSelStatus(selStatus);
		
		userRepository.save(candidate);
		
		return cid;	
	}

	public void sendMail(long cid, String roomId) {
		try {
		Candidate candidate = userRepository.find(Candidate.class, cid);
		String subject = "Interview Started";
		String text = "Hi " + candidate.getFirstName() + " " + candidate.getLastName()
		+" Your interview has been started, click this link to join the room of your interview  "
		+ roomId
		+ "\nThank you!";
		
		emailService.sendEmail(candidate.getEmailId(), text, subject);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ServiceException("No rows ");
		}
	}

/*	public void mapCanPan(Interview interview) {

		userRepository.save(interview);
	}*/

}
