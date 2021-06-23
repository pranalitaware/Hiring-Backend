package com.lti.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.entity.Candidate;
import com.lti.entity.Panellist;

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
				.createQuery("select c from Candidate c")
				.getResultList();
		return canList;
	}

	public Candidate fetchCandidateById(long cid) {
		return entityManager.find(Candidate.class, cid);
	}

	public Candidate fetchCandidateByName(String firstName) {
		return (Candidate)
				entityManager
				.createQuery("select c from Candidate c where c.firstName = :fn")
				.setParameter("fn", firstName)
				.getSingleResult();
	}

	public Panellist fetchPanellistById(long pid) {
		return entityManager.find(Panellist.class, pid);
	}
	
	public Panellist fetchPanellistByName(String firstName) {
		return (Panellist)
				entityManager
				.createQuery("select p from Panellist p where p.firstName = :fn")
				.setParameter("fn", firstName)
				.getSingleResult();
	}

	public void linkCanPan(long cid, long pid) {
		entityManager
		.createNativeQuery("update tbl_candidate set p_id=? where c_id=?")
		.setParameter(1, pid)
		.setParameter(2, cid)
		.executeUpdate();
	}

	public long fetchIdByLoginIdAndPassword(long pid, String password) {
		return (Long)
				entityManager
				.createQuery("select p.pid from Panellist p where p.pid = :pi and p.password= :pw")
				.setParameter("pi", pid)
				.setParameter("pw", password)
				.getSingleResult();
	}
}
