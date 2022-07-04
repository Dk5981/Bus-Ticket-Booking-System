package com.busticketbooking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.busticketbooking.bean.Booking;
import com.busticketbooking.dao.BookingBusDao;

public class BookingBusDaoImpl implements BookingBusDao {

	@Override
	public int registerUserDetails(Connection connection, Booking booking) throws SQLException {
		int result = 0;
		String insertQuery = "insert into booking(user_id, bus_id, seats, cost) values(?,?,?,?)";
		try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
			ps.setInt(1, booking.getUserId());
			ps.setInt(2, booking.getBusId());
			ps.setInt(3, booking.getSeats());
			ps.setInt(4, booking.getCost());
		
			result = ps.executeUpdate();
		}
		return result;
	}
}
