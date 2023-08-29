package com.cg.flightmgmt.controller;

import java.math.BigInteger;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.dao.BookingDao;
import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.exception.BookingNotFoundException;

@RestController
@RequestMapping("/booking")
public class BookingController {
	Logger logger=org.slf4j.LoggerFactory.getLogger(BookingController.class);
	
	@Autowired
	private BookingDao dao;
	
	//localhost:5010/booking/createBooking?userId=&scheduleFlightId=
	@PostMapping(path="/createBooking")
	public void createBooking(@Valid @RequestBody Booking booking, @RequestParam("userId") BigInteger userId,
			@RequestParam("scheduleFlightId") BigInteger scheduleFlightId) {
		logger.info("New Booking created sucessfully");
		dao.addBooking(booking, userId, scheduleFlightId);
	}
	
	//localhost:5010/booking/viewBookings
	@GetMapping("/viewBookings")
    public List<Booking> viewBookings(){
    	return dao.viewBookings();   	
    }
	
	//localhost:5010/booking/deleteBooking/:id
	@DeleteMapping(path="deleteBooking/{bookingId}")
	public void deletebooking(@PathVariable("bookingId") BigInteger bookingId) {
		logger.info("Booking cancelled");
    	dao.deleteBooking(bookingId);
    }
    
	//localhost:5010/booking/updateBooking/:id
    @PutMapping("/updateBooking/{id}")
    public Booking updateBooking(@RequestBody Booking booking, @PathVariable int id) {
    	logger.info("Booking details modified");
    	return dao.modifyBooking(booking);
    }
    
  //localhost:5010/booking/viewBookings/:id
    @GetMapping("/viewBookings/{bookingId}")
    public Booking getBooking(@PathVariable(name="bookingId") BigInteger bookingId) throws BookingNotFoundException {
    	return dao.viewBooking(bookingId);
    }
}