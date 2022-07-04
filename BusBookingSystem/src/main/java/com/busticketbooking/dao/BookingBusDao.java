package com.busticketbooking.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.busticketbooking.bean.Booking;

public interface BookingBusDao {

	public int registerUserDetails(Connection connection, Booking booking) throws SQLException;

}
