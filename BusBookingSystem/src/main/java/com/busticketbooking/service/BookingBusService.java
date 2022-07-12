package com.busticketbooking.service;

import java.util.List;

import com.busticketbooking.bean.Booking;

public interface BookingBusService {

	public String addBookingDetails(Booking booking);

	public List<Booking> getUserBooking(int userId);

	public List<Booking> getBookingDetails();

}
