package dynamic.programming.bottomup;

import java.util.HashMap;
import java.util.Map;

/**
 * Bottom up approach Start solving problem from tiny sub problem and reach up
 * to main problem like climbing a ladder
 * 
 * Like from 0 then 1, 2, then n - 1, n from lower end to upper end
 * 
 * @author dheerajkumar02
 *
 */
public class FibonacciNumber {

	public static void main(String[] args) {
		Map<Integer, Integer> memo = new HashMap<>();
		memo.put(0, 1);
		memo.put(1, 1);

		FibonacciNumber fn = new FibonacciNumber();
		System.out.println(fn.fibonacci(999999, memo));
		memo.clear();
		System.out.println(fn.fibo(memo, 999999));
	}

	private int fibonacci(int n, Map<Integer, Integer> memo) {
		for (int i = 2; i <= n; i++) {
			memo.put(i, memo.get(i - 1) + memo.get(i - 2));
		}
		return memo.get(n);
	}
	
	// Its top down and recursion hence will cause stack over flow
	public int fibo(Map<Integer, Integer> memo, int n) {
		if(n == 0 || n == 1) return 1;
		if(memo.containsKey(n)) {
			memo.get(n);
		} else
			memo.put(n, fibo(memo, n - 1) + fibo(memo, n - 2));
		return memo.get(n);
	}
}
