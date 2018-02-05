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
	
	public String selectFullPlanInfo() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String HQL_SELECT_FULL_PLAN = "SELECT new viewmodel.PlanInfoViewModel(p.name, d.dayNr, e.name, si.weight, si.repetitions) "
				+"FROM Day d, SetInfo si, DAY_EXERCISES de, Exercise e, Plan p, User u "
				+"WHERE de.day=d.id AND e.id=de.exercises AND si.id=de.sets AND p.id=d.plan AND u.id=p.users AND u.username = '" + this.getUsername() + "'";	
		
		@SuppressWarnings("unchecked")
		List<PlanInfoViewModel> result = (List<PlanInfoViewModel>) session.createQuery(HQL_SELECT_FULL_PLAN).list();
		String resultString = "";
		for (int i = 0; i < result.size(); i++) {
			PlanInfoViewModel vm = result.get(i);
			Plan p = new Plan(vm.getPlanName());
			Day d = new Day(vm.getDayNr());
			Exercise e = new Exercise(vm.getExerciseName());
			SetInfo siWeight = new SetInfo(vm.getWeight(), vm.getRepetitions());
			
			if (result.size() == 0) {
				resultString = "No plans found.";
			} else {
				resultString += p.getName() + " " + d.getDayNr() + " " + e.getName() + " " + siWeight.getWeight() + " " + siWeight.getRepetitions() + "\n";
			}
		}
		return resultString;
	}

	public void selectDayInfo(int day) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String HQL_DAY_INFO = "SELECT new viewmodel.PlanInfoViewModel(p.name, d.dayNr, e.name, si.weight, si.repetitions) "
					+"FROM Day d, SetInfo si, DAY_EXERCISES de, Exercise e, Plan p,"
					+"WHERE de.day=d.id AND e.id=de.exercises AND si.id=de.sets AND p.id=d.plan AND d.dayNr = :dayNr AND p.name = '" + this.getName() + "'";
		
		@SuppressWarnings("unchecked")
		List<PlanInfoViewModel> result = (List<PlanInfoViewModel>) session.createQuery(HQL_DAY_INFO)
				.setParameter("dayNr", day)
				.list();		
		
		for (int i = 0; i < result.size(); i++) {
			PlanInfoViewModel vm = result.get(i);
			Plan p = new Plan(vm.getPlanName());
			Day d = new Day(vm.getDayNr());
			Exercise e = new Exercise(vm.getExerciseName());
			SetInfo siWeight = new SetInfo(vm.getWeight(), vm.getRepetitions());
			
			if (result.size() == 0) {
				System.out.println("Plan is empty.");
			} else {
				System.out.println(p.getName() + " " + d.getDayNr() + " " + e.getName() + " " + siWeight.getWeight() + " " + siWeight.getRepetitions());
			}
		}
		session.close();
	}
	
//	public List<PlanInfoViewModel> amountOfPlans() {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		
//		final String HQL_PLAN_AMOUNT = "SELECT p.id FROM Plan p WHERE p.users = (SELECT id FROM User WHERE username = '" + this.getUsername() + "')";
//		
//		@SuppressWarnings("unchecked")
//		List<PlanInfoViewModel> result = session.createQuery(HQL_PLAN_AMOUNT).getResultList();
//		return result;
//	}
	
	public List<PlanInfoViewModel> selectPlanInfoById(String Id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		int id = Integer.parseInt(Id);
		String HQL_SELECT_FULL_PLAN = "SELECT new viewmodel.PlanInfoViewModel(p.name, p.id, d.dayNr, e.name, si.weight, si.repetitions) "
				+"FROM Day d, SetInfo si, DAY_EXERCISES de, Exercise e, Plan p, User u "
				+"WHERE p.id =:planId AND de.day=d.id AND e.id=de.exercises AND si.id=de.sets AND p.id=d.plan AND u.id=p.users AND u.username = '" + this.getUsername() + "'";	
		Query q = session.createQuery(HQL_SELECT_FULL_PLAN);
		q.setParameter("planId", id);
		
		return q.getResultList();
	}
	
	public List<String> selectPlanNames() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		final String HQL_PLAN_NAMES = "SELECT p.name FROM Plan p WHERE p.users = (SELECT id FROM User WHERE username = '" + this.getUsername() + "')";
		
		@SuppressWarnings("unchecked")
		List<String> result = session.createQuery(HQL_PLAN_NAMES).getResultList();
		return result;
	}
	
	public int selectTimesPerWeekById(String Id) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		int id = Integer.parseInt(Id);
		String HQL = "SELECT timesPerWeek FROM Plan WHERE id=:id";
		Query timesPerWeek = s.createQuery(HQL);
		timesPerWeek.setParameter("id", id);
		
		return (Integer) timesPerWeek.getSingleResult();
	}
}
