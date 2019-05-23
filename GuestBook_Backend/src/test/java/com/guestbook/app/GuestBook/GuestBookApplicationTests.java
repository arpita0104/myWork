package com.guestbook.app.GuestBook;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.guestbook.app.Dao.GuestBookDao;
import com.guestbook.app.Dao.LoginInfoDao;
import com.guestbook.app.entity.GuestDetails;
import com.guestbook.app.service.GuestBookService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GuestBookApplicationTests {

	@Autowired
	private GuestBookService guestService;
	
	@MockBean
	private GuestBookDao guestRepository;
	
	@MockBean
	private LoginInfoDao loginRepository;
	
	@Test
	public void getAllGuestLlist() {
		when(guestRepository.findAll()).thenReturn(Stream.of(new GuestDetails(1,"Harry","Avalon",99099099,"Pending Confirmation",Calendar.getInstance(),
				"N",Calendar.getInstance(),1)).collect(Collectors.toList()));
		assertEquals(1, guestService.fetchGuestList().size());
	}
	
	/*
	 * @Test public void saveGuestData() { GuestDetails details = new
	 * GuestDetails(1, "ron", "wig", 897878980, "Approved", Calendar.getInstance(),
	 * "N", Calendar.getInstance(), 1);
	 * when(guestRepository.save(details)).thenReturn(details);
	 * assertEquals(details, guestService.createGuestEntry(details,null)); }
	 */

}
