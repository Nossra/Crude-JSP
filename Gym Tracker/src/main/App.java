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
		
		Exercise e = new Exercise("Hantel Curl", Muscle.BICEPS, "Biceps�vning d�r man lyfter hantlar");
		Exercise e1 = new Exercise("B�nkpress", Muscle.BR�ST, "Br�st�vning");
		Exercise e2 = new Exercise("Skivst�ngs rodd", Muscle.BR�ST, "Br�st�vning st�ende");
		Exercise e3 = new Exercise("Kn�b�j", Muscle.L�R, "Tung bas�vning f�r ben som tr�ffar st�rre delar utav kroppen");
		Exercise e4 = new Exercise("Plankan", Muscle.MAGE, "Mag�vning f�r statisk tr�ning");
		
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
