package design.monarchy;

import java.util.*;

public class Person {

	private String name;
	private List<Person> children;
	private boolean isAlive;
	
	public Person(String name){
		this.name = name;
		this.children = new ArrayList<>();
		this.isAlive = true;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Person> getChildren() {
		return children;
	}
	public void setChildren(List<Person> children) {
		this.children = children;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
}
