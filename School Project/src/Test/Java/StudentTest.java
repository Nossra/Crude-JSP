package Test.Java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entities.java.Student;
import entities.java.Subject;
import entities.java.Teacher;

class StudentTest {

	@Test
	void testGetSubjectList() {
		Student student = new Student("firstName", "lastName");
		Teacher teacher = new Teacher("firstName", "lastName");
		Subject su1 = new Subject("Biologi", teacher, false);
		
		student.getSubjects().add(su1);
		student.getSubjects().add(new Subject("fysik", new Teacher("s", "s"), false));
		
		int expected = 2;
		int actual = student.getSubjects().size(); 
		assertEquals(expected, actual);
	}
	
	@Test
	void testConstructorFirstParam() {
		Student student = new Student("firstname", "lastname");
		
		String expected = "firstname";
		String actual = student.getFirstName();
		
		assertEquals(expected,actual);
	}
	
	@Test
	void testConstructorSecondParam() {
		Student student = new Student("firstname", "lastname");
		
		String expected = "lastname";
		String actual = student.getLastName();
		
		assertEquals(expected,actual);
	}
	
	

}
