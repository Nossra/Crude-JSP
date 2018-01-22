package entities.java;

import java.util.ArrayList;
import java.util.List;

public class Class implements IMethods {
	private String name;
	private List<Student> students;
	private List<Subject> subjects;
	
	public Class(String name) {
		this.setName(name);
		students = new ArrayList<Student>();
		subjects = new ArrayList<Subject>();
	}
	
	public List<Subject> getSubjects() {
		return subjects;
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addStudents(Student... s) {
		for (Student student : s) {
			this.getStudents().add(student);
		}
		this.addClassIntoStudent(s);
	}
	
	public void addClassIntoStudent(Student... s) {
		for (Student student : s) {
			for (int i = 0; i < this.getStudents().size(); i++) {
				this.getStudents().get(i).setInClass(this);
			}
		}
	}
	
	public void addSubjects(Subject... s) {
		for (Subject subject : s) {
			this.getSubjects().add(subject);
		}
		this.addSubjectsIntoStudent(s);
		
	}
	
	public void addSubjectsIntoStudent(Subject... s) {
		for (Subject subject : s) {
			for (int i = 0; i < this.getStudents().size(); i++) {
				this.getStudents().get(i).getSubjects().add(subject);
			}
		}
	}

	@Override
	public void printStudents() {
		System.out.println(this.getName() + " students.");
		for (int i = 0; i < this.getStudents().size(); i++) {
			System.out.println(this.getStudents().get(i).getFirstName() + " " + this.getStudents().get(i).getLastName());
		}
		System.out.println();
	}
	
	public void printSubjects() {
		System.out.println("Common subjects in class: " + this.getName());
		for (int i = 0; i < this.getSubjects().size(); i++) {
			System.out.println(this.getSubjects().get(i).getName());
		}
		System.out.println();
	}
}
