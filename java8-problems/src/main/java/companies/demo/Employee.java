package companies.demo;

public class Employee {

	public String name;
	public int year;
	public Project project;
	public Employee(String name, int year, Project project) {
		this.name = name;
		this.year = year;
		this.project = project;
	}
	
	public static void main(String[] args) {
		Project project = new Project("Banking");
		
		Employee employee = new Employee("Type", 2010, project);
		
		System.out.println(employee.year);
		System.out.println(employee.project);
		
		modify(employee, 2014);
		
		System.out.println(employee.year);
		System.out.println(employee.project);
	}
	
	public static void modify(Employee employee, int year) {
		employee.year = year;
		employee.project =  new Project("Trading");
	}
}
