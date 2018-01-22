package entities.java;

import java.util.ArrayList;
import java.util.List;

public class Group {
	private String groupName;
	private List<Class> classes;
	
	public Group(String groupName) {
		this.setGroupName(groupName);
		this.setClasses(new ArrayList<Class>());
	}
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<Class> getClasses() {
		return classes;
	}

	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}
	
	public void printClasses() {
		System.out.println(this.getGroupName() + " classes.");
		for (int i = 0; i < this.getClasses().size(); i++) {
			System.out.println(this.getClasses().get(i).getName());
		}
		System.out.println();
	}

}
