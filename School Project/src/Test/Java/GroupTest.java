package Test.Java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entities.java.Group;

class GroupTest {

	@Test
	void testGroupNameSetter() {
		Group g = new Group("gn");
		g.setGroupName("groupname");

		String expected = "groupname";
		String actual = g.getGroupName();
		assertEquals(expected, actual);
	}
}
