package entities;
import java.lang.reflect.Field;
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
import javax.security.auth.login.CredentialExpiredException;

import org.hibernate.Session;
import org.hibernate.query.Query;

import utilities.EntityUtil;
import utilities.HibernateUtil;
import viewmodel.PlanInfoViewModel;

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
	public Plan(String name) {
		this.name = name;
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
	
	public void addExercise(Exercise exercise, int dayNr, double weight, int repetitions) {
		SetInfo sets = new SetInfo(weight, repetitions);
		EntityUtil.save(sets);
		DAY_EXERCISES de = new DAY_EXERCISES(days.get(dayNr-1), exercise, sets);		
		EntityUtil.save(de);
		
	}
	
	public void selectFullPlanInfo() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT new viewmodel.PlanInfoViewModel(p.name, d.dayNr, e.name, si.weight, si.repetitions) "
					+"FROM Day d, SetInfo si, DAY_EXERCISES de, Exercise e, Plan p "
					+"WHERE de.day=d.id AND e.id=de.exercises AND si.id=de.sets AND p.name = '" + this.getName() + "'";
		@SuppressWarnings("unchecked")
		List<PlanInfoViewModel> result = (List<PlanInfoViewModel>) session.createQuery(hql).list();

		for (int i = 0; i < result.size(); i++) {
			PlanInfoViewModel vm = result.get(i);
			Plan p = new Plan(vm.getPlanName());
			Day d = new Day(vm.getDayNr());
			Exercise e = new Exercise(vm.getExerciseName());
			SetInfo siWeight = new SetInfo(vm.getWeight(), vm.getRepetitions());
			
			System.out.println(p.getName() + " " + d.getDayNr() + " " + e.getName() + " " + siWeight.getWeight() + " " + siWeight.getRepetitions());
		}
		session.close();
	}
	
	public void selectPlanDayInfo(int day) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT new viewmodel.PlanInfoViewModel(p.name, d.dayNr, e.name, si.weight, si.repetitions) "
					+"FROM Day d, SetInfo si, DAY_EXERCISES de, Exercise e, Plan p "
					+"WHERE de.day=d.id AND e.id=de.exercises AND si.id=de.sets AND d.dayNr = :dayNr AND p.name = '" + this.getName() + "'";
		@SuppressWarnings("unchecked")
		List<PlanInfoViewModel> result = (List<PlanInfoViewModel>) session.createQuery(hql)
				.setParameter("dayNr", day)
				.list();		
		
		for (int i = 0; i < result.size(); i++) {
			PlanInfoViewModel vm = result.get(i);
			Plan p = new Plan(vm.getPlanName());
			Day d = new Day(vm.getDayNr());
			Exercise e = new Exercise(vm.getExerciseName());
			SetInfo siWeight = new SetInfo(vm.getWeight(), vm.getRepetitions());
			
			System.out.println(p.getName() + " " + d.getDayNr() + " " + e.getName() + " " + siWeight.getWeight() + " " + siWeight.getRepetitions());
		}
		session.close();
	}
}
