package com.busticketbooking.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.busticketbooking.bean.Bus;
import com.busticketbooking.service.BusService;
import com.busticketbooking.service.impl.BusServiceImpl;

/**
 * Servlet implementation class UpdateBusDetails
 */
public class UpdateBusDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BusService busService = new BusServiceImpl();
	Bus bus = new Bus();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateBusDetails() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Id = request.getParameter("busId");
		String busNumber = request.getParameter("busNumber");
		String busName = request.getParameter("busName");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String totalSeats = request.getParameter("seats");
		String price = request.getParameter("price");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String availableSeats = request.getParameter("availableSeats");
		
		int busId = Integer.valueOf(Id);
		
		bus.setBusId(busId);
		bus.setBusNumber(Integer.valueOf(busNumber));
		bus.setBusName(busName);
		bus.setBusSource(source);
		bus.setBusDestination(destination);
		bus.setTotalSeats(Integer.valueOf(totalSeats));
		bus.setPrice(Integer.valueOf(price));
		bus.setDate(date);
		bus.setTime(time);
		bus.setAvailableSeats(Integer.valueOf(availableSeats));
		
		busService.editBusDetails(bus);
		
		response.sendRedirect("ViewBusesReport");
	}
}