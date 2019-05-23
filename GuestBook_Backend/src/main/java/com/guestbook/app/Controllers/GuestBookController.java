package com.guestbook.app.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guestbook.app.entity.GuestDetails;
import com.guestbook.app.entity.LoginInfo;
import com.guestbook.app.model.UserInfo;
import com.guestbook.app.service.GuestBookService;

@RestController
@RequestMapping("/api/guests")
public class GuestBookController {

	@Autowired
	private GuestBookService guestBookService;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/register")
	public void registerGuest(@Valid @RequestBody UserInfo guestData) {
		guestBookService.createGuestEntry(guestData.getGuestBook(),guestData.getUserName());
	}

	@GetMapping("/getList")
	public List<GuestDetails> getGuestList() {
		return guestBookService.fetchGuestList();
	}

	@PostMapping("/reject")
	public void rejectGuestEntry(@Valid @RequestBody GuestDetails guestData) {
		guestBookService.rejectGuestEntry(guestData);
	}

	@PostMapping("/approve")
	public void approveGuest(@Valid @RequestBody GuestDetails guestData) {
		guestBookService.approveGuest(guestData);
	}

	@PostMapping("/signupUser")
	public String signupUser(@RequestBody LoginInfo info) {
		String message = "";
		guestBookService.createGuestSignUp(info, message);
		return message;
	}

	@GetMapping("/validateUser")
	public UserInfo validateUser(@RequestParam String userName,  @RequestParam String password) {
		return guestBookService.validateGuest(userName,password);
	}

}
