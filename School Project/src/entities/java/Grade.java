package entities.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Grade implements IMethods {
	private int minGradeLevel = 7;
	private int maxGradeLevel = 9;
	private int gradeLevel;
	private List<Class> classes;
	private boolean alreadyIncreased = false;
	
//	Gradelevel gets set based on the lowest grade available to the school.
//	If the school has classes starting on grade 1, it sets to 1, and so on.
//	This then increments +1 after every spring term. The list ensures
//	that multiple classes can be in the same grade for the bigger schools.
//	Smaller schools can just have one class in the list for that grade. 
//	min and max values of the grade level is set for each school. I didnt want 
//	these to be final constants since there could be changes to this in the 
//	school itself. The boolean alreadyIncreased is used to hinder multiple 
//	increments of gradeLevel.
	
	public Grade() {
		this.setGradeLevel(minGradeLevel);
		this.setClasses(new ArrayList<Class>());
	}

	public List<Class> getClasses() {
		return classes;
	}

	public void setClasses(List<Class> groups) {
		this.classes = groups;
	}
	
	@Override
	public  void printStudents() {
		System.out.println("Students in grade: " + this.getGradeLevel());
		for (int i = 0; i < this.getClasses().size(); i++) {
			for (int j = 0; j < this.getClasses().get(i).getStudents().size(); j++) {
				System.out.println(this.getClasses().get(i).getStudents().get(j).getFirstName() + " "
								 + this.getClasses().get(i).getStudents().get(j).getLastName());
			} 
		}
		System.out.println();
	}

	public int getGradeLevel() {
		return gradeLevel;
	}

	public void setGradeLevel(int gradeLevel) {
		this.gradeLevel = gradeLevel;
	}	

	public boolean isAlreadyIncreased() {
		return alreadyIncreased;
	}

	public void setAlreadyIncreased(boolean alreadyIncreased) {
		this.alreadyIncreased = alreadyIncreased;
	}
	
//	- The point of this method is for it to run once every day to automatically increment the gradeLevel when it hit
//	the specified date (The start of the autumn term). The startDate could be set during setup of an implementation
//	at a school using the system.
//	- First check if the value is already increased, if not, it checks the date to see if it is the specified startDate.
//	If it is, then increase gradelevel for the object by 1. End with setting the alreadyIncreased boolean to true to 
//	hinder multiple increments if the method gets called several times during this date.
//	- If alreadyIncreased is true it will check if it is not the specified startDate, if so, it will set the alreadyIncreased
//	value to false, so it can be run again the next year. 
//	I'm substringing the LocalDate because im not sure if the year is needed to be specified, if so, it can simply be removed.
	public void incrementGradeLevel(String startDate) {			
		String date = LocalDate.now().toString().substring(5);
		if (!isAlreadyIncreased()) {
			if (this.getGradeLevel() < this.maxGradeLevel) {
				if (date.equals(startDate)) this.setGradeLevel(this.getGradeLevel()+1);
				setAlreadyIncreased(true);
			}
		} else {
			if (!date.equals(startDate)) setAlreadyIncreased(false);
		}
	}
}
