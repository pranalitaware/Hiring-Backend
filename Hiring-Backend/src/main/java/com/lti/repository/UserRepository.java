package com.lti.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends GenericRepository {

	public boolean isUserPresent(long mobileNo) {
		return (Long)
				entityManager
				.createQuery( "select count(c.mobileNo) from Candidate c where c.mobileNo = :mob")
				.setParameter("mob",mobileNo)
				.getSingleResult() == 1 ? true : false;
	}
}
