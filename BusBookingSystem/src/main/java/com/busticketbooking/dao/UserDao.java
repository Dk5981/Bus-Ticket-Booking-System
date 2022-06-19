package com.busticketbooking.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.busticketbooking.bean.User;

public interface UserDao {

	public int registerUserDetails(Connection connection, User user) throws SQLException;

	public int checkEmailExists(Connection connection, String email) throws SQLException;

	public User verifyEmailExists(Connection connection, String email, String password) throws SQLException;

	public String getUserPassword(Connection connection, String password) throws SQLException;
}
