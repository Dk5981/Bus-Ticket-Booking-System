package com.busticketbooking.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.busticketbooking.bean.Bus;
import com.busticketbooking.dao.BusDao;

public class BusDaoImpl implements BusDao {

//	DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");

	@Override
	public int registerBusDetails(Connection connection, Bus bus) throws SQLException, ParseException {
		int result = 0;

		String insertQuery = "insert into bus(bus_number, bus_name, source, destination, total_seats, price, available_seats, date, time, status) values(?,?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
			ps.setInt(1, bus.getBusNumber());
			ps.setString(2, bus.getBusName());
			ps.setString(3, bus.getBusSource());
			ps.setString(4, bus.getBusDestination());
			ps.setInt(5, bus.getTotalSeats());
			ps.setInt(6, bus.getPrice());
			ps.setInt(7, bus.getAvailableSeats());
			ps.setString(8, bus.getDate());
			ps.setString(9, bus.getTime());
			ps.setInt(10, bus.getStatus());

			result = ps.executeUpdate();
		}
		return result;
	}
}