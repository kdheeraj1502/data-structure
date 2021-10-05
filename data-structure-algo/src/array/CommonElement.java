package array;

import java.util.*;

public class CommonElement {

	// -10 36 39 48 63 64 84 97
	public static ArrayList<Integer> commonElements(int A[], int B[], int C[]) {
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		for (int val : A) {
			set1.add(val);
		}
		for (int val : B) {
			if (set1.contains(val)) {
				set2.add(val);
			}
		}
		ArrayList<Integer> result = new ArrayList<>();
		for (int val : C) {
			if (set2.contains(val)) {
				if (!result.contains(val)) {
					result.add(val);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int num1[] = { 1, 5, 10, 20, 40, 80 };
		int num2[] = { 6, 7, 20, 80, 100 };
		int num3[] = { 3, 4, 15, 20, 30, 70, 80, 120 };
		System.out.println(commonElements(num1, num2, num3));
	}
}
