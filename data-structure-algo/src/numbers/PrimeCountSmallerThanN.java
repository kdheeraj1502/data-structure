package numbers;

import java.util.*;

public class PrimeCountSmallerThanN {

	public int countPrimes(int n) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 0);
		map.put(1, 0);
		countPrimes(n, map);
		return map.get(n);
	}

	public void countPrimes(int n, Map<Integer, Integer> map) {
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (map.containsKey(i)) {
				count += map.get(i);
			} else if (isPrime(i)) {
				count++;
			}
		}
		map.put(n, count);
	}

	private boolean isPrime(int n) {
		boolean status = true;
		for (int i = 2; i <= n / 2; i++) {
			if ((n % i) == 0) {
				status = false;
				break;
			}
		}
		return status;
	}

	public static void main(String[] args) {
		PrimeCountSmallerThanN pcs = new PrimeCountSmallerThanN();
		System.out.println(pcs.countPrimes(10));
	}
}
