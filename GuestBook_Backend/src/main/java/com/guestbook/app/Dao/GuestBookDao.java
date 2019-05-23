package com.guestbook.app.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.guestbook.app.entity.GuestDetails;

@Repository
public interface GuestBookDao extends CrudRepository<GuestDetails, Integer>{

	GuestDetails findByUserId(Integer userId);

}
