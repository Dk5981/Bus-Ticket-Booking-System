package com.busticketbooking.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import com.busticketbooking.bean.Bus;

public interface BusDao {

	public int registerBusDetails(Connection connection, Bus bus) throws SQLException, ParseException;

}
