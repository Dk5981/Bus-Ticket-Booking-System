package com.busticketbooking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

}
