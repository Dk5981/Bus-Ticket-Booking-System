package com.busticketbooking.service;

import java.util.List;

import com.busticketbooking.bean.Bus;

public interface BusService {

	public String addBusDetails(Bus bus);

	public List<Bus> getBusDetails();

	public Bus getBusDetails(int busId);

	public String editBusDetails(Bus bus);

}
