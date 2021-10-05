package array;

import java.util.Stack;

public class WaterTrapping {

	// Not worked
	public static int trap_book(int[] num) {
		int water = 0;
		int leftHeight[] = new int[num.length];
		int rightHeight[] = new int[num.length];
		leftHeight[0] = num[0];
		rightHeight[num.length - 1] = num[num.length - 1];
		
		int max = num[0];
		for(int i = 1; i < num.length; i++) {
			if(max < num[i]) {
				max = num[i];
			}
			leftHeight[i] = max;
		}
		max = num[num.length - 1];
		for(int i = num.length - 2; i >= 0; i--) {
			if(max < num[i]) {
				max = num[i];
			}
			rightHeight[i] = max;
		}
		for(int i = 0; i < num.length; i++) {
			water += Math.min(leftHeight[i], rightHeight[i]) - num[i];
		}
		
		return water;
	}

	public static int trap_self(int[] num) {
		int area = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < num.length; i++) {
			while (!stack.isEmpty() && num[stack.peek()] < num[i]) {
				int remove = stack.peek();
				stack.pop();
				if (stack.isEmpty())
					break;
				int dis = i - stack.peek() - 1;
				int h = Math.min(num[i], num[stack.peek()]) - num[remove];
				area += h * dis;
			}

			stack.push(i);
		}
		return area;
	}

	public static int trap(int[] num) {
		Stack<Integer> stack = new Stack<>();
		int ans = 0;
		for (int i = 0; i < num.length; i++) {
			while (!stack.isEmpty() && num[stack.peek()] < num[i]) {
				int h = num[stack.peek()];
				stack.pop();
				if (stack.isEmpty())
					break;
				int distance = i - stack.peek() - 1;
				int min_height = Math.min(num[stack.peek()], num[i]) - h;
				ans += distance * min_height;
			}
			stack.push(i);
		}
		return ans;
	}

	public static int trapRainWater(int[][] heightMap) {
		int area = 0;
		if (heightMap.length < 3 || heightMap.length < 2 || heightMap.length < 1)
			return 0;
		for (int i = 1; i < heightMap.length - 1; i++) {
			area += trap(heightMap[i]);
		}
		return area;
	}

	public static void main(String[] args) {
		int height[] = { 4, 0, 1, 5 };
		// System.out.println(trap(height));
		// int num[][] = { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3,
		// 1 } };
		// int num[][] = { { 12, 13, 1, 12 }, { 13, 4, 13, 12 }, { 13, 8, 10, 12 }, {
		// 12, 13, 12, 12 },
		// { 13, 13, 13, 13 } };
		System.out.println(trap_book(height));
	}
}
