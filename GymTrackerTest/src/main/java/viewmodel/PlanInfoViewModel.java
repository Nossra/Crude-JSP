package viewmodel;

public class PlanInfoViewModel {
	private String planName;
	private int dayNr;
	private String exerciseName;
	private double weight;
	private int repetitions;
		
	public PlanInfoViewModel(String planName, int dayNr, String exerciseName, double weight, int repetitions) {
		super();
		this.planName = planName;
		this.dayNr = dayNr;
		this.exerciseName = exerciseName;
		this.weight = weight;
		this.repetitions = repetitions;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public int getDayNr() {
		return dayNr;
	}
	public void setDayNr(int dayNr) {
		this.dayNr = dayNr;
	}
	public String getExerciseName() {
		return exerciseName;
	}
	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getRepetitions() {
		return repetitions;
	}
	public void setRepetitions(int repetitions) {
		this.repetitions = repetitions;
	}	
}
