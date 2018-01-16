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
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String username;
	private String password;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	private List<WorkoutPlan> workoutplans;
	
	
	public User() {
		
	}
	
	public User(String name, String username, String password) {
		this.setName(name);
		this.setUsername(username);
		this.setPassword(password);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

//	public List<WorkoutPlan> getWorkoutplans() {
//		return workoutplans;
//	}
//
//	public void setWorkoutplans(List<WorkoutPlan> workoutplans) {
//		this.workoutplans = workoutplans;
//	}
//	
}
