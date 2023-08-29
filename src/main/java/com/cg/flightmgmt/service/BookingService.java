package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.List;

import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.dto.Passenger;
import com.cg.flightmgmt.exception.BookingNotFoundException;

public interface BookingService {
	public void addBooking(Booking booking, BigInteger UserId,BigInteger flightId);
	public List<Booking> viewBookings();
	public void deleteBooking(BigInteger bookingid);
	public Booking modifyBooking(Booking booking);
	public Booking viewBooking(BigInteger bookingid) throws BookingNotFoundException;
	public boolean validateBooking(Booking booking);
	public void validatePassenger(Passenger passenger);
}
