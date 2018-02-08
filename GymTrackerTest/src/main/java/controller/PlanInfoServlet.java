package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
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
			
			int j = 0;
			out.println("<div class=\"row\">\r\n" + 
						"<div class=\"col-3 offset-1\" style=\"margin-left:4.3333% !important;\">" +
							"<nav id=\"navbar-example3\" class=\"navbar navbar-light bg-light\" style=\"position:fixed !important; width:20% !important;\">" + 
								"<nav class=\"nav nav-pills flex-column\">");
							for (Entry<Integer, List<PlanInfoViewModel>> e : day.entrySet()) {
								String newUrl = "#item-"+ j;
								out.println("<a class=\"nav-link\" href=\"" + newUrl + "\">Day " + e.getValue().get(0).getDayNr() + "</a>");
								j++;
							}
					out.println("</nav>" + 
							"</nav>" +
						"</div>" +
						
						"<div class=\"col-8\">");
			int k = 0;
			for(Entry<Integer, List<PlanInfoViewModel>> e : day.entrySet()) { 
				out.println("<div data-spy=\"scroll\" data-target=\"#navbar-example3\" data-offset=\"0\">");
				out.println("<div class=\"jumbotron\">");
				out.println("<p style=\"font-size: 2rem !important;\" id=\"item-"+ k +"\">Day " + e.getValue().get(0).getDayNr() + "</p>");
				k++;
				
				Map<String, List<PlanInfoViewModel>> exercise = e.getValue().stream().collect(Collectors.groupingBy(PlanInfoViewModel::getExerciseName));
				for (Entry<String, List<PlanInfoViewModel>> en : exercise.entrySet()) {
						out.print("<p class=\"lead\">");
						out.print("<h4>" + en.getValue().get(0).getExerciseName()+ "</h4>");
						out.println("<div class=\"form-group\">\r\n" + 
								"		<fieldset>\r\n"); 
						en.getValue().forEach(x -> {  
							out.println("<input class=\"form-control\" style=\"float: left; width:37%;\" id=\"readOnlyInput\" type=\"text\" placeholder=\""+ x.getWeight() + " kg, x " + x.getRepetitions()+"\" readonly=\"\">\r\n");
						});
						out.println("</fieldset>\r\n" + 
								"   </div>" +
								"</p>");
				}
				out.println("</div>");
			}	
			out.println("</div>"
					+ "</div>"
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
