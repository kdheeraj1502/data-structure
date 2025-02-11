package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SmallerThanTriplet {
	static int sum = 0;
	static int count = 1;
	
	public static List<List<Integer>> numberSum(int num[], int val, List<List<Integer>> output) {
		Arrays.sort(num);
		int start;
		int end;
		for (int i = 0; i < num.length - 2; i++) {
			start = i + 1;
			end = num.length - 1;
			while (start < end) {
				int sum = num[i] + num[start] + num[end];
				if(sum < val) {
					List<Integer> curr = new ArrayList<>();
					curr.add(num[i]);
					curr.add(num[start]);
					curr.add(num[end]);
					output.add(curr);
					start++;
				}
				else
					end--;
			}
		}
		return output;
	}

	public static void main(String[] args) {
		int num[] = { 2, 7, 3, 5, -5, 8, -4, 1, 0 };
		List<List<Integer>> result = numberSum(num, 12, new ArrayList<>());
		List<String> output = result.stream().map(r -> {
			return r.stream().reduce(0, (a, b) -> a + b) + "_" + String.valueOf(count++);
		}).collect(Collectors.toList());
		output.stream().forEach(System.out::println);


		System.out.println("-----------------------------------");

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);


// Using reduce to find the sum of all elements
		int sum = numbers.stream().reduce(15, (acc, x) -> acc + x);

		System.out.println("Sum: " + sum); // Output: Sum: 15



	}
}
