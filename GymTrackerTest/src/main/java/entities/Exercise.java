package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import utilities.HibernateUtil;

@Entity
public class Exercise {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Muscle muscle;
	private String name;
	private String description;
	
	public Exercise() {
		
	}
	public Exercise(String name) {
		this.name = name;
	}
	public Exercise(String name, Muscle muscle, String description) {
		this.setName(name);
		this.setMuscle(muscle);
		this.setDescription(description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Muscle getMuscle() {
		return muscle;
	}

	public void setMuscle(Muscle muscle) {
		this.muscle = muscle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public enum Muscle {
		BRÖST,
		AXLAR,
		LÅR,
		VADER,
		BICEPS,
		TRICEPS,
		MAGE,
		RYGG
	}	
	
	public static List<Exercise> selectAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Exercise> cq = cb.createQuery(Exercise.class);
		Root<Exercise> exercise = cq.from(Exercise.class);
		cq.select(exercise);
		
		TypedQuery<Exercise> q = session.createQuery(cq);
		List<Exercise> exercises = q.getResultList();
		return exercises;
		//session.close();
		
	}
}
