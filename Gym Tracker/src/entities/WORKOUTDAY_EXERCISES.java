//package entities;
//
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//
//@Entity
//public class WORKOUTDAY_EXERCISES {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//	private double weight;
//	private int sets;
//	private int repetitions;
//	@ManyToOne
//	@JoinColumn(name = "workoutday_id")
//	private WorkoutDay day;
//	
//	@ManyToOne
//	@JoinColumn(name = "exercise_id")
//	private Exercise exercise;
//	
//	public WORKOUTDAY_EXERCISES() {
//		
//	}
//	
//	public WORKOUTDAY_EXERCISES(double weight, int sets, int repetitions, WorkoutDay day, Exercise exercise) {
//		this.setWeight(weight);
//		this.setSets(sets);
//		this.setRepetitions(repetitions);
//		this.setDay(day);
//		this.setExercise(exercise);
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public int getRepetitions() {
//		return repetitions;
//	}
//
//	public void setRepetitions(int repetitions) {
//		this.repetitions = repetitions;
//	}
//
//	public int getSets() {
//		return sets;
//	}
//
//	public void setSets(int sets) {
//		this.sets = sets;
//	}
//
//	public double getWeight() {
//		return weight;
//	}
//
//	public void setWeight(double weight) {
//		this.weight = weight;
//	}
//
//	public WorkoutDay getDays() {
//		return day;
//	}
//
//	public void setDay(WorkoutDay day) {
//		this.day = day;
//	}
//
//	public Exercise getExercise() {
//		return exercise;
//	}
//
//	public void setExercise(Exercise exercise) {
//		this.exercise = exercise;
//	}
//	
//}
