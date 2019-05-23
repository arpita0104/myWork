package com.guestbook.app.entity;

import java.util.Calendar;

import javax.persistence.*;

@Entity  
@Table(name="guest_details") 
public class GuestDetails {

	@Id @GeneratedValue
	@Column(name = "guest_id")
	private Integer guestId;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "contact_number")
	private Integer contactNo;
	
	@Column(name = "confirmation_status")
	private String confirmationStatus;
	
	@Column(name = "crtn_dt")
	private Calendar crtnDate;
	
	@Column(name = "hist_rcd_flag")
	private String histRcdFlag;
	
	@Column(name = "last_uptd_dt")
	private Calendar lastUptdDate;
	
	@Column(name = "last_uptd_userId")
	private int lastUptdUserId;
	
	public GuestDetails() {
		super();
	}

	public GuestDetails(int i, String string, String string2, int j, String string3, Calendar instance, String string4,
			Calendar instance2, int k) {
		// TODO Auto-generated constructor stub
	}

	public Integer getGuestId() {
		return guestId;
	}

	public void setGuestId(Integer guestId) {
		this.guestId = guestId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getContactNo() {
		return contactNo;
	}

	public void setContactNo(Integer contactNo) {
		this.contactNo = contactNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getConfirmationStatus() {
		return confirmationStatus;
	}

	public void setConfirmationStatus(String confirmationStatus) {
		this.confirmationStatus = confirmationStatus;
	}

	public Calendar getCrtnDate() {
		return crtnDate;
	}

	public void setCrtnDate(Calendar crtnDate) {
		this.crtnDate = crtnDate;
	}

	public String getHistRcdFlag() {
		return histRcdFlag;
	}

	public void setHistRcdFlag(String histRcdFlag) {
		this.histRcdFlag = histRcdFlag;
	}

	public Calendar getLastUptdDate() {
		return lastUptdDate;
	}

	public void setLastUptdDate(Calendar lastUptdDate) {
		this.lastUptdDate = lastUptdDate;
	}

	public int getLastUptdUserId() {
		return lastUptdUserId;
	}

	public void setLastUptdUserId(int lastUptdUserId) {
		this.lastUptdUserId = lastUptdUserId;
	}
}
