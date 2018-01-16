package entities;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class WorkoutDay {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int date;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="WORKOUTDAY_ID")
	private List<WORKOUTDAY_EXERCISES> workoutdays;
	
	public WorkoutDay() {
		
	}
	
	public WorkoutDay(int date) {
		this.setDate(date);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
}
