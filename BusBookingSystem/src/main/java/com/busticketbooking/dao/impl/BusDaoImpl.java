package com.busticketbooking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<Bus> selectBusDetails(Connection connection) throws SQLException {

		List<Bus> busList = new ArrayList<Bus>();

		String selectQuery = "select * from bus";
		try (PreparedStatement ps = connection.prepareStatement(selectQuery)) {
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				Bus bus = new Bus();

				bus.setBusId(resultSet.getInt("bus_id"));
				bus.setBusNumber(resultSet.getInt("bus_number"));
				bus.setBusName(resultSet.getString("bus_name"));
				bus.setBusSource(resultSet.getString("source"));
				bus.setBusDestination(resultSet.getString("destination"));
				bus.setTotalSeats(resultSet.getInt("total_seats"));
				bus.setPrice(resultSet.getInt("price"));
				bus.setAvailableSeats(resultSet.getInt("available_seats"));
				bus.setDate(resultSet.getString("date"));
				bus.setTime(resultSet.getString("time"));
				bus.setStatus(resultSet.getInt("status"));

				busList.add(bus);
			}
		}
		return busList;
	}

	@Override
	public Bus selectBusDetails(Connection connection, int busId) throws SQLException {

		Bus bus = new Bus();

		String selectQuery = "select * from bus where bus_id = ?";

		try (PreparedStatement ps = connection.prepareStatement(selectQuery)) {

			ps.setInt(1, busId);

			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				bus.setBusId(resultSet.getInt("bus_id"));
				bus.setBusNumber(resultSet.getInt("bus_number"));
				bus.setBusName(resultSet.getString("bus_name"));
				bus.setBusSource(resultSet.getString("source"));
				bus.setBusDestination(resultSet.getString("destination"));
				bus.setTotalSeats(resultSet.getInt("total_seats"));
				bus.setPrice(resultSet.getInt("price"));
				bus.setAvailableSeats(resultSet.getInt("available_seats"));
				bus.setDate(resultSet.getString("date"));
				bus.setTime(resultSet.getString("time"));
				bus.setStatus(resultSet.getInt("status"));
			}
		}
		return bus;
	}

	@Override
	public int updateBusDetails(Connection connection, Bus bus) throws SQLException {
		int result = 0;

		String updateQuery = "update bus set bus_number=?, bus_name=?, source=?, destination=?, total_seats=?, price=?, available_seats=?, date=?, time=? where bus_id=?";
		try (PreparedStatement ps = connection.prepareStatement(updateQuery)) {
			ps.setInt(1, bus.getBusNumber());
			ps.setString(2, bus.getBusName());
			ps.setString(3, bus.getBusSource());
			ps.setString(4, bus.getBusDestination());
			ps.setInt(5, bus.getTotalSeats());
			ps.setInt(6, bus.getPrice());
			ps.setInt(7, bus.getAvailableSeats());
			ps.setString(8, bus.getDate());
			ps.setString(9, bus.getTime());
			ps.setInt(10, bus.getBusId());

			result = ps.executeUpdate();
		}
		return result;
	}

	@Override
	public int deleteBus(Connection connection, int busId) throws SQLException {

		String deleteQuery = "update bus set status=? where bus_id=?";
		try (PreparedStatement ps = connection.prepareStatement(deleteQuery)) {
			ps.setInt(1, 0);
			ps.setInt(2, busId);

			return ps.executeUpdate();
		}
	}
}