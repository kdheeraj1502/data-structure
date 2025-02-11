package companies.java8;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamProblems {
	
	

	public static void main(String[] args) {
		String input = "Java is best progtamming language than jevlin through";
		char ch = input.chars()
				.mapToObj(c -> Character.toLowerCase(Character.valueOf((char)c)))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet()
				.stream()
				.filter(m -> m.getValue() == 1L)
				.map(e -> e.getKey())
				.findFirst()
				.get();
		System.out.println(ch);
				
	}
}
