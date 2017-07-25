/**
 * 
 */
package io.gocanvas.integration.ats.middleware.greenhouse.models;

import java.util.List;

/**
 * @author Prodapt Solutions
 *
 */
public class GreenHouseCandiateApplications {

	private String id;
	private String candidate_id;
	private List<GreenHouseJobs> jobs;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCandidate_id() {
		return candidate_id;
	}
	public void setCandidate_id(String candidate_id) {
		this.candidate_id = candidate_id;
	}
	public List<GreenHouseJobs> getJobs() {
		return jobs;
	}
	public void setJobs(List<GreenHouseJobs> jobs) {
		this.jobs = jobs;
	}
	
	@Override
	public String toString() {
		return "GreenHouseCandiateApplications [id=" + id + ", candidate_id=" + candidate_id + ", jobs=" + jobs + "]";
	}
	
	
	
}
