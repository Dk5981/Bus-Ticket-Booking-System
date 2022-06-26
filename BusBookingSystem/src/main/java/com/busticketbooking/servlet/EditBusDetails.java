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
 * Servlet implementation class EditBusDetails
 */
public class EditBusDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BusService busService = new BusServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBusDetails() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String Id = request.getParameter("id");
		
		int busId = Integer.valueOf(Id);
				
		Bus bus = busService.getBusDetails(busId);
				
		request.setAttribute("busDetails", bus);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("editbus.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
