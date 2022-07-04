package com.busticketbooking.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.busticketbooking.bean.Booking;
import com.busticketbooking.dao.BookingBusDao;
import com.busticketbooking.dao.impl.BookingBusDaoImpl;
import com.busticketbooking.service.BookingBusService;

public class BookingBusServiceImpl implements BookingBusService {
	
	BookingBusDao bookingBusDao = new BookingBusDaoImpl();

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/busbookingsystem", "root",
					"root");
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String addBookingDetails(Booking booking) {
		try (Connection connection = getConnection()) {
			int result = bookingBusDao.registerUserDetails(connection, booking);

			if (result > 0) {
				return "Booking is Successfull!";
			} else {
				return "Registration is not Done.";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
