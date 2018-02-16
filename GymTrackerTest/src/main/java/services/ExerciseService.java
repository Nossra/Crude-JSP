package services;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import entities.Exercise;
import utilities.HibernateUtil;

public class ExerciseService {
	public static List<Exercise> selectAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Exercise> cq = cb.createQuery(Exercise.class);
		Root<Exercise> exercise = cq.from(Exercise.class);
		cq.select(exercise);
		
		TypedQuery<Exercise> q = session.createQuery(cq);
		List<Exercise> exercises = q.getResultList();
		return exercises;
	}
}
