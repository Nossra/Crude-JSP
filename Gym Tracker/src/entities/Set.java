package entities;

import javax.persistence.Entity;

public class Set {
	private double weight;
	private int repetitions;
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
