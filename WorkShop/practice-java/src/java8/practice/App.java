package java8.practice;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

public class App {

	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<>();
		myList.add(10);
		myList.add(15);
		myList.add(8);
		myList.add(49);
		myList.add(15);
		myList.add(25);
		myList.add(98);
		myList.add(32);
		myList.add(98);

		System.out.println("----- Find even number ---------");
		List<Integer> result = myList.stream().filter(n -> (n & 1) == 0).collect(Collectors.toList());
		result.forEach(System.out::println);

		System.out.println("----- Starting with 1 ---------");
		myList.stream().filter(n -> (n / 10) == 1).forEach(System.out::println);

		System.out.println("----- Find duplicate ---------");
		Set<Integer> set = new HashSet<>();
		myList.stream().filter(n -> !set.add(n)).forEach(System.out::println);

		System.out.println("----- Find first ---------");
		myList.stream().findFirst().ifPresent(System.out::println);

		System.out.println("------------Find count---------");
		long count = myList.stream().count();
		System.out.println(count);

		System.out.println("----------- Find max number ------------");
		int max = myList.stream().max(Integer::compare).get();
		System.out.println(max);

		System.out.println("--------- Find non repeating character --------------");
		String input = "Java is Awesome";

		char output = input.chars() // Stream of String
				.mapToObj(c -> Character.toLowerCase(Character.valueOf((char) c)))
				// First convert to Character object and then to lower case
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				// Store the chars in map with count
				.entrySet().stream().filter(entry -> entry.getValue() == 1L).map(entry -> entry.getKey()).findFirst()
				.get();
		System.out.println(output);

		System.out.println("--------- Find first repeating character --------------");

		char repeated = input.chars() // Stream of String
				.mapToObj(c -> Character.toLowerCase(Character.valueOf((char) c)))
				// First convert to Character object and then to lower case
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				// Store the chars in map with count
				.entrySet().stream().filter(entry -> entry.getValue() > 1L).map(entry -> entry.getKey()).findFirst()
				.get();
		System.out.println(repeated);

		System.out.println("--------- sort numbers --------------");
		myList.stream().sorted().forEach(System.out::println);

		System.out.println("--------- sort in reverse numbers --------------");
		myList.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

		System.out.println("--------------------- Reduce -----------------");
		int sum = myList.stream().reduce(0, (a, b) -> a + b);
		int s = myList.parallelStream().reduce(0, (a, b) -> a + b);
		System.out.println(sum);
		System.out.println(s);
		System.out.println("------------------------------------------------------------------------------------");

		Map<String, Integer> budget = new HashMap<>();
		budget.put("clothes", 120);
		budget.put("grocery", 150);
		budget.put("transportation", 100);
		budget.put("utility", 130);
		budget.put("rent", 1150);
		budget.put("miscellneous", 90);
		
		System.out.println("---------------");
		String str = "" + 1;
			System.out.println(str);
		
		Map<String, Integer> sorted = budget.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));

		// toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
		// LinkedHashMap::new));

		System.out.println("------------------------- Concurrent Modfication --------------------------");

	//	BinaryOperator<T>
		//UnaryOperator<T>
		CopyOnWriteArrayList<Integer> copy = new CopyOnWriteArrayList<>(myList);
		Iterator<Integer> it = myList.iterator();
		int i = 10;
		while (it.hasNext()) {
			Integer in = it.next();
			System.out.println(in);
			//	myList.add(++i);
		}

		for (Integer in : myList) {
			System.out.println(in);
		//	myList.add(++i);
		}
		
		//CompletableFuture.supplyAsync(null, null);
		List<String> list1 = Arrays.asList("A","B", "A");
		System.out.println("----------grouping by------------");
		Map<String, Long> result1 =
				list1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(result1);

		Map<String, Long> result2 =result1.entrySet()
				.stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (o, n) -> n,
						LinkedHashMap::new));
		System.out.println(result2);
	}

}
