package recursion;

import java.util.*;

public class Fibonacci {

	private static int fibonacci(int num, Map<Integer, Integer> memo) {
		if (num <= 1)
			return num;
		if (memo.containsKey(num)) {
			return memo.get(num);
		}
		memo.put(num, fibonacci(num - 1, memo) + fibonacci(num - 2, memo));
		return memo.get(num);
	}

	public static void main(String[] args) {
		int n = 9;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 0);
		map.put(1, 1);
		System.out.println(fibonacci(n, map));
		System.out.println(fibonacci_self(n, map));
	}

	private static int fibonacci_self(int num, Map<Integer, Integer> memo) {
		// 2 => 1 + 0
		// 3 => 2 + 1
		for (int i = 2; i <= num; i++) {
			memo.put(i, memo.get(i - 1) + memo.get(i - 2));
		}
		return memo.get(num);
	}
}

//0, 1, 1, 2, 3, 5, 8, 13, 21, 34,
