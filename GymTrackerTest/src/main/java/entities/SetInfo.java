package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SetInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double weight;
	private int repetitions;
	
	public SetInfo() {}
	
	public SetInfo(double weight, int repetitions) {
		this.setWeight(weight);
		this.setRepetitions(repetitions);
	}
	
	public int getRepetitions() {
		return repetitions;
	}
	
	public void setRepetitions(int repetitions) {
		this.repetitions = repetitions;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
}
