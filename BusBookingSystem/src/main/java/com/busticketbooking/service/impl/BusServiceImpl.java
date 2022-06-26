package com.busticketbooking.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.busticketbooking.bean.Bus;
import com.busticketbooking.dao.BusDao;
import com.busticketbooking.dao.impl.BusDaoImpl;
import com.busticketbooking.service.BusService;

public class BusServiceImpl implements BusService {

	BusDao busDao = new BusDaoImpl();

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
	public String addBusDetails(Bus bus) {
		try (Connection connection = getConnection()) {
			int result = busDao.registerBusDetails(connection, bus);

			if (result > 0) {
				return "Bus Details Registred Successfully!";
			} else {
				return "Bus Registration is Failed..";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Bus> getBusDetails() {
		List<Bus> busList = null;
		try (Connection connection = getConnection()) {
			busList = busDao.selectBusDetails(connection);

		} catch (SQLException e) {
			e.printStackTrace();
			return busList;
		}
		return busList;
	}

	@Override
	public Bus getBusDetails(int busId) {
		try (Connection connection = getConnection()) {
			Bus bus = busDao.selectBusDetails(connection, busId);
			return bus;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String editBusDetails(Bus bus) {
		try (Connection connection = getConnection()) {
			int result = busDao.updateBusDetails(connection, bus);

			if (result > 0) {
				return "Bus Details Updated Successfully!";
			} else {
				return "Bus Details is not Updated.";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
