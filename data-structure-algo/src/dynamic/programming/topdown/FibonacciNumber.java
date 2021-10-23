package dynamic.programming.topdown;

import java.util.*;

/**
 * Top down approach MEMOIZATION
 * 
 * Starting solving from from top to the bottom. Like from n then n - 1, n- 2
 * etc then to 0
 * 
 * from upper end to lower end
 * 
 * @author dheerajkumar02
 *
 */
public class FibonacciNumber {

	public int fibonacci(int n, Map<Integer, Integer> memo) {

		// Store solution of some elements which will get calculated again and instead
		// of calculation just find it from memory table
		if (!memo.containsKey(n)) {
			memo.put(n, fibonacci(n - 1, memo) + fibonacci(n - 2, memo));
		}
		return memo.get(n);
	}

	public static void main(String[] args) {

		// For Memoization, create a table which will hold overlapping problem
		Map<Integer, Integer> memo = new HashMap<>();
		memo.put(0, 1);
		memo.put(1, 1);

		FibonacciNumber fn = new FibonacciNumber();
		System.out.println(fn.fibonacci(8, memo));
	}
}
