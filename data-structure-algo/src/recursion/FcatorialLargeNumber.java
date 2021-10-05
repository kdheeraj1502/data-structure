package recursion;

import java.util.*;

public class FcatorialLargeNumber {

	public static void factorial(int n) {
		int res[] = new int[500];
		res[0] = 1;
		int res_size = 1;
		// n! = 1 * 2 * 3 * 4...*n
		for (int x = 2; x <= n; x++)
			res_size = multiply(x, res, res_size);

		System.out.println("Factorial of given number is ");
		for (int i = res_size - 1; i >= 0; i--)
			System.out.print(res[i]);
	}

	public static int multiply(int x, int result[], int resultSize) {
		int carry = 0;
		for (int i = 0; i < resultSize; i++) {
			int prod = result[i] * x + carry;
			System.out.println("prod => " + prod + " = " + result[i] + " * " + x + " + " + carry);
			result[i] = prod % 10;
			System.out.println("res[i] : " + result[i] + " = " + prod + " % " + (10));
			carry = prod / 10;
			System.out.println("Carry " + carry + " = " + prod + " / " + (10));
		}
		while (carry != 0) {
			result[resultSize] = carry % 10;
			System.out.println("res[res_size] : " + result[resultSize] + " = " + carry + " % " + (10));
			carry = carry / 10;
			System.out.println("Carry " + carry + " = " + carry + " / " + (10));
			resultSize++;
		}
		return resultSize;
	}

	public static ArrayList<Integer> factorial_1(int N) {
		// code here
		ArrayList<Integer> output = new ArrayList<>();
		int result[] = new int[500];
		result[0] = 1;
		int resultSize = 1;
		for (int i = 2; i <= N; i++) {
			resultSize = multiply(i, result, resultSize);
		}

		// Traverse from back
		for (int i = resultSize - 1; i >= 0; i--) {
			output.add(result[i]);
		}
		return output;
	}

	public static void main(String[] args) {
		ArrayList<Integer> al = factorial_1(20);
	//	System.out.println(al);
	//	System.out.println(al.size());
	}
}
