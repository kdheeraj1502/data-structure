package companies.random;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainApp {

	public static void main(String[] args) {
		Java8MapSorting jms = new Java8MapSorting();
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(2, "Lokesh"));
		list.add(new Employee(1, "Alex"));
		list.add(new Employee(4, "Brian"));
		list.add(new Employee(5, "Neon"));
		list.add(new Employee(3, "David"));
		list.add(new Employee(7, "Alex"));
		list.add(new Employee(6, "Brian"));
		System.out.println(jms.listSorting(list));
		Map<Integer, String> ma = jms.listToMap(list);
		Map<Object, Object> sorted = jms.mapSorting(ma);
		System.out.println(sorted);
	}
}
