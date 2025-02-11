package companies.random;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8MapSorting {

	public List<Employee> listSorting(List<Employee> list) {

		return list.stream().sorted(Comparator.comparing(Employee::getId).thenComparing(Employee::getName))
				.collect(Collectors.toList());
	}

	public Map<Integer, String> listToMap(List<Employee> list) {

		return list.stream().collect(Collectors.toMap(Employee::getId, Employee::getName));

	}

	public Map<Object, Object> mapSorting(Map<Integer, String> map) {
	//	return map.entrySet().stream().sorted(Map.Entry.comparingByValue())
	//			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> o, LinkedHashMap::new));
		return null;
	}
	
	public void reduceCOllectos() {
		//int val = integerList.stream().collect(
		  //      Collectors.reducing(0, a1 -> a1 * 5, (a1, a2) -> a1 + a2));
	}

}
