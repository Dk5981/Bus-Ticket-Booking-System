package com.busticketbooking.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.busticketbooking.bean.User;

public interface UserDao {

	public int registerUserDetails(Connection connection, User user) throws SQLException;
}
