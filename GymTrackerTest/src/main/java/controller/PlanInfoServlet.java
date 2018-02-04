package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import viewmodel.LoginViewModel;

/**
 * Servlet implementation class PlanInfoServlet
 */

@WebServlet("/planinfo")
public class PlanInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session = request.getSession(true);
		request.getRequestDispatcher("planinfo.jsp").include(request, response);
		PrintWriter out = response.getWriter();	
		
		if (session != null) {
			LoginViewModel user = (LoginViewModel) session.getAttribute("user"); 
//			int planindex = (Integer) session.getAttribute("planindex");
//			for (int i = 0; i < user.selectPlanNames().size(); i++) {
//				out.println(
//						
//				);
//			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
