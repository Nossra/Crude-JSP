package Test.Java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entities.java.Teacher;

class TeacherTest {

	@Test
	void testConstructorFirstParam() {
		Teacher t = new Teacher("firstname", "lastname");
		
		String expected = "firstname";
		String actual = t.getFirstName();
		
		assertEquals(expected,actual);
	}
	
	@Test
	void testConstructorSecondParam() {
		Teacher t = new Teacher("firstname", "lastname");
		
		String expected = "lastname";
		String actual = t.getLastName();
		
		assertEquals(expected,actual);
	}
}
