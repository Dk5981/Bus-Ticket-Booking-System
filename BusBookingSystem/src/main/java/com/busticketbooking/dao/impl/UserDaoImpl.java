package com.busticketbooking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.busticketbooking.bean.User;
import com.busticketbooking.dao.UserDao;

public class UserDaoImpl implements UserDao {

	@Override
	public int registerUserDetails(Connection connection, User user) throws SQLException {
		int result = 0;
		String insertQuery = "insert into user(first_name, last_name, address, email_id, contact, password, role, status) values(?,?,?,?,?,?,?,?)";
		try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getAddress());
			ps.setString(4, user.getEmailId());
			ps.setString(5, user.getContact());
			ps.setString(6, user.getPassword());
			ps.setString(7, "User");
			ps.setInt(8, 1);
			result = ps.executeUpdate();
		}
		return result;
	}

	@Override
	public int checkEmailExists(Connection connection, String email) throws SQLException {
		int result = 0;
		String getAllEmails = "select * from user";
		try (PreparedStatement ps = connection.prepareStatement(getAllEmails)) {
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				if (email.equals(resultSet.getString("email_id")) && resultSet.getInt("status") == 1) {
					result = 1;
				}
			}
		}
		return result;
	}

	@Override
	public User verifyEmailExists(Connection connection, String email, String password) throws SQLException {
		User user = new User();
		String fetchUserDetails = "select * from user";
		try (PreparedStatement ps = connection.prepareStatement(fetchUserDetails)) {
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				if (email.equals(resultSet.getString("email_id")) && password.equals(resultSet.getString("password"))
						&& (resultSet.getInt("status") == 1)) {
					user.setUserId(resultSet.getInt("user_id"));
					user.setFirstName(resultSet.getString("first_name"));
					user.setLastName(resultSet.getString("last_name"));
					user.setAddress(resultSet.getString("address"));
					user.setEmailId(resultSet.getString("email_id"));
					user.setContact(resultSet.getString("contact"));
					user.setPassword(resultSet.getString("password"));
					user.setRole(resultSet.getString("role"));
					user.setStatus(resultSet.getInt("status"));
				}
			}
		}
		return user;
	}

	@Override
	public String getUserPassword(Connection connection, String password) throws SQLException {
		String pwd = null;
		String getPassword = "select password from user where email_id=?";
		try (PreparedStatement ps = connection.prepareStatement(getPassword)) {
			ps.setString(1, password);

			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				pwd = resultSet.getString("password");
			}
			return pwd;
		}
	}

	@Override
	public User selectUserDetails(Connection connection, int userId) throws SQLException {
		User user = new User();
		String selectUser = "select * from user where user_id=?";
		try (PreparedStatement ps = connection.prepareStatement(selectUser)) {
			ps.setInt(1, userId);

			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				
				user.setUserId(resultSet.getInt("user_id"));
				user.setFirstName(resultSet.getString("first_name"));
				user.setLastName(resultSet.getString("last_name"));
				user.setAddress(resultSet.getString("address"));
				user.setEmailId(resultSet.getString("email_id"));
				user.setContact(resultSet.getString("contact"));
				user.setRole(resultSet.getString("role"));
			}
			return user;
		}
	}
}