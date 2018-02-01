package entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Day {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int dayNr;
	@ManyToOne
	private Plan plan;
		
	public Day() {}
	
	public Day(int dayNr, Plan plan) {
		this.setDayNr(dayNr);
		this.setPlan(plan);
	}
	
	public Day(int dayNr) {
		this.setDayNr(dayNr);
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

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}
}
