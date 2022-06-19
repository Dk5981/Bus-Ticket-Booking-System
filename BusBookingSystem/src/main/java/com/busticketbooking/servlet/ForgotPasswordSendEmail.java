package com.busticketbooking.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.busticketbooking.service.UserService;
import com.busticketbooking.service.impl.UserServiceImpl;
import com.busticketbooking.util.EmailThread;

/**
 * Servlet implementation class ForgotPasswordSendEmail
 */
public class ForgotPasswordSendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgotPasswordSendEmail() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");

		String password = userService.fetchPassword(email);

		String message = "<center><h1 style='color:darkblue;font-family:apple;font-style:italic;font-size: 40px;'>Welcome to </h1><h2 style='color:darkblue;font-family:apple;font-style:italic;font-size: 30px;'>Bus Ticket Booking System</h2></center>"
				+ "<h2 style='color:darkblue;font-family:apple;font-style:italic;font-size: 20px;'>" + "Dear, "
				+ "Hello...." + "</h2><hr><br>"
				+ "<br><br><hr><center>***********Password is Given Below***********</center><hr><br>" + "<br>"
				+ "Your Password is....          : <h2> " + password + "</h2><br>"
				+ "<br><h2 style='color:darkblue;font-family:apple;font-style:italic;font-size: 20px;'>"
				+ "Thank You....." + "</h2>";

		EmailThread thread = new EmailThread();

		thread.send(email, message);

		Thread t1 = new Thread(thread);

		t1.start();

		String emailMsg = "We have sent an email with your password to you.";

		request.setAttribute("emailMsg", emailMsg);
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
