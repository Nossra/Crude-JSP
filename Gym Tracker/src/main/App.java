package main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
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
		Session session = HibernateUtil.getSessionFactory().openSession();
		
//		Exercise.selectAll();
		Exercise e = new Exercise("Hantel Curl", Muscle.BICEPS, "Bicepsövning där man lyfter hantlar");
		Exercise e1 = new Exercise("Bänkpress", Muscle.BRÖST, "Bröstövning");
		Exercise e2 = new Exercise("Skivstångs rodd", Muscle.RYGG, "Bröstövning stående");
		Exercise e3 = new Exercise("Knäböj", Muscle.LÅR, "Tung basövning för ben som träffar större delar utav kroppen");
		Exercise e4 = new Exercise("Plankan", Muscle.MAGE, "Magövning för statisk träning");
		
		User martin = new User("Martin", "Nosslin", "1234");
		
//		Plan p1 = new Plan("Get ripped", 3, martin);
		Plan p2 = new Plan("Get swole", 2, martin);

		EntityUtil.saveAll(e, e1, e2, e3, e4);

		EntityUtil.save(martin);

		EntityUtil.save(p2);
	
//		Add exercises with one set per row into a plan
//		p.addExercise(exercise, dayNr, weight, repetitions);
		p2.addExercise(e2, 1, 56, 5);
		p2.addExercise(e2, 1, 98, 6); 
		p2.addExercise(e2, 1, 58, 3);
		
		p2.addExercise(e3, 1, 45, 6);
		p2.addExercise(e3, 1, 78, 5);
		p2.addExercise(e3, 1, 64, 7);
		
		p2.addExercise(e1, 1, 34, 6);
		p2.addExercise(e1, 1, 45, 5);
		p2.addExercise(e1, 1, 12, 4);
		
		p2.addExercise(e4, 2, 20, 8);
		p2.addExercise(e4, 2, 50, 7);
		p2.addExercise(e4, 2, 10, 6);
		
		p2.addExercise(e1, 2, 20, 6);
		p2.addExercise(e1, 2, 67, 5);
		p2.addExercise(e1, 2, 10, 7);
		
		p2.addExercise(e2, 2, 12, 6);
		p2.addExercise(e2, 2, 30, 5);
		p2.addExercise(e2, 2, 55, 4);	
		
		session.close();
		System.out.println("\nfinished");
	}
	

}


