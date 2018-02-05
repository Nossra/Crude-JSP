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
		System.out.println(session);
		if (session != null && session.getAttribute("user") != null) {
			request.getRequestDispatcher("viewplans.jsp").include(request, response);
			LoginViewModel user = (LoginViewModel) session.getAttribute("user"); 
			PrintWriter out = response.getWriter();		
			out.println(
					"<div class=\"row\">"
						+"<div class=\"col-6 offset-3\">");
			for (int i = 0; i < user.selectPlanNames().size(); i++) {	
				
				Session s = HibernateUtil.getSessionFactory().openSession();
				
				final String HQL_PLAN_NAMES = "SELECT p.id FROM Plan p WHERE p.users = (SELECT id FROM User WHERE username = '" + user.getUsername() + "') AND p.name = '"+user.selectPlanNames().get(i)+ "'";
				
				@SuppressWarnings("unchecked")
				Object result = s.createQuery(HQL_PLAN_NAMES).getSingleResult();
						
				request.getSession().setAttribute("planindex", i);
				out.println(
					"<div class=\"card text-white bg-info mb-3\" style=\"max-width: 18rem; float: left; margin-right:1%\">"
				    	+"<div class=\"card-header\">Plan "+ (i+1) +"</div>"
				    	+"<div class=\"card-body\">" 
					    	+"<h4 class=\"card-title\">" + user.selectPlanNames().get(i) + "</h4>"
					    	+"<p class=\"card-text\">Method here that shows the hit muscles.</p>"
					    	+"<a class=\"nav-link\" href=\"planinfo?id="+result+"\">Plan info</a>"
				    	+"</div>"
			    	+"</div>"
				);	
			}
			out.println(
				"</div>"
				+"</div>"
			);
		} else {
		String url = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/login";
		response.sendRedirect(url); 
		// http:bla:23/gymtrackertest/login/something/gymtrackertest/login
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
