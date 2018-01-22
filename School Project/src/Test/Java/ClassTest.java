package Test.Java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClassTest {

	@Test
	void testSetName() {
		entities.java.Class c = new entities.java.Class("name");
		
		String expected = "name";
		String actual = c.getName();
		
		assertEquals(expected, actual);
	}

}
