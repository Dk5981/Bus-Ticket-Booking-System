package com.busticketbooking.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.busticketbooking.service.BusService;
import com.busticketbooking.service.impl.BusServiceImpl;

/**
 * Servlet implementation class DeleteBus
 */
public class DeleteBus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BusService busService = new BusServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteBus() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("busid");

		int busId = Integer.parseInt(id);

		busService.removeBus(busId);
		
		response.sendRedirect("ViewBusesReport");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
