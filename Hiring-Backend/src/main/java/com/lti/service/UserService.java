package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Candidate;
import com.lti.entity.Panellist;
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
}
