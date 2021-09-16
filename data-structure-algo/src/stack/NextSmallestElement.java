package stack;

import java.util.*;

public class NextSmallestElement {

	public static int[] nextSmallestELement(int num[]) {
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		int result[] = new int[num.length];
		for (i = 0; i < num.length; i++) {
			while (!stack.isEmpty() && num[stack.peek()] >= num[i]) {
				int val = stack.pop();
				result[val] = num[i];
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			int val = stack.pop();
			result[val] = -1;
		}
		
		return result;
	}

	public static void main(String[] args) {
		int num[] = { 20, 19, 10, 21, 40, 35, 39, 50, 45, 34 };
		int result[] = nextSmallestELement(num);
		Map<Integer, Integer> map = new LinkedHashMap<>();
		for(int i = 0; i < num.length; i++) {
			map.put(num[i], result[i]);
		}
		System.out.println(map);
	}
}
