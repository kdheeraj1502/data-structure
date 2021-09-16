package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextLargestElementCircular {

	public static int[] nextLargestElementCircular(int num[]) {
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		int result[] = new int[num.length];
		int n = num.length;
		// [7, 8, 9, 4]
		while (i < 2 * n - 1) {
			while (!stack.isEmpty() && (num[stack.peek()] < num[i % n])) {
				int index = stack.pop();
				result[index] = num[i % n];
			}
			stack.push(i % n);
			i++;
		}

		while (!stack.isEmpty()) {
			int index = stack.pop();
			result[index] = -1;
		}

		return result;
	}

	public static int[] nextLargestElementCircularBook(int num[]) {
		Stack<Integer> stack = new Stack<>();
		int result[] = new int[num.length];
		int n = num.length;
		int curr;
		for (int i = 2 * n - 1; i >= 0; i--) {
			curr = num[i % n];
			while (!stack.isEmpty() && num[stack.peek()] <= curr) {
				stack.pop();
			}
			if (i < n) {
				if (!stack.isEmpty())
					result[i] = num[stack.peek()];
				else
					result[i] = -1;
			}
			stack.push(i % n);
		}
		return result;
	}

	public static int[] printNGE(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int n = arr.length;
		int[] result = new int[n];

		for (int i = 2 * n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && arr[i % n] >= stack.peek()) {
				// while (!stack.isEmpty() && arr[stack.peek()] <= arr[i % n]) {
				stack.pop();
			}
			if (i < n) {
				if (!stack.isEmpty())
					result[i] = stack.peek();
				else
					result[i] = -1; // When none of elements in Stack are greater than arr[i%n]
			}
			stack.push(arr[i % n]);
		}
		return result;
	}

	public static int[] nextLargestElementCircular_self(int num[]) {
		Stack<Integer> stack = new Stack<>();
		int n = num.length;
		int[] result = new int[n];
		int i = 2 * n - 1;
		while (i >= 0) {
			while (!stack.empty() && num[stack.peek()] <= num[i % n]) {
				stack.pop();
			}
			if (i < n) {
				if (!stack.isEmpty()) {
					result[i % n] = num[stack.peek()];
				} else
					result[i % n] = -1;
			}
			stack.push(i % n);
			i--;
		}

		return result;
	}

	public static void main(String[] args) {
		int num[] = { 20, 19, 10, 21, 40, 35, 39, 50, 45, 42 };
//		int result[] = nextLargestElementCircular(num);
//		System.out.println(Arrays.toString(result));
		System.out.println(Arrays.toString(nextLargestElementCircular_self(num)));
	}
}
