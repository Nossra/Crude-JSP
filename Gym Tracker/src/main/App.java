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
		Exercise e2 = new Exercise("Skivstångs rodd", Muscle.RYGG, "Bröstövning stående");
		Exercise e3 = new Exercise("Knäböj", Muscle.LÅR, "Tung basövning för ben som träffar större delar utav kroppen");
		Exercise e4 = new Exercise("Plankan", Muscle.MAGE, "Magövning för statisk träning");
		
		User martin = new User("Martin", "Nosslin", "1234");
		
		Plan p = new Plan("Get ripped", 3, martin);
		
		Day d1 = new Day(1, "Bröst/Biceps");
		
		SetInfo s1d1e1 = new SetInfo(30.5, 12);
		SetInfo s2d1e1 = new SetInfo(28, 10);
		SetInfo s3d1e1 = new SetInfo(26, 8);
		
		DAY_EXERCISES d1e1s1 = new DAY_EXERCISES(d1, e, s1d1e1);
		DAY_EXERCISES d1e1s2 = new DAY_EXERCISES(d1, e, s2d1e1);
		DAY_EXERCISES d1e1s3 = new DAY_EXERCISES(d1, e, s3d1e1);
		
		SetInfo s1d1e2 = new SetInfo(60, 12);
		SetInfo s2d1e2 = new SetInfo(60, 10);
		SetInfo s3d1e2 = new SetInfo(60, 8);
		
		DAY_EXERCISES d1e2s1 = new DAY_EXERCISES(d1, e1, s1d1e2);
		DAY_EXERCISES d1e2s2 = new DAY_EXERCISES(d1, e1, s2d1e2);
		DAY_EXERCISES d1e2s3 = new DAY_EXERCISES(d1, e1, s2d1e2);
		
		
		Day d2 = new Day(2, "Rygg/Lår");
		
		SetInfo s1d2e1 = new SetInfo(60.5, 12);
		SetInfo s2d2e1 = new SetInfo(55, 10);
		SetInfo s3d2e1 = new SetInfo(50, 8);
		
		DAY_EXERCISES d2e1s1 = new DAY_EXERCISES(d2, e2, s1d2e1);
		DAY_EXERCISES d2e1s2 = new DAY_EXERCISES(d2, e2, s2d2e1);
		DAY_EXERCISES d2e1s3 = new DAY_EXERCISES(d2, e2, s3d2e1);
		
		SetInfo s1d2e2 = new SetInfo(60, 12);
		SetInfo s2d2e2 = new SetInfo(60, 10);
		SetInfo s3d2e2 = new SetInfo(60, 8);
		
		DAY_EXERCISES d2e2s1 = new DAY_EXERCISES(d2, e3, s1d2e2);
		DAY_EXERCISES d2e2s2 = new DAY_EXERCISES(d2, e3, s2d2e2);
		DAY_EXERCISES d2e2s3 = new DAY_EXERCISES(d2, e3, s2d2e2);

		
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
		
		//days
		p.getDays().add(d1);
		p.getDays().add(d2);
		session.beginTransaction();
		session.save(d1);
		session.save(d2);
		session.getTransaction().commit();
		
		//sets
		session.beginTransaction();
		session.save(s1d1e1);
		session.save(s2d1e1);
		session.save(s3d1e1);
		
		session.save(s1d1e2);
		session.save(s2d1e2);
		session.save(s3d1e2);
		
		session.save(s1d2e1);
		session.save(s2d2e1);
		session.save(s3d2e1);
		
		session.save(s1d2e2);
		session.save(s2d2e2);
		session.save(s3d2e2);
		session.getTransaction().commit();
		
		//day_exercises
		session.beginTransaction();
		session.save(d1e1s1);
		session.save(d1e1s2);
		session.save(d1e1s3);
		session.save(d1e2s1);
		session.save(d1e2s2);
		session.save(d1e2s3);

		session.save(d2e1s1);
		session.save(d2e1s2);
		session.save(d2e1s3);
		session.save(d2e2s1);
		session.save(d2e2s2);
		session.save(d2e2s3);
		session.getTransaction().commit();
		
		session.close();
		System.out.println("finished");
		
		
	}

}
