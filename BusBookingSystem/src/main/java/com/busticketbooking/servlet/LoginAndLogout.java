package com.busticketbooking.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.busticketbooking.bean.User;
import com.busticketbooking.service.UserService;
import com.busticketbooking.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginAndLogout
 */
public class LoginAndLogout extends HttpServlet {
	UserService userService = new UserServiceImpl();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginAndLogout() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		session.invalidate();
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User user = userService.checkLoginDetails(email, password);

		if (null != user.getEmailId() && null != user.getPassword() && user.getStatus() == 1) {

			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("userObject", user);
			RequestDispatcher dispacher = request.getRequestDispatcher("index.jsp");
			dispacher.forward(request, response);
		} else {
			request.setAttribute("message", "Please Enter valid Email or Password");
			RequestDispatcher dispacher = request.getRequestDispatcher("login.jsp");
			dispacher.forward(request, response);
		}
	}
}