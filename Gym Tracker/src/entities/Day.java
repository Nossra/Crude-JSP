package entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Day {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int dayNr;
	private String name;
		
	public Day() {}
	
	public Day(int dayNr) {
		this.setNrOfDays(dayNr);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getNrOfDays() {
		return dayNr;
	}

	public void setNrOfDays(int dayNr) {
		this.dayNr = dayNr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
