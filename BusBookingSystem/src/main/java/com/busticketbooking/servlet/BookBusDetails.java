package com.busticketbooking.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
import com.busticketbooking.service.UserService;
import com.busticketbooking.service.impl.BookingBusServiceImpl;
import com.busticketbooking.service.impl.BusServiceImpl;
import com.busticketbooking.service.impl.UserServiceImpl;

/**
 * Servlet implementation class BookBusDetails
 */
public class BookBusDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BookingBusService bookingBusService = new BookingBusServiceImpl();
	BusService busService = new BusServiceImpl();
	UserService userService = new UserServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookBusDetails() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Servlet Called.");

		HttpSession httpSession = request.getSession(false);
		User user = (User) httpSession.getAttribute("userObject");

		int userId = user.getUserId();

		String id = request.getParameter("id");

		int busId = Integer.parseInt(id);

		String seat = request.getParameter("seats");

		int seats = Integer.parseInt(seat);

		String updateSeatMsg = busService.setAvailableSeats(busId, seats);

		Bus bus = busService.getBusDetails(busId);

		int cost = seats * bus.getPrice();

		Booking booking = new Booking();

		booking.setBusId(busId);
		booking.setUserId(userId);
		booking.setSeats(seats);
		booking.setCost(cost);

		LocalDate dateObj = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String date = dateObj.format(formatter);
		
		System.out.println("Current Date : " + date);

		booking.setBookingDate(date);
		
		System.out.println(booking.getBookingDate());

		String result = bookingBusService.addBookingDetails(booking);

		request.setAttribute("bus", bus);
		request.setAttribute("user", user);
		request.setAttribute("booking", booking);

		RequestDispatcher dispatcher = request.getRequestDispatcher("viewbusticket.jsp");
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
