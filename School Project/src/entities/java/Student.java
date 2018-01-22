package entities.java;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
	private List<Subject> subjects;
	private Class inClass;
	
	public Student(String firstName, String lastName) {	
		super(firstName, lastName);
		subjects = new ArrayList<Subject>();
	}
	
	public List<Subject> getSubjects() {
		return subjects;
	}
	
	public void printSubjects() {
		System.out.println("Subjects for student: " + this.getFirstName() + " " + this.getLastName() + ", in class: " + this.getInClass().getName());
		for (int i = 0; i < this.getSubjects().size(); i++) {
			if (this.getSubjects().get(i).isCoreSubject()) {
				System.out.println(this.getSubjects().get(i).getName() + " - individually chosen");
			} else {
				System.out.println(this.getSubjects().get(i).getName());
			}
			
		}
		System.out.println();
	}

	public Class getInClass() {
		return inClass;
	}

	public void setInClass(Class inClass) {
		this.inClass = inClass;
	}
}
