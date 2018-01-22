package Test.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import entities.java.Class;
import entities.java.Grade;

class GradeTest {

	@Test
	void testGroupsList() {
		Grade grade = new Grade();
		Class c = new Class("classname");
		grade.getClasses().add(c);
		
		int expected = 1;
		int actual = grade.getClasses().size(); 
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testIncGradeLvlHindrance() {
		//Test so it cant be called several times during the specified startDate
		//and then increments the value too much. Im calling the method ten times here.
		//NOTE - the inparameter of incrementGradeLevel is the startDate, which is used
		//in the method to compare against the current date. 
		Grade g = new Grade();
		
		for (int i = 0; i < 10; i++) {
			g.incrementGradeLevel(LocalDate.now().toString().substring(5));
		}		
		
		int expected = 2;
		int actual = g.getGradeLevel();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testIncGradeLvlRestart() {
//		Test to see if the method will be able to run again the year after.
//		The test lightly simulates the intentions of the method. Since it will
//		run once every day the "another date" one would run 364 times before
//		the actual date is hit again.
		Grade g = new Grade();
		
		g.incrementGradeLevel(LocalDate.now().toString().substring(5));
		g.incrementGradeLevel("another date"); //date that will never happen, especially since its in the wrong format (MM-dd)
		g.incrementGradeLevel(LocalDate.now().toString().substring(5));
		
		int expected = 3;
		int actual = g.getGradeLevel();
		
		assertEquals(expected, actual);
	}
}
