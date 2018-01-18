package main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import entities.Exercise;
import entities.Exercise.Muscle;
import entities.User;
import entities.DAY_EXERCISES;
import entities.Day;
import entities.Plan;
import entities.SetInfo;
import utilities.EntityUtil;
import utilities.HibernateUtil;

public class App {

	public static void main(String[] args) {
		
		Exercise e = new Exercise("Hantel Curl", Muscle.BICEPS, "Bicepsövning där man lyfter hantlar");
		Exercise e1 = new Exercise("Bänkpress", Muscle.BRÖST, "Bröstövning");
		Exercise e2 = new Exercise("Skivstångs rodd", Muscle.RYGG, "Bröstövning stående");
		Exercise e3 = new Exercise("Knäböj", Muscle.LÅR, "Tung basövning för ben som träffar större delar utav kroppen");
		Exercise e4 = new Exercise("Plankan", Muscle.MAGE, "Magövning för statisk träning");
		
		User martin = new User("Martin", "Nosslin", "1234");
		
		Plan p = new Plan("Get ripped", 3, martin);
		
		EntityUtil.saveAll(e, e1, e2, e3, e4);
		
		//user
		EntityUtil.save(martin);

		//workoutplan
		EntityUtil.save(p);
		
		//Add exercises with one set per row into a plan
		p.addExercise(e, 1, 25, 6);
		p.addExercise(e, 1, 22, 6);
		p.addExercise(e, 1, 20, 6);
		
		p.addExercise(e1, 1, 70, 6);
		p.addExercise(e1, 1, 70, 5);
		p.addExercise(e1, 1, 65, 7);
		
		p.addExercise(e3, 1, 80, 6);
		p.addExercise(e3, 1, 80, 5);
		p.addExercise(e3, 1, 80, 4);
		
		p.addExercise(e2, 2, 60, 8);
		p.addExercise(e2, 2, 65, 7);
		p.addExercise(e2, 2, 60, 6);
		
		p.addExercise(e1, 2, 70, 6);
		p.addExercise(e1, 2, 70, 5);
		p.addExercise(e1, 2, 65, 7);
		
		p.addExercise(e3, 2, 80, 6);
		p.addExercise(e3, 2, 80, 5);
		p.addExercise(e3, 2, 80, 4);	

//		session.beginTransaction();
//		Query q = session.createQuery("FROM Day WHERE dayNr = :n");
//		q.setParameter("n", "1");
//		
//		List<Day> eList = q.getResultList();
//		
//		for (Day ea : eList) {
//			System.out.println(ea.getName());
//		}
		
//		//Deprecated criteria usage, use the new way
//		Criteria c = session.createCriteria(Exercise.class);
//		c.add(Restrictions.ilike("name", "Plankan"));
		
//		CriteriaBuilder cb = session.getCriteriaBuilder();
//		CriteriaQuery<Exercise> cq = cb.createQuery(Exercise.class);
//		Root<Exercise> root = cq.from(Exercise.class);
//		
//		cb.
//		
//		Query q = session.createQuery(cq);
//		List<Exercise> exercises = q.getResultList();
//		System.out.println(exercises);
		System.out.println("finished");
	}

}
