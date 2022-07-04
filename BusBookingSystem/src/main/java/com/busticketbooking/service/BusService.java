package com.busticketbooking.service;

import java.util.List;

import com.busticketbooking.bean.Bus;

public interface BusService {

	public String addBusDetails(Bus bus);

	public List<Bus> getBusDetails();

	public Bus getBusDetails(int busId);

	public String editBusDetails(Bus bus);

	public void removeBus(int busId);

	public List<Bus> searchAvailableBuses(String source, String destination, String date, int seats);

	public String setAvailableSeats(int busId, int seats);

}
