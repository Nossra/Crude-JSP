package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.User;
import services.LoginService;
import viewmodel.LoginViewModel;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({ "/", "/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.getRequestDispatcher("login.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		LoginService loginService = new LoginService();
		try {
			if (loginService.login(username, password) == true) {				
				LoginViewModel user = loginService.getDetails(username);
				request.getSession().setAttribute("user", user);
				response.sendRedirect("profile");
			} else {
				response.sendRedirect("login");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
