package entities.java;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	private String name;
	private int points;
	private boolean coreSubject;
	private List<Teacher> teachers;
	
	public Subject(String name, Teacher teacher, boolean core) {
		teachers = new ArrayList<Teacher>();
		teachers.add(teacher);
		this.setName(name);
		this.setCoreSubject(core);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}

	public boolean isCoreSubject() {
		return coreSubject;
	}

	public void setCoreSubject(boolean coreSubject) {
		this.coreSubject = coreSubject;
	}

}
