package main;

import org.hibernate.Session;

import entities.Exercise;
import entities.Exercise.Muscle;
import entities.User;
import entities.DAY_EXERCISES;
import entities.Day;
import entities.Plan;
import entities.SetInfo;
import utilities.HibernateUtil;

public class App {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		
		
		Exercise e = new Exercise("Hantel Curl", Muscle.BICEPS, "Bicepsövning där man lyfter hantlar");
		Exercise e1 = new Exercise("Bänkpress", Muscle.BRÖST, "Bröstövning");
		Exercise e2 = new Exercise("Skivstångs rodd", Muscle.BRÖST, "Bröstövning stående");
		Exercise e3 = new Exercise("Knäböj", Muscle.LÅR, "Tung basövning för ben som träffar större delar utav kroppen");
		Exercise e4 = new Exercise("Plankan", Muscle.MAGE, "Magövning för statisk träning");
		
		User martin = new User("Martin", "Nosslin", "1234");
		
		Plan p = new Plan("Bröst/Biceps", 3, martin);
		
		Day d1 = new Day(1);
		
		SetInfo e1s1 = new SetInfo(30.5, 12);
		SetInfo e1s2 = new SetInfo(28, 10);
		SetInfo e1s3 = new SetInfo(26, 8);
		
		DAY_EXERCISES d1e1s1 = new DAY_EXERCISES(d1, e, e1s1);
		DAY_EXERCISES d1e1s2 = new DAY_EXERCISES(d1, e, e1s2);
		DAY_EXERCISES d1e1s3 = new DAY_EXERCISES(d1, e, e1s3);
		
		SetInfo e2s1 = new SetInfo(60, 12);
		SetInfo e2s2 = new SetInfo(60, 10);
		SetInfo e2s3 = new SetInfo(60, 8);
		
		DAY_EXERCISES d1e2s1 = new DAY_EXERCISES(d1, e1, e2s1);
		DAY_EXERCISES d1e2s2 = new DAY_EXERCISES(d1, e1, e2s2);
		DAY_EXERCISES d1e2s3 = new DAY_EXERCISES(d1, e1, e2s3);

		
		//Exercises
		session.beginTransaction();
		session.save(e);
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(e4);
		
		//user
		session.save(martin);
		session.getTransaction().commit();
		
		//workoutplan
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		
		p.getDays().add(d1);
		session.beginTransaction();
		session.save(d1);
		session.getTransaction().commit();
		
		//sets
		session.beginTransaction();
		session.save(e1s1);
		session.save(e1s2);
		session.save(e1s3);
		session.save(e2s1);
		session.save(e2s2);
		session.save(e2s3);
		session.getTransaction().commit();
		
		//day_exercises
		session.beginTransaction();
		session.save(d1e1s1);
		session.save(d1e1s2);
		session.save(d1e1s3);
		session.save(d1e2s1);
		session.save(d1e2s2);
		session.save(d1e2s3);
		session.getTransaction().commit();
		
		session.close();
		System.out.println("finished");
		
		
	}

}
