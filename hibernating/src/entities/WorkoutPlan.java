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
public class WorkoutPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int timesPerWeek;
	@OneToMany
	@JoinColumn(name="WORKOUT_PLAN_ID")
	private List<WorkoutDay> workoutdays;
	
	public WorkoutPlan() {
		
	}
	
	public WorkoutPlan(String name, int timesPerWeek) {
		this.setName(name);
		this.setTimesPerWeek(timesPerWeek);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTimesPerWeek() {
		return timesPerWeek;
	}
	public void setTimesPerWeek(int timesPerWeek) {
		this.timesPerWeek = timesPerWeek;
	}

//	public List<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}
//	
	
}
