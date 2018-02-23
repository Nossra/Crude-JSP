package controller;

import java.io.IOException;
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
import entities.User;
import utilities.EntityUtil;
import utilities.HibernateUtil;
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
		
		HttpSession session = request.getSession(false);
		
		
		if (session != null) {
			user = (LoginViewModel) session.getAttribute("user"); 
		} else {
			response.sendRedirect("login");
		}
		request.getRequestDispatcher("createplan.jsp").include(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String planName = request.getParameter("planName");
		System.out.println("plan name: " + planName);
		int amountOfDays = Integer.parseInt(request.getParameter("amountOfDays"));
		System.out.println("days " + amountOfDays);
		Session s = HibernateUtil.getSessionFactory().openSession();
		final String HQL_USER = "FROM User u WHERE u.id = :id";
		@SuppressWarnings("unchecked")
		User thisUser = (User) s.createQuery(HQL_USER)  
				.setParameter("id", user.getId())
				.getSingleResult();
		System.out.println("user id: " + thisUser);
		Plan p = new Plan(planName, amountOfDays, thisUser);
		EntityUtil.save(p);
		
		int exerciseId = Integer.parseInt(request.getParameter("exerciseSelectList"));
		
		final String HQL_EXERCISE = "FROM Exercise WHERE id = :id";
		Exercise e = (Exercise) s.createQuery(HQL_EXERCISE)
				.setParameter("id", exerciseId)
				.getSingleResult();
		
		System.out.println("exercise: " + e);
		int sets = Integer.parseInt(request.getParameter("sets"));
		for (int i = 0; i < sets; i++) {
			int repetitions = Integer.parseInt(request.getParameter("repetitions" + (i+1)));
			System.out.println("reps: " + repetitions);
			
			double weights = Double.parseDouble(request.getParameter("weights" + (i+1)));
			System.out.println("weights: " + weights);
			
			p.addExercise(e, 1, weights, repetitions);
		}
		
		

		


		response.sendRedirect("viewplans");
	}

}
