package entities;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import utilities.EntityUtil;
import utilities.HibernateUtil;

@Entity
public class Plan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int timesPerWeek;
	@ManyToOne
	@JoinColumn(name="user_id")	
	private User users;	
	@OneToMany
	@JoinColumn(name = "plan_id")
	private List<Day> days = new ArrayList<Day>();
	
	public Plan() {
		
	}
	
	public Plan(String name, int timesPerWeek, User user) {
		this.setName(name);
		this.setTimesPerWeek(timesPerWeek);
		this.setUsers(user);
		for (int i = 0; i < timesPerWeek; i++) {
			days.add(new Day(i+1));
			EntityUtil.save(days.get(i));
		}			
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTimesPerWeek() {
		return timesPerWeek;
	}
	public void setTimesPerWeek(int timesPerWeek) {
		this.timesPerWeek = timesPerWeek;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public List<Day> getDays() {
		return days;
	}

	public void setDays(List<Day> days) {
		this.days = days;
	}
	
	//DONT USE YET, DEVELOP FURTHER AFTER JSP IS IN
//	public void createPlan(String name, int timesPerWeek, User user) {
//		Plan p = new Plan(name, timesPerWeek, user);
//		for (int i = 0; i < p.getDays().size(); i++) {
//			p.getDays().get(i).setNrOfDays(i+1);
//		}
//	}
	
	public void addExercise(Exercise exercise, int dayNr, double weight, int repetitions) {
		SetInfo sets = new SetInfo(weight, repetitions);
		EntityUtil.save(sets);
		DAY_EXERCISES de = new DAY_EXERCISES(days.get(dayNr-1), exercise, sets);		
		EntityUtil.save(de);		
	}
	
	public static void selectPlanInfo() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		 CriteriaBuilder cb = session.getCriteriaBuilder();

		  CriteriaQuery<Plan> q = cb.createQuery(Plan.class);
		  Root<Plan> c = q.from(Plan.class);
		  ParameterExpression<Integer> p = cb.parameter(Integer.class);
		  q.select(c).where(cb.gt(c.get("timesPerWeek"), p));
		  
		  TypedQuery<Plan> query = session.createQuery(q);
		  query.setParameter(p, 1);
		  List<Plan> results = query.getResultList();
		session.close();
		
		for (Plan plan : results) {
			System.out.println(plan.getName());
		}
	}
}
