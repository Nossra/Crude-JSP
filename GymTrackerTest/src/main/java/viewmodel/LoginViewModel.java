package viewmodel;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entities.Day;
import entities.Exercise;
import entities.Plan;
import entities.SetInfo;
import utilities.HibernateUtil;

public class LoginViewModel {
	private String username;
	private String name;
	
	public LoginViewModel() {
		
	}
	
	public LoginViewModel(String username, String name) {
		this.setUsername(username);
		this.setName(name);
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
//	!! IMPORTANT !!
//	REFACTOR THIS TO USE NAMED PARAMETER INSTEAD
	public List<PlanInfoViewModel> selectPlanInfoById(String Id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		int id = Integer.parseInt(Id);
		
		String HQL_SELECT_FULL_PLAN = 
				  "SELECT new viewmodel.PlanInfoViewModel(p.name, p.id, d.dayNr, e.name, si.weight, si.repetitions, p.timesPerWeek) "
				+ "FROM Day d, SetInfo si, DAY_EXERCISES de, Exercise e, Plan p, User u "
				+ "WHERE de.day=d.id AND e.id=de.exercises AND si.id=de.sets AND p.id=d.plan AND u.id=p.users "
				+ "AND u.username = '" + this.getUsername() + "'"
				+ "AND p.id = :planId" ;
		
		Query q = session.createQuery(HQL_SELECT_FULL_PLAN);
		q.setParameter("planId", id);
		
		return q.getResultList();
	}
	
//	NOTE:
//	Is currently needed but are in actuality unnecessary since the data can
//	be drawn from the selectPlanInfoById method Refactor later
	public List<String> selectPlanNames() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		final String HQL_PLAN_NAMES = 
				"SELECT p.name FROM Plan p " + 
				"WHERE p.users = (SELECT id FROM User WHERE username = '" + this.getUsername() + "')";
		
		@SuppressWarnings("unchecked")
		List<String> result = session.createQuery(HQL_PLAN_NAMES).getResultList();
		return result;
	}
}
