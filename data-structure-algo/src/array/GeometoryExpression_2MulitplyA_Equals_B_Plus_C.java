package array;

import java.util.Arrays;

public class GeometoryExpression_2MulitplyA_Equals_B_Plus_C {

	// x + y = 2*z;
	public static void geoExpression(int num[]) {
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			int start = 0;
			int end = num.length - 1;
			int a = 2 * num[i];
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
					System.out.println("The numbers are, 2 times of " + num[i] + " = " + b + " + " + c + " and index are i "
							+ i + " start is " + start + " end is " + end);
					start++;
					end--;
				} else if (a < sum) {
					end--;
				} else
					start++;
			}
		}
	}

	public static void APTriplets(int num[]) {

		int i, j, k;
		for (i = 1; i < num.length; i++) {

			j = i - 1;
			k = i + 1;
			while (j >= 0 && k < num.length) {
				if (2 * num[i] == num[j] + num[k]) {
					System.out.println("The numbers are, 2 times of " + num[i] + " = " + num[j] + " + " + num[k]
							+ " and index are i " + i + " start is " + k + " end is " + j);
					k++;
					j--;
				} else if (2 * num[i] > num[j] + num[k])
					k++;
				else
					j--;
			}
		}

	}

	public static void main(String[] args) {
		int num[] = { 2, 7, 3, 5, -5, 8, -4, 1, 0 };
		geoExpression(num);
		System.out.println("------------------------------------------------------");
		APTriplets(num);
	}
}
