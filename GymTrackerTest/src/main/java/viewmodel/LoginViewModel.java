package viewmodel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entities.Day;
import entities.Exercise;
import entities.Plan;
import entities.SetInfo;
import entities.User;
import utilities.HibernateUtil;

public class LoginViewModel {
	private String username;
	private String name;
	private int id;
	
	public LoginViewModel() {
		
	}
	
	public LoginViewModel(String username, String name, int id) {
		this.setUsername(username);
		this.setName(name);
		this.setId(id);
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
	
	public List<PlanInfoViewModel> selectPlanInfoById(String Id, String username) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		int id = Integer.parseInt(Id);
		
		String HQL_SELECT_FULL_PLAN = 
				  "SELECT new viewmodel.PlanInfoViewModel(p.name, p.id, d.dayNr, e.name, si.weight, si.repetitions, p.timesPerWeek) "
				+ "FROM Day d, SetInfo si, DAY_EXERCISES de, Exercise e, Plan p, User u "
				+ "WHERE de.day=d.id AND e.id=de.exercises AND si.id=de.sets AND p.id=d.plan AND u.id=p.users "
				+ "AND u.username = :username "
				+ "AND p.id = :planId" ;
		
		Query q = session.createQuery(HQL_SELECT_FULL_PLAN);
		q.setParameter("planId", id);
		q.setParameter("username", username);
		
		return q.getResultList();
	}
	
	public List<Plan> selectPlanNames(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Plan> cq = cb.createQuery(Plan.class);
		Root<Plan> p = cq.from(Plan.class);
		cq.select(p);
		
		TypedQuery<Plan> q = session.createQuery(cq);
		List<Plan> result = q.getResultList();
		
		List<Plan> plans = new ArrayList<Plan>();
		for (int i = 0; i < result.size(); i++) {
			if (result.get(i).getUsers().getId() == id) {
				Plan plan = new Plan();
				plan.setId(result.get(i).getId());
				plan.setName(result.get(i).getName());
				plans.add(plan);
			}
		}
		
		return plans;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
