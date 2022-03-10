package amazon.algo;

import java.util.*;

public class ConsecutivelyDecreasingRating {

	public static long decreaseRating(List<Integer> ratings) {
		long load = 0;
		long ans = 0;
		for (int i = 0; i < ratings.size(); i++) {
			if (load == 0) {
				load = 1;
			} else {
				if (ratings.get(i - 1) == ratings.get(i) + 1) {
					load++;
				} else {
					ans += sumOfNNaturalNumbers(load);
					load = 1;
				}
			}
		}
		ans += sumOfNNaturalNumbers(load);
		return ans;
	}

	private static long sumOfNNaturalNumbers(long n) {
		if (n % 2 == 0) {
			return ((n / 2) * (n + 1));
		} else {
			return n * ((n + 1) / 2);
		}
	}

	public static long decreaseRating_self(List<Integer> ratings) {
		int load = 0;
		int ans = 0;
		for (int i = 0; i < ratings.size(); i++) {
			if (i == 0) {
				load = 1;
			} else {
				if (ratings.get(i - 1) == ratings.get(i) + 1) {
					load++;
				} else {
					ans += sumOfNNaturalNumbers(load);
					load = 1;
				}
			}
		}
		ans += sumOfNNaturalNumbers(load);
		return ans;
	}

	public static void main(String[] args) {
		List<Integer> ratings = Arrays.asList(4, 3, 5, 4, 3);
		//List<Integer> ratings = Arrays.asList(5, 3, 5, 3, 1);
		System.out.println(decreaseRating_self(ratings));
	}
}
