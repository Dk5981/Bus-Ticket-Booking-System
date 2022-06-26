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
 * Servlet implementation class ViewBusesReport
 */
public class ViewBusesReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BusService busService = new BusServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewBusesReport() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Bus> busList = busService.getBusDetails();

		if(null != busList)
		{
			for(Bus bus : busList)
			{
				System.out.println(bus.toString());
			}
		}
		
		request.setAttribute("busList", busList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("viewbuses.jsp");
		dispatcher.forward(request, response);
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
