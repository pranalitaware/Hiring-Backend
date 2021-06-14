package com.lti.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.entity.Candidate;

@Repository
public class UserRepository extends GenericRepository {

	public boolean isUserPresent(long mobileNo) {
		return (Long)
				entityManager
				.createQuery( "select count(c.mobileNo) from Candidate c where c.mobileNo = :mob")
				.setParameter("mob",mobileNo)
				.getSingleResult() == 1 ? true : false;
	}
	
	public List<Candidate> fetchAllCandidates() {
		List<Candidate> canList = (List<Candidate>)
				entityManager
				.createQuery("select c from Candidate")
				.getResultList();
		return canList;
	}
}
