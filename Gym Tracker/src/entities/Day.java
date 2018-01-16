package entities;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Day {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int dayNr;
	
	@ManyToMany
	@JoinTable(
			name="EX_DAYS",
		      joinColumns=@JoinColumn(name="EX_ID", referencedColumnName="ID"),
		      inverseJoinColumns=@JoinColumn(name="DAY_ID", referencedColumnName="ID"))
	private List<Exercise> exercises;
	private int sets;
	transient private List<Double> weights;
	transient private List<Integer> repetitions;
		
	public Day() {

	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getDayNr() {
		return dayNr;
	}

	public void setDayNr(int dayNr) {
		this.dayNr = dayNr;
	}

	public List<Double> getWeights() {
		return weights;
	}

	public void setWeights(List<Double> weights) {
		this.weights = weights;
	}

	public List<Integer> getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(List<Integer> repetitions) {
		this.repetitions = repetitions;
	}

	public int getSets() {
		return sets;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}
}
