package com.busticketbooking.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.busticketbooking.bean.Booking;
import com.busticketbooking.bean.Bus;
import com.busticketbooking.bean.User;
import com.busticketbooking.service.BookingBusService;
import com.busticketbooking.service.BusService;
import com.busticketbooking.service.UserService;
import com.busticketbooking.service.impl.BookingBusServiceImpl;
import com.busticketbooking.service.impl.BusServiceImpl;
import com.busticketbooking.service.impl.UserServiceImpl;

/**
 * Servlet implementation class ViewAllBookings
 */
public class ViewAllBookings extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BookingBusService bookBus = new BookingBusServiceImpl();
	BusService busService = new BusServiceImpl();
    UserService userService = new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllBookings() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Booking> bookingList = bookBus.getBookingDetails();
		
		List<Bus> busList = busService.getBusDetails();
		
		List<User> userList = userService.getUserDetails();
		
		if (bookingList.size() == 0) {
			request.setAttribute("noBookingMsg", "Sorry! No Bookings are done yet.");

			RequestDispatcher dispatcher = request.getRequestDispatcher("viewallbookings.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("allBookingList", bookingList);
			request.setAttribute("busList", busList);
			request.setAttribute("userList", userList);


			RequestDispatcher dispatcher = request.getRequestDispatcher("viewallbookings.jsp");
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
