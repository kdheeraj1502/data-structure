package array;

import java.util.Arrays;

public class GeometricProgressionTriplet_CmultiplyCequalsAplusB {

	// x + y = z ^ z;
	public static void geoExpression(int num[]) {
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			int start = 0;
			int end = num.length - 1;
			int a = num[i] * num[i];
			// [-5, -4, 0, 1, 2, 3, 5, 7, 8]
			while (start < end) {
				int b = num[start];
				int c = num[end];
				int sum = b + c;
				/*
				 * if (start == i) { System.out.println("start and i is same the values are :" +
				 * a + " = " + b + " + " + c + " and " + (sum == a) + " and index are i " + i +
				 * " start is " + start + " end is " + end); }
				 */
				if (a == sum) {
					System.out.println("The numbers are, Square of " + num[i] + " = " + b + " + " + c
							+ " and index are i " + a + " start is " + start + " end is " + end);
					start++;
					end--;
				} else if (a < sum) {
					end--;
				} else
					start++;
			}
		}
	}

	public static void main(String[] args) {
		int num[] = { 2, 7, 3, 5, -5, 8, -4, 1, 0 };
		geoExpression(num);
	}
}
