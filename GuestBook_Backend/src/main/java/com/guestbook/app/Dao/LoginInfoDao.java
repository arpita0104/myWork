package com.guestbook.app.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.guestbook.app.entity.GuestDetails;
import com.guestbook.app.entity.LoginInfo;

@Repository
public interface LoginInfoDao extends CrudRepository<LoginInfo, Integer>{

	public LoginInfo findByUserName(String userName);
	
}
