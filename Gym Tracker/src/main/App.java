package main;

import org.hibernate.Session;

import entities.Exercise;
import entities.Exercise.Muscle;
import entities.User;
import entities.Day;
import entities.Plan;
import utilities.HibernateUtil;

public class App {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		Exercise e = new Exercise("Hantel Curl", Muscle.BICEPS, "Bicepsövning där man lyfter hantlar");
		Exercise e1 = new Exercise("Bänkpress", Muscle.BRÖST, "Bröstövning");
		Exercise e2 = new Exercise("Skivstångs rodd", Muscle.BRÖST, "Bröstövning stående");
		Exercise e3 = new Exercise("Knäböj", Muscle.LÅR, "Tung basövning för ben som träffar större delar utav kroppen");
		Exercise e4 = new Exercise("Plankan", Muscle.MAGE, "Magövning för statisk träning");
		
		User martin = new User("Martin", "Nosslin", "1234");
		
		Plan p = new Plan("Rygg/ben", 3, martin);
		
		Day d = new Day();
		
		//Exercises
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
		
		session.close();
		System.out.println("finished");
		
		
	}

}
