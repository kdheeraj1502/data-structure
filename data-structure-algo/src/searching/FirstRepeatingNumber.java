package searching;

import java.util.*;

public class FirstRepeatingNumber {

	public static int firstRepeatingNum(int num[]) {
		int min = -1;
		if (num != null && num.length > 0) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = num.length - 1; i >= 0; i--) {
				if (map.containsKey(num[i])) {
					//return num[map.get(num[i])];
					min = i;
				}
				map.put(num[i], i);
			}
		}
	//	min = -1;
		if(Optional.of(num[min]).isPresent())
			return num[min];
		else
			return -1;
	}

	public static int firstRepeated(int num[]) {
		int i, j;
		for (i = 0; i < num.length; i++) {
			for (j = i + 1; j < num.length; j++) {
				if (num[i] == num[j]) {
					return num[i];
				}
			}
		}
		return 0;
	}

	public static int printFirstRepeating(int arr[]) {
		// Initialize index of first repeating element
		int min = -1;

		// Creates an empty hashset
		HashSet<Integer> set = new HashSet<>();

		// Traverse the input array from right to left
		for (int i = arr.length - 1; i >= 0; i--) {
			// If element is already in hash set, update min
			if (set.contains(arr[i]))
				min = i;

			else // Else add element to hash set
				set.add(arr[i]);
		}

		// Print the result
		if (min != -1) {
			System.out.println("The first repeating element is " + arr[min]);
			return arr[min];
		}
		else {
			System.out.println("There are no repeating elements");
			return -1;
		}
	}
}
