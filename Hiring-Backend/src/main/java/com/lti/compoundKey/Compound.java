/*package com.lti.compoundKey;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.lti.entity.Candidate;
import com.lti.entity.Panellist;

public class Compound implements Serializable {

	
	@OneToOne
	@JoinColumn(name="p_id")
	private Panellist panellist;
	
	@OneToOne
	@JoinColumn(name="c_id")
	private Candidate candidate;

	public Panellist getPanellist() {
		return panellist;
	}

	public void setPanellist(Panellist panellist) {
		this.panellist = panellist;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	
}*/
