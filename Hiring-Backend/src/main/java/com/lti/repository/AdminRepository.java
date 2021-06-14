/*package com.lti.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.entity.Registration;

@Repository
public class AdminRepository extends GenericRepository{

	public List<Registration> fetchRegistrationRequestForAdmin() {
		List<Registration> resultList = (List<Registration>)
				entityManager
				.createQuery("select r from Registration r")
				.getResultList();
		return resultList;
	}

	public Registration fetchRegistrationFileForAdmin(Long userId) {
		Registration result = (Registration)
				entityManager
				.createQuery("select r from Registration r where r.userId = :uid ")
				.setParameter("uid",userId)
				.getSingleResult() ;
		return result;
	}

	public void deleteById(Registration reg) {
		entityManager.remove(reg);
	}
}
*/