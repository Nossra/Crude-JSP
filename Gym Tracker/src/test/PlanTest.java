package test;

import static org.junit.Assert.*;

import org.junit.Test;

import entities.Day;
import entities.Exercise;
import entities.Exercise.Muscle;
import entities.Plan;
import entities.User;

public class PlanTest {

	@Test
	public void testConstructor() {
		User u = new User("Martin", "Martin", "1234");
		Plan p = new Plan("Testplan", 2, u);
		
		int expected = 2;
		int actual = p.getDays().size();
		
		assertEquals(expected, actual);	
	}


}
