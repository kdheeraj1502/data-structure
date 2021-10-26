package stack;

import java.util.Stack;

public class MaxAreaHistogramStack {

	public static int maxArea(int num[]) {
		Stack<Integer> stack = new Stack<>();
		int size = num.length;
		int i = 0;
		int top;
		int currArea;
		int maxArea = 0;
		while (i < size) {
			if (stack.isEmpty() || num[stack.peek()] <= num[i]) {
				stack.push(i);
				i++;
			} else {
				top = stack.peek();
				stack.pop();
				currArea = num[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
				maxArea = Math.max(currArea, maxArea);
			}

		}
		return maxArea;
	}

	public static int maxAreaSelf(int num[]) {
		Stack<Integer> stack = new Stack<>();
		int currArea = 0;
		int maxArea = 0;
		int i = 0;
		int top = -1;
		while(i < num.length) {
			if(stack.isEmpty() || stack.peek() <= num[i]) {
				stack.push(i++);
			}else {
				top = stack.peek();
				stack.pop();
				currArea = num[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
				maxArea = Math.max(maxArea, currArea);
			}
		}
		return maxArea;
	}
	
	public static int maxArea_self(int num[]) {
		Stack<Integer> stack = new Stack<>();
		int currArea = 0;
		int maxArea = 0;
		int top = -1;
		for(int i = 0; i < num.length; i++) {
			if(stack.isEmpty() || stack.peek() <= num[i]) {
				stack.push(i);
			} else {
				top = stack.peek();
				currArea = num[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
				maxArea = Math.max(maxArea, currArea);
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		int num[] = { 7, 6, 5, 44, 1, 6, 3, 1 };
		// int num[] = { 7, 8, 9, 10, 11, 12, 13, 14 };
		System.out.println(maxAreaSelf(num));
		System.out.println(maxArea_self(num));
	}

}
