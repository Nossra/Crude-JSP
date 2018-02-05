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
				System.out.println(user.selectTimesPerWeekById(id));		
			out.println(
					"<div class=\"row\">"
					 +"<div class=\"col-2 offset-3\">"
					 +"<div class=\"list-group\" id=\"list-tab\" role=\"tablist\">"
					);
			for (int i = 0; i < user.selectTimesPerWeekById(id); i++) {
				out.println(
			 "<a class=\"list-group-item list-group-item-action\" id=\"list-profile-list\" "
			 + "data-toggle=\"list\" href=\"#list-profile\" role=\"tab\" aria-controls=\"profile\">Day " + (i+1) + "</a>");
			}
			out.println(
					  "</div>\r\n" 
					+ "</div>"
					+ "<div class=\"col-4\">\r\n"
					+ "<div class=\"tab-content\" id=\"nav-tabContent\">"
				);
			for (int i = 0; i < user.selectTimesPerWeekById(id); i++) {
				out.println("<div class=\"tab-pane fade\" id=\"list-profile\" role=\"tabpanel\" aria-labelledby=\"list-profile-list\">"
						+ "<div class=\"card text-white bg-secondary mb-3\" style=\"max-width: 20rem;\">\r\n" + 
						"						  <div class=\"card-header\">Day " + (i+1) + "</div>\r\n" + 
						"						  <div class=\"card-body\">\r\n" + 
						"						    <h4 class=\"card-title\">" + user.selectPlanInfoById(id).get(i).getExerciseName() + "</h4>\r\n" + 
						"						    <p class=\"card-text\">Repetitions: " + user.selectPlanInfoById(id).get(i).getRepetitions() + "</p>\r\n" + 
						"						  </div>\r\n" + 
						"						</div>"
						+ "</div>");
			}
			out.println("</div>" + 
					"  </div>" + 
					"</div>");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
