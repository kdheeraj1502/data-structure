package design.monarchy;

import java.util.*;

/**
 * 
 * Interface design of Monarchy
 * 
 * DFS 
 * 
 * n array preorder
 * 
 * @author dheerajkumar02
 *
 */
public class MonarchyImpl implements Monarchy{

	private Map<String, Person> persons = new HashMap<>();
	private Person king;

	public MonarchyImpl(String king) {
		this.king = new Person(king);
		this.persons.put(king, this.king);
	}

	public void birth(String childName, String parentName) {
		Person parentObject = persons.get(parentName);
		Person child = new Person(childName);
		parentObject.getChildren().add(child);
		this.persons.put(childName, child);
	}

	public void death(String name) {
		Person person = persons.get(name);
		if (person == null) {
			return;
		}
		person.setAlive(false);
	}

	public List<String> getOrderOfSuccession() {
		List<String> succession = new ArrayList<>();
		this.dfs(this.king, succession);
		return succession;
	}

	private void dfs(Person currPerson, List<String> succession) {
		if (currPerson.isAlive()) {
			succession.add(currPerson.getName());
		}
		for (int i = 0; i < currPerson.getChildren().size(); i++) {
			this.dfs(currPerson.getChildren().get(i), succession);
		}
	}

	public static void main(String[] args) {
		MonarchyImpl monarchy = new MonarchyImpl("Jake");
		monarchy.birth("Catherine", "Jake");
		monarchy.birth("Tom", "Jake");
		monarchy.birth("Celine", "Jake");
		monarchy.birth("Jane", "Catherine");
		monarchy.birth("Mark", "Catherine");
		monarchy.birth("Farah", "Jane");
		monarchy.birth("Peter", "Celine");
		
		List<String> order = monarchy.getOrderOfSuccession();
		order.stream().forEach(System.out::println);
	}
}
