package viewmodel;

public class PlanInfoViewModel {
	private String planName;
	private int dayNr;
	private String exerciseName;
	private double weight;
	private int repetitions;
	private int planId;
	private int timesPerWeek;
		
	public PlanInfoViewModel() {
		
	}
	
	public PlanInfoViewModel(String planName, int planId) {
		this.setPlanId(planId);
		this.setPlanName(planName);
	}
	
	public PlanInfoViewModel(String planName, String exerciseName, double weight, int repetitions, int timesPerWeek) {
		this.planName = planName;
		this.exerciseName = exerciseName;
		this.weight = weight;
		this.repetitions = repetitions;
		this.setTimesPerWeek(timesPerWeek);
	}
	
	public PlanInfoViewModel(String planName, int planId, int dayNr, String exerciseName, double weight, int repetitions, int timesPerWeek) {
		super();
		this.planName = planName;
		this.dayNr = dayNr;
		this.exerciseName = exerciseName;
		this.weight = weight;
		this.repetitions = repetitions;
		this.planId = planId;
		this.setTimesPerWeek(timesPerWeek);
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
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public int getTimesPerWeek() {
		return timesPerWeek;
	}

	public void setTimesPerWeek(int timesPerWeek) {
		this.timesPerWeek = timesPerWeek;
	}	
}
