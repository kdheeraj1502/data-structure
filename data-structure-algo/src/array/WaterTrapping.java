package array;

import java.util.Stack;

public class WaterTrapping {

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
		// int height[] = { 4, 5, 0, 3, 2, 5 };
		// System.out.println(trap(height));
		// int num[][] = { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3,
		// 1 } };
		int num[][] = { { 12, 13, 1, 12 }, { 13, 4, 13, 12 }, { 13, 8, 10, 12 }, { 12, 13, 12, 12 },
				{ 13, 13, 13, 13 } };
		System.out.println(trapRainWater(num));
	}
}
