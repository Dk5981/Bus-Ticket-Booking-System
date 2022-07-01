package com.busticketbooking.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.busticketbooking.bean.Bus;
import com.busticketbooking.service.BusService;
import com.busticketbooking.service.impl.BusServiceImpl;

/**
 * Servlet implementation class SearchBus
 */
public class SearchBus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BusService busService = new BusServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchBus() {
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

		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String date = request.getParameter("date");
		String seat = request.getParameter("seats");
		
		int seats = Integer.parseInt(seat);

		List<Bus> availableBuses = busService.searchAvailableBuses(source, destination, date, seats);

		if (availableBuses.size() == 0) {
			request.setAttribute("busNotAvailable", "Sorry! Buses not Available.");

			RequestDispatcher dispatcher = request.getRequestDispatcher("searchbuses.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("availableBuses", availableBuses);
			request.setAttribute("seats", seats);

			RequestDispatcher dispatcher = request.getRequestDispatcher("availablesearchbuses.jsp");
			dispatcher.forward(request, response);
		}
	}
}