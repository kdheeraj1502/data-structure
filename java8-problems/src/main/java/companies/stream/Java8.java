package companies.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8 {

	public static void main(String[] args) {
		List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
		Map<String, Long> map = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);
		
		
		List<String> link = new LinkedList<>();
		boolean flag = (items instanceof RandomAccess) ? true : false;
		System.out.println(flag);
		flag = (link instanceof RandomAccess) ? true : false;
		System.out.println(flag);
		Collections.synchronizedList(items);
	}
}
