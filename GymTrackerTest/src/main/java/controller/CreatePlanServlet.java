package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Plan;
import utilities.EntityUtil;
import viewmodel.LoginViewModel;

/**
 * Servlet implementation class CreatePlanServlet
 */
@WebServlet("/createplan")
public class CreatePlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginViewModel user;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session = request.getSession(true);
		
		
		if (session != null) {
			user = (LoginViewModel) session.getAttribute("user"); 
			
		} else {
			response.sendRedirect("login");
		}
		request.getRequestDispatcher("createplan.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String planName = request.getParameter("planName");
		int amountOfDays = Integer.parseInt(request.getParameter("amountOfDays"));
//		Plan p = new Plan(planName, amountOfDays, user);
//		EntityUtil.save(p);
		
	}

}
