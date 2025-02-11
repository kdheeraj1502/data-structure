package companies.demo;

public class Project {
	public String name;

	Project(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Project [name=" + name + "]";
	}
}
