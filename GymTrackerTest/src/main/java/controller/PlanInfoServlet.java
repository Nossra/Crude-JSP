package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.hibernate.query.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.integrator.spi.Integrator;

import utilities.HibernateUtil;
import viewmodel.LoginViewModel;
import viewmodel.PlanInfoViewModel;

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
		String plan_id = request.getParameter("id");
		LoginViewModel user = (LoginViewModel) session.getAttribute("user");
		if (session != null && user != null) {
		
			List<PlanInfoViewModel> plan = user.selectPlanInfoById(plan_id);
			Map<Integer, List<PlanInfoViewModel>> day = plan.stream().collect(Collectors.groupingBy(PlanInfoViewModel::getDayNr));
			Map<String, List<PlanInfoViewModel>> exercise = plan.stream().collect(Collectors.groupingBy(PlanInfoViewModel::getExerciseName));
			
			out.println("<div class=\"row\">\r\n" + 
						"<div class=\"col-6 offset-3\">");
			
			int index = 0;
			for(Entry<Integer, List<PlanInfoViewModel>> e : day.entrySet()) { 
				out.println("<div class=\"jumbotron\">");
				out.println("<p class=\"display-3\" style=\"2.5rem\">Day " + e.getValue().get(0).getDayNr() + "</p>");
				index++;
				for (Entry<String, List<PlanInfoViewModel>> en : exercise.entrySet()) {
					if (en.getValue().get(0).getDayNr() == index) {
						out.println("<p class=\"lead\">");
						out.println("<h4>" + en.getValue().get(0).getExerciseName()+ "</h4></p>");
						out.println("<hr class=\"my-4\">\r\n");
						if (en.getValue().get(0).getDayNr() == index) {
							for(int i = 0; i < en.getValue().size(); i++) {
								out.println("<p>" + en.getValue().get(i).getWeight() + " kg, x " + en.getValue().get(i).getRepetitions() + "</p>");
							}
						}	
					}
				}
				out.println("</div>");
			}	
			
			out.println("</div>"
					  + "</div>");
		} else {
			String url = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/login";
			response.sendRedirect(url); 
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
