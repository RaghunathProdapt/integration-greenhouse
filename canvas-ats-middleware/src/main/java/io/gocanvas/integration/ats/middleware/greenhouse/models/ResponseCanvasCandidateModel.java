package io.gocanvas.integration.ats.middleware.greenhouse.models;

import java.util.List;

/**
 * @author Prodapt Solutions
 *
 */
public class ResponseCanvasCandidateModel {
	
	private String id;
	private String first_name;
	private String last_name;
	private String company;
	private String title;
	private List<GreenHouseCandidateAttachments> attachments;
	private List<GreenHouseCandidatePhoneNumber> phoneNumber;
	private List<GreenHouseCandidateEmailAddress> emailAddress;
	private List<GreenHouseCandidateSocialMediaLinks> socialMediaLinks;
	private List<GreenHouseCandiateApplications> applications;

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getFirstname() {
		return first_name;
	}

	public void setFirstname(String firstname) {
		this.first_name = firstname;
	}

	public String getLastname() {
		return last_name;
	}

	public void setLastname(String lastname) {
		this.last_name = lastname;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	
	
	

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public List<GreenHouseCandidateAttachments> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<GreenHouseCandidateAttachments> attachments) {
		this.attachments = attachments;
	}

	public List<GreenHouseCandidatePhoneNumber> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(List<GreenHouseCandidatePhoneNumber> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<GreenHouseCandidateEmailAddress> getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(List<GreenHouseCandidateEmailAddress> emailAddress) {
		this.emailAddress = emailAddress;
	}

	public List<GreenHouseCandidateSocialMediaLinks> getSocialMediaLinks() {
		return socialMediaLinks;
	}

	public void setSocialMediaLinks(List<GreenHouseCandidateSocialMediaLinks> socialMediaLinks) {
		this.socialMediaLinks = socialMediaLinks;
	}
	
	
	

	public List<GreenHouseCandiateApplications> getApplications() {
		return applications;
	}

	public void setApplications(List<GreenHouseCandiateApplications> applications) {
		this.applications = applications;
	}

	
	@Override
	public String toString() {
		return "ResponseCanvasCandidateModel [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", company=" + company + ", title=" + title + ", attachments=" + attachments + ", phoneNumber="
				+ phoneNumber + ", emailAddress=" + emailAddress + ", socialMediaLinks=" + socialMediaLinks
				+ ", applications=" + applications + "]";
	}

	
	
	
}
