package com.busticketbooking.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.busticketbooking.bean.User;
import com.busticketbooking.service.UserService;
import com.busticketbooking.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserRegistration
 */
public class UserRegistration extends HttpServlet {
	UserService userService = new UserServiceImpl();

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegistration() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");

		int ans = userService.checkEmailExist(email);
		if (ans == 0) {
			response.getWriter().append("false");
		} else {
			response.getWriter().append("true");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String emailId = request.getParameter("email");
		String contact = request.getParameter("contact");
		String password = request.getParameter("password");

		User user = new User();

		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAddress(address);
		user.setEmailId(emailId);
		user.setContact(contact);
		user.setPassword(password);

		String msg = userService.saveUserRegistration(user);

		request.setAttribute("registrationMsg", msg);

		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}
}