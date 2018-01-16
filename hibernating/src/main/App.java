package main;

import org.hibernate.Session;

import entities.Exercise;
import entities.Exercise.Muscle;
import utilities.HibernateUtil;

public class App {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		Exercise e = new Exercise("Hantel Curl", Muscle.BICEPS, "Bicepsövning där man lyfter hantlar");
		session.save(e);
		session.getTransaction().commit();
		
		session.close();
		
		System.out.println(e.getMuscle());
		
		
		
	}

}
