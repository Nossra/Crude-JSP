package main;

import org.hibernate.Session;

import entities.Exercise;
import entities.Exercise.Muscle;
import entities.Plan;
import entities.User;
import utilities.EntityUtil;
import utilities.HibernateUtil;
import viewmodel.LoginViewModel;

public class App {

	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		final String HQL_USER = "FROM User u WHERE u.id = :id";
		@SuppressWarnings("unchecked")
		User result = (User) s.createQuery(HQL_USER)
				.setParameter("id", 1)
				.getSingleResult();
		System.out.println(result);
		
		
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		
//		Exercise e = new Exercise("Hantel Curl", Muscle.BICEPS, "Bicepsövning där man lyfter hantlar");
//		Exercise e1 = new Exercise("Bänkpress", Muscle.BRÖST, "Bröstövning");
//		Exercise e2 = new Exercise("Skivstångs rodd", Muscle.RYGG, "Bröstövning stående");
//		Exercise e3 = new Exercise("Knäböj", Muscle.LÅR, "Tung basövning för ben som träffar större delar utav kroppen");
//		Exercise e4 = new Exercise("Plankan", Muscle.MAGE, "Magövning för statisk träning");
//		
//		User martin = new User("Martin", "Nosslin", "1234");
//		Plan p1 = new Plan("Get ripped", 3, martin);
//		Plan p2 = new Plan("Get swole", 2, martin);
//		
//		EntityUtil.saveAll(e, e1, e2, e3, e4);
//		EntityUtil.save(martin);
//		EntityUtil.saveAll(p1, p2);
////		
//		p1.addExercise(Exercise.selectAll().get(2), 3, 80, 5);
//		
//		p1.addExercise(Exercise.selectAll().get(2), 3, 80, 4);
//		p1.addExercise(Exercise.selectAll().get(2), 3, 75, 5);
//		
//		p1.addExercise(Exercise.selectAll().get(3), 3, 100, 5);
//		p1.addExercise(Exercise.selectAll().get(3), 3, 100, 4);
//		p1.addExercise(Exercise.selectAll().get(3), 3, 95, 5);
//		
//		p1.addExercise(Exercise.selectAll().get(4), 3, 10, 6);
//		p1.addExercise(Exercise.selectAll().get(4), 3, 10, 5);
//		p1.addExercise(Exercise.selectAll().get(4), 3, 10, 4);
		
//		p1.addExercise(Exercise.selectAll().get(0), 2, 26, 7);
//		p1.addExercise(Exercise.selectAll().get(0), 2, 26, 6);
//		p1.addExercise(Exercise.selectAll().get(0), 2, 24, 5);
//		
//		p2.addExercise(Exercise.selectAll().get(1), 1, 110, 6);
//		p2.addExercise(Exercise.selectAll().get(1), 1, 110, 5);
//		p2.addExercise(Exercise.selectAll().get(1), 1, 105, 4);
//		p2.addExercise(Exercise.selectAll().get(1), 1, 100, 5);
//		
//		p2.addExercise(Exercise.selectAll().get(0), 1, 26, 7);
//		p2.addExercise(Exercise.selectAll().get(0), 1, 26, 6);
//		p2.addExercise(Exercise.selectAll().get(0), 1, 24, 5);
//		
//		p2.addExercise(Exercise.selectAll().get(2), 2, 67, 6);
//		p2.addExercise(Exercise.selectAll().get(2), 2, 67, 5);
//		p2.addExercise(Exercise.selectAll().get(2), 2, 67, 4);
//		
//		p2.addExercise(Exercise.selectAll().get(3), 2, 30, 7);
//		p2.addExercise(Exercise.selectAll().get(3), 2, 35, 6);
//		p2.addExercise(Exercise.selectAll().get(3), 2, 40, 5);
////		
////		System.out.println("Plan 1 full info");
////		p1.selectFullPlanInfo();
////		System.out.println("\n\n\n");
////		System.out.println("Plan 2 full info");
////		p2.selectFullPlanInfo();
////		System.out.println("\n\n\n");
////		System.out.println("Plan 1 day 1");
////		p1.selectDayInfo(1);
////		System.out.println("\n\n\nPlan 2 day 2");
////		p2.selectDayInfo(2);
////		p2.selectFullPlanInfo();
//		

//		
//		session.close();
//		System.out.println("\nfinished");
	}
}
