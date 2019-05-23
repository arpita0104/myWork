package com.guestbook.app.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;

import com.guestbook.app.entity.GuestDetails;
import com.guestbook.app.entity.LoginInfo;
import com.guestbook.app.model.UserInfo;

public interface GuestBookService {

	void createGuestEntry(GuestDetails guestBook, String userName);

	List<GuestDetails> fetchGuestList();

	void rejectGuestEntry(@Valid GuestDetails guestData);

	void approveGuest(@Valid GuestDetails guestData);

	void createGuestSignUp(LoginInfo info, String message);

	UserInfo validateGuest(String userName, String password);


}
