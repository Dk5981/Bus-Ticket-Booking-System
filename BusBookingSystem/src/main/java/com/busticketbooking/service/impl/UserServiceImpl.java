package com.busticketbooking.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.busticketbooking.bean.User;
import com.busticketbooking.dao.UserDao;
import com.busticketbooking.dao.impl.UserDaoImpl;
import com.busticketbooking.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();

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
	public String saveUserRegistration(User user) {

		try (Connection connection = getConnection()) {
			int result = userDao.registerUserDetails(connection, user);

			if (result > 0) {
				return "Registration is Successfull!";
			} else {
				return "Registration is not Done.";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int checkEmailExist(String email) {
		try (Connection connection = getConnection()) {
			int result = userDao.checkEmailExists(connection, email);

			if (result > 0) {
				return 1;
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public User checkLoginDetails(String email, String password) {
		try (Connection connection = getConnection()) {
			User user = userDao.verifyEmailExists(connection, email, password);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String fetchPassword(String email) {
		try (Connection connection = getConnection()) {
			String password = userDao.getUserPassword(connection, email);
			return password;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}