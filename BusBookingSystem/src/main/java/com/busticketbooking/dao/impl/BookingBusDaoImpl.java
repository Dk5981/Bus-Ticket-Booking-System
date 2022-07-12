package com.busticketbooking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.busticketbooking.bean.Booking;
import com.busticketbooking.dao.BookingBusDao;

public class BookingBusDaoImpl implements BookingBusDao {

	@Override
	public int registerUserDetails(Connection connection, Booking booking) throws SQLException {
		int result = 0;
		String insertQuery = "insert into booking(user_id, bus_id, seats, cost, booking_date) values(?,?,?,?,?)";
		try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
			ps.setInt(1, booking.getUserId());
			ps.setInt(2, booking.getBusId());
			ps.setInt(3, booking.getSeats());
			ps.setInt(4, booking.getCost());
			ps.setString(5, booking.getBookingDate());

			result = ps.executeUpdate();
		}
		return result;
	}

	@Override
	public List<Booking> selectMyBooking(Connection connection, int userId) throws SQLException {
		List<Booking> bookingList = new ArrayList<Booking>();

		String selectQuery = "select * from booking where user_id = ?";
		try (PreparedStatement ps = connection.prepareStatement(selectQuery)) {

			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Booking booking = new Booking();

				booking.setBookingId(rs.getInt("booking_id"));
				booking.setUserId(rs.getInt("user_id"));
				booking.setBusId(rs.getInt("bus_id"));
				booking.setSeats(rs.getInt("seats"));
				booking.setBookingDate(rs.getString("booking_date"));
				booking.setCost(rs.getInt("cost"));

				bookingList.add(booking);
			}
		}
		return bookingList;
	}

	@Override
	public List<Booking> getAllBooking(Connection connection) throws SQLException {
		List<Booking> bookingList = new ArrayList<Booking>();

		String selectQuery = "select * from booking";

		try (PreparedStatement ps = connection.prepareStatement(selectQuery)) {

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Booking booking = new Booking();

				booking.setBookingId(rs.getInt("booking_id"));
				booking.setUserId(rs.getInt("user_id"));
				booking.setBusId(rs.getInt("bus_id"));
				booking.setSeats(rs.getInt("seats"));
				booking.setBookingDate(rs.getString("booking_date"));
				booking.setCost(rs.getInt("cost"));
				
				bookingList.add(booking);
			}
		}
		return bookingList;
	}
}