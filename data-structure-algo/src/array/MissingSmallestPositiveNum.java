package array;

import java.util.*;

public class MissingSmallestPositiveNum {

	public static int findSmallestPositiveNumber(int num[]) {

		int found;
		for (int i = 1; i <= num.length; i++) {
			found = 0;
			for (int j = 0; j < num.length; j++) {
				if (num[j] == i) {
					found = 1;
					break;
				}
			}
			if (found == 0)
				return i;
		}

		return -1;
	}

	public static int findSmallestPositiveNumberHashMap(int num[]) {

		Set<Integer> map = new HashSet<>();

		for (int i = 0; i < num.length; i++) {
			map.add(num[i]);
		}

		for (int i = 1; i <= num.length; i++) {
			if (map.contains(i) == false) {
				return i;
			}
		}

		return -1;
	}

	// Using auxilary array
	// fill all value with -1 in aux array

	public static int findSmallestPositiveNumberUsingAux(int num[]) {
		int aux[] = new int[num.length];
		// this is used if input array has value 0 in it and
		// we are calling 0 a smallest number else -1 fill is not required
		Arrays.fill(aux, -1);

		// Now loop through input array and store the value at the same index
		// for example at 1 index store (2 - 1) at 4 index store (5 - 1)
		for (int i = 0; i < num.length; i++) {
			if (num[i] > 0 && num[i] <= num.length) {
				aux[num[i] - 1] = num[i];
			}
		}

		// Now through the input array again and for example
		// if at index 2 if we dont find 3 then 3 is missing
		// for the smallest if at 0 index we dont find 1 then 1 is missing
		for (int i = 0; i < num.length; i++) {
			if (aux[i] != i + 1) {
				return i + 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int num[] = { 8, 5, 6, 1, 9, 11, 2, 4, 3 };
		System.out.println(findSmallestPositiveNumberUsingAux(num));
	}
}
