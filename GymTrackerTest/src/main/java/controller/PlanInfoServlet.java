package controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.query.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import utilities.HibernateUtil;
import viewmodel.LoginViewModel;

/**
 * Servlet implementation class PlanInfoServlet
 */

@WebServlet("/planinfo")
public class PlanInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session = request.getSession(false);
		request.getRequestDispatcher("planinfo.jsp").include(request, response);
		PrintWriter out = response.getWriter();	
		String id = request.getParameter("id");
		LoginViewModel user = (LoginViewModel) session.getAttribute("user"); 
		if (session != null && user != null) {
			out.println("<div class=\"row\">\r\n" + 
					"		<div class=\"col-6 offset-3\">");
		
			for (int i = 0; i < user.selectTimesPerWeekById(id); i++) {
				out.println("<button type=\"button\" class=\"btn btn-info\" data-toggle=\"collapse\" data-target=\"#demo"+(i+1)+"\">Day "+ (i+1) +"</button>\r\n" + 
						"  <div id=\"demo"+(i+1)+"\" class=\"collapse\">\r\n" + 
							"<h2>" + user.selectPlanInfoById(id).get(i).getExerciseName() + "</h2>");
							for (int j = 0; j < user.selectAmountOfSets; j++) {
								out.println("<p>" + user.selectPlanInfoById(id).get(i).getWeight() + "kg, " + 
											user.selectPlanInfoById(id).get(i).getRepetitions() + " repetitions." + "</p>" +
											"</div>");
							}
			}	
			out.println("</div>\r\n" + 
					 "</div>");
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
