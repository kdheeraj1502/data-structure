package stack;

import java.util.*;

public class StockAnalystProblem {

	public static List<Integer> nextLargerEle(int num[]) {
		List<Integer> result = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		int i = 1;
		stack.push(num[0]);
		while (i < num.length) {
			if (stack.peek() <= num[i])
				stack.push(num[i]);
			i++;
		}
		Iterator<Integer> it = stack.iterator();
		while (it.hasNext()) {
			result.add(it.next());
		}
		return result;
	}

	public static void nextLargestElement(int num[]) {
		int[] output = new int[num.length];
		int index = 0;
		int next;
		for (int i = 0; i < num.length; i++) {
			next = -1;
			for (int j = i + 1; j < num.length; j++) {
				if (num[i] < num[j]) {
					next = num[j];
					break;
				}
			}
			output[index++] = next;
		}
		for (int val : output) {
			System.out.print(val + " ");
		}
	}



	public static void main(String[] args) {
		int num[] = { 20, 19, 10, 21, 40, 35, 39, 50, 45, 42 };
		nextLargestElement(num);
	}
}
