package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import viewmodel.LoginViewModel;


@WebServlet("/newday")
public class NewDayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		LoginViewModel user = (LoginViewModel) session.getAttribute("user");	
		if (session != null && session.getAttribute("user") != null) {
					
			request.getRequestDispatcher("newday.jsp").include(request, response);
			
			
		} else {
			response.sendRedirect("login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
