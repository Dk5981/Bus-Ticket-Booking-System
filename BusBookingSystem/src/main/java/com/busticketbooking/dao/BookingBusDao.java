package com.busticketbooking.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.busticketbooking.bean.Booking;

public interface BookingBusDao {

	public int registerUserDetails(Connection connection, Booking booking) throws SQLException;

	public List<Booking> selectMyBooking(Connection connection, int userId) throws SQLException;

	public List<Booking> getAllBooking(Connection connection) throws SQLException;

}
