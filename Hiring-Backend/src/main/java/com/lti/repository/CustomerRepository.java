package com.lti.repository;

import com.lti.entity.Registration;

import java.util.List;

public class CustomerRepository extends GenericRepository {

	public boolean isUserPresent(long userId) {
		return (Long)
				entityManager
				.createQuery( "select count(r.userId) from Registration r where r.userId = :id")
				.setParameter("id",userId)
				.getSingleResult() == 1 ? true : false;

	}

	public long fetchIdByLoginIdAndPassword(long customerId, String password) {
		return (Long)
				entityManager
				.createQuery("select l.customerId from Login l where l.customerId = :ci and l.password= :pw")
				.setParameter("ci", customerId)
				.setParameter("pw", password)
				.getSingleResult();
	}
	
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

	public void insertIntoLogin(long registration, long customerId, String password) {

		entityManager
		.createNativeQuery("insert into tbl_login_detail (uid, customer_id,password) values (?,?,?)")
		.setParameter(1, registration)
		.setParameter(2, customerId)
		.setParameter(3, password)
		.executeUpdate();
	}

}
