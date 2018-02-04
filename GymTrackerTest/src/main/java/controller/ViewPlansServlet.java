package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.LoginService;
import viewmodel.LoginViewModel;

/**
 * Servlet implementation class ViewPlansServlet
 */
@WebServlet("/viewplans")
public class ViewPlansServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session = request.getSession(true);
		request.getRequestDispatcher("viewplans.jsp").include(request, response);
		
		if (session != null) {
			LoginViewModel user = (LoginViewModel) session.getAttribute("user"); 
			PrintWriter out = response.getWriter();			
			for (int i = 0; i < user.selectPlanNames().size(); i++) {
				request.getSession().setAttribute("planindex", i);
				out.println(
					"<div class=\"card text-white bg-secondary mb-3\">"
				    	+"<div class=\"card-header\">Plan "+ (i+1) +"</div>"
				    	+"<div class=\"card-body\">"
					    	+"<h4 class=\"card-title\">" + user.selectPlanNames().get(i) + "</h4>"
					    	+"<p class=\"card-text\">Method here that shows the hit muscles.</p>"
					    	+"<a href=\"planinfo\">Plan info</a>"
				    	+"</div>"
			    	+"</div"
				);	
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
