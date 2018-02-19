package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import entities.Exercise;
import entities.Plan;
import services.LoginService;
import utilities.HibernateUtil;
import viewmodel.LoginViewModel;
import viewmodel.PlanInfoViewModel;

/**
 * Servlet implementation class ViewPlansServlet
 */
@WebServlet("/viewplans")
public class ViewPlansServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("user") != null) {
			request.getRequestDispatcher("viewplans.jsp").include(request, response);
			LoginViewModel user = (LoginViewModel) session.getAttribute("user"); 
			PrintWriter out = response.getWriter();	
			
			List<Plan> plans = user.selectPlanNames(user.getId());

			out.println("<div class=\"row\">");
			out.print("<div class=\"col-12\">");
			for (int i = 0; i < plans.size(); i++) {	

				out.println(
					"<div class=\"card text-white bg-secondary mb-3\" style=\"margin:5% !important\">"
				    	+"<div class=\"card-header\">Plan "+ (i+1) +"</div>"
				    	+"<div class=\"card-body\">" 
					    	+"<h4 class=\"card-title\">" + plans.get(i).getName() + "</h4>"
					    	+"<p class=\"card-text\">Method here that shows the hit muscles.</p>"
					    	+ "<a href=\"planinfo?id="+ plans.get(i).getId() +"\"><button type=\"button\" class=\"btn btn-primary\">Edit plan</button></a>"
				    	+"</div>"
			    	+"</div>"
				);	
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
