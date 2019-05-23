package com.guestbook.app.model;

import com.guestbook.app.entity.GuestDetails;

public class UserInfo {

	private String userName;
	
	private String validationMsg;
	
	private GuestDetails guestBook;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public GuestDetails getGuestBook() {
		return guestBook;
	}

	public void setGuestBook(GuestDetails guestBook) {
		this.guestBook = guestBook;
	}

	public String getValidationMsg() {
		return validationMsg;
	}

	public void setValidationMsg(String validationMsg) {
		this.validationMsg = validationMsg;
	}

}
