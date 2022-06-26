package com.busticketbooking.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.busticketbooking.bean.Bus;

public interface BusDao {

	public int registerBusDetails(Connection connection, Bus bus) throws SQLException, ParseException;

	public List<Bus> selectBusDetails(Connection connection) throws SQLException;

	public Bus selectBusDetails(Connection connection, int busId) throws SQLException;

	public int updateBusDetails(Connection connection, Bus bus) throws SQLException;

}
