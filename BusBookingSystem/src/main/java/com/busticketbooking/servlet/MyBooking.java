package com.busticketbooking.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.busticketbooking.bean.Booking;
import com.busticketbooking.bean.Bus;
import com.busticketbooking.bean.User;
import com.busticketbooking.service.BookingBusService;
import com.busticketbooking.service.BusService;
import com.busticketbooking.service.impl.BookingBusServiceImpl;
import com.busticketbooking.service.impl.BusServiceImpl;

/**
 * Servlet implementation class MyBooking
 */
public class MyBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BookingBusService bookingBus = new BookingBusServiceImpl();
	
	BusService busService = new BusServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyBooking() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession httpSession = request.getSession(false);
		User user = (User) httpSession.getAttribute("userObject");
		
		int userId = user.getUserId();

		List<Booking> bookingList = bookingBus.getUserBooking(userId);
		
		List<Bus> busList = busService.getBusDetails();
		
		if (bookingList.size() == 0) {
			request.setAttribute("plzBookTicket", "Sorry! No ticket are available.");

			RequestDispatcher dispatcher = request.getRequestDispatcher("mybooking.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("myBookingList", bookingList);
			request.setAttribute("busList", busList);
			request.setAttribute("user", user);


			RequestDispatcher dispatcher = request.getRequestDispatcher("mybooking.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
