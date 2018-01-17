package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DAY_EXERCISES {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "day_id")
	private Day day;
	
	@ManyToOne
	@JoinColumn(name = "exercise_id")
	private Exercise exercises;
	
	@ManyToOne
	@JoinColumn(name = "set_id")
	private SetInfo sets;
	
	public DAY_EXERCISES() {
		
	}
	
	public DAY_EXERCISES(Day day, Exercise exercise, SetInfo sets) {
		this.setDay(day);
		this.setExercise(exercise);
		this.setSets(sets);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Exercise getExercise() {
		return exercises;
	}

	public void setExercise(Exercise exercise) {
		this.exercises = exercise;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public SetInfo getSets() {
		return sets;
	}

	public void setSets(SetInfo sets) {
		this.sets = sets;
	}
	
}
