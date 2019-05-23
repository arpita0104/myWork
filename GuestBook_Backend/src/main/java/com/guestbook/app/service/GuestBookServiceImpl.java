package com.guestbook.app.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guestbook.app.Dao.GuestBookDao;
import com.guestbook.app.Dao.LoginInfoDao;
import com.guestbook.app.entity.GuestDetails;
import com.guestbook.app.entity.LoginInfo;
import com.guestbook.app.model.UserInfo;

@Service
public class GuestBookServiceImpl implements GuestBookService{
	

	 @Autowired
	 private GuestBookDao guestBookDao;
	 
	 @Autowired
	 private LoginInfoDao loginInfoDao;
	 

	@Override
	public void createGuestEntry(GuestDetails guestBook, String userName) {
		LoginInfo loginInfo =  loginInfoDao.findByUserName(userName);
		guestBook.setConfirmationStatus("Pending Confirmation");
		guestBook.setHistRcdFlag("N");
		guestBook.setCrtnDate(Calendar.getInstance());
		guestBook.setLastUptdDate(Calendar.getInstance());
		guestBook.setLastUptdUserId(loginInfo.getUserId());
		guestBook.setUserId(loginInfo.getUserId());
		guestBookDao.save(guestBook);
		
	}


	@Override
	public List<GuestDetails> fetchGuestList() {
		List<GuestDetails> guestDetails = new ArrayList<GuestDetails>();
		guestBookDao.findAll().forEach(guestDetails::add);
		return guestDetails;
	}


	@Override
	public void rejectGuestEntry(@Valid GuestDetails guestData) {
		guestData.setConfirmationStatus("Rejected");
		guestData.setLastUptdDate(Calendar.getInstance());
		guestData.setLastUptdUserId(guestData.getUserId());
		guestData.setHistRcdFlag("Y");
		guestBookDao.save(guestData);
		
	}


	@Override
	public void approveGuest(@Valid GuestDetails guestData) {
		guestData.setConfirmationStatus("Approved");
		guestData.setLastUptdDate(Calendar.getInstance());
		guestData.setLastUptdUserId(guestData.getUserId());
		guestBookDao.save(guestData);
	}


	@Override
	public void createGuestSignUp(LoginInfo info, String message) {
		LoginInfo loginInfo =  loginInfoDao.findByUserName(info.getUserName());
		  if(loginInfo !=null){
			  message="User name already in use!";
		  }else {
			  loginInfoDao.save(info);
		  }
		
	}


	@Override
	public UserInfo validateGuest(String userName, String password) {
		UserInfo info = new UserInfo();
		GuestDetails detail= new GuestDetails();
		LoginInfo loginInfo =  loginInfoDao.findByUserName(userName);
		  if(loginInfo !=null){
			  if(loginInfo.getPassword().equalsIgnoreCase(password)){
				  detail = guestBookDao.findByUserId(loginInfo.getUserId());
			  }else {
				  info.setValidationMsg("Invalid username and password");
			  }
		  }else{
			  info.setValidationMsg("Please signup in order to create login");
		  }
		  info.setGuestBook(detail);
		  info.setUserName(userName);
		  return info;
		
	}

}
