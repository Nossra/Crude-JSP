package main.java;

import entities.java.Grade;
import entities.java.Group;
import entities.java.Student;
import entities.java.Subject;
import entities.java.Teacher;
import entities.java.Class;

public class App {
	
	public static void main(String[] args) {
//		TEST DATA
//		Adding subjects and teachers. This is in reality a many-to-many relationship between Subject and Teacher.
//		Majbritt gets two courses and so does arnold. Religion A however gets two teachers. Sture and Sven.
//		I chose to put a teacher into the constructor of the subject to ensure that a subject actually has
//		Atleast one teacher. Additional teachers can be added after if it is needed.
		Teacher majbritt = new Teacher("Maj-britt", "Karlsson");
		Teacher arnold = new Teacher("Arnold", "Schwarzenegger");
		Teacher sture = new Teacher("Sture", "Bengtsson");
		Teacher sven = new Teacher("Sven", "Sturesson");
		
		System.out.println("Teachers created.");
		
//		Subjects are created here. These contain the name, atleast one teacher, and a boolean asking if its a core 
//		subject or not. If that is false, it means its an individually chosen subject. These get added directly into
//		the students subjects list.
		Subject biologiA = new Subject("Biologi A", majbritt, false);
		Subject biologiB = new Subject("Biologi B", majbritt, false);
		Subject fysikA = new Subject("Fysik A", arnold, false);
		Subject matematikA = new Subject("Matemaik A", sture, false);
		Subject religionA = new Subject("Religion A", sven, false);
		Subject tyskaA = new Subject("Tyska A", sven, true);
		Subject franskaA = new Subject("Franska A", arnold, true);
		religionA.getTeachers().add(sture); 
		
		System.out.println("Subjects created.");
		
		//TESTDATA
		//Adding grade 7 and also adding two groups of classes into it.
		//Each group gets a list of students and subjects they will study for 
		//that semester. Here we can add subjects directly into groups to get the
		//common subjects. 
		Grade grade7 = new Grade();
		Class class7a = new Class("7A");
		System.out.println("Grade 7 created.\nClass 7A created.");
		
		Student s1 = new Student("Martin", "Nilsson");
		Student s2 = new Student("Kristoffer", "Karlsson");
		Student s3 = new Student("Mårten", "Abrahamsson");
		Student s4 = new Student("Ture", "Sventon");
		System.out.println("Students created.");
		
		s1.getSubjects().add(tyskaA);
		s2.getSubjects().add(tyskaA);
		s3.getSubjects().add(franskaA);
		s4.getSubjects().add(franskaA);
		System.out.println("Individually chosen subjects added into students.");
		
		class7a.addStudents(s1, s2, s3, s4);
		class7a.addSubjects(biologiA, biologiB, fysikA, matematikA);
		grade7.getClasses().add(class7a);
		System.out.println("Students added into class 7A.\nSubjects added into class 7A.\nClass 7A added into Grade 7.");
		
		//Group 7B, which gets the same treatment as group 7A.
		Class class7b = new Class("7B");
		System.out.println("Class 7B created.");
		
		Student s5 = new Student("Stefan", "Nilsson");
		Student s6 = new Student("Harald", "Svensson");
		Student s7 = new Student("Kristin", "Håkansson");
		Student s8 = new Student("Märta", "Andersson");
		System.out.println("Students created.");
		
		s5.getSubjects().add(tyskaA);
		s6.getSubjects().add(tyskaA);
		s7.getSubjects().add(franskaA);
		s8.getSubjects().add(franskaA);
		System.out.println("Individually chosen subjects added into students.");
		
		class7b.addStudents(s5, s6, s7, s8);
		class7b.addSubjects(biologiA, fysikA, matematikA, religionA);
		grade7.getClasses().add(class7b);	
		System.out.println("Students added into class 7B.\nSubjects added into class 7B.\nClass 7B added into Grade 7.");
		
//		Both classes are added into a group
		Group group1 = new Group("Grupp A");
		System.out.println("Group 1 created.");
		group1.getClasses().add(class7a);
		group1.getClasses().add(class7b);
		System.out.println("Class 7A added into Group 1\nClass 7B added into Group 1.");

		
		System.out.println();
		grade7.printStudents();
		group1.printClasses();
		class7a.printStudents();
		class7b.printStudents();
		class7a.printSubjects();
		class7b.printSubjects();
		s1.printSubjects();
		s7.printSubjects();
		
		grade7.incrementGradeLevel("06-01");
	}
	
}
