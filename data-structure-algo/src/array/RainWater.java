package array;

public class RainWater {

	public static int rainWater(int num[]) {
		int water = 0;
		int left[] = new int[num.length];
		int right[] = new int[num.length];

		left[0] = num[0];
		int max = num[0];
		for (int i = 1; i < num.length; i++) {
			if (max < num[i]) {
				max = num[i];
			}
			left[i] = max;
		}
		right[num.length - 1] = num[num.length - 1];
		max = num[num.length - 1];
		for (int i = num.length - 2; i >= 0; i--) {
			if (max < num[i]) {
				max = num[i];
			}
			right[i] = max;
		}

		for (int i = 0; i < num.length; i++) {
			water += Math.min(left[i], right[i]) - num[i];
		}
		return water;
	}

	public static void main(String[] args) {
	//	int num[] = { 4, 0, 1, 5 };
		int num[] = { 1, 0, 0, 0 };
		//System.out.println(rainWater(num));
	 System.out.println(rainWater_book(num));
		// System.out.println(maxWater(num));
		System.out.println(rainWater_self(num));
	}

	public static int rainWater_book(int num[]) {
		int start = 0;
		int end = num.length - 1;
		int water = 0;
		int leftMax = 0;
		int rightMax = 0;
		while (start <= end) {
			if (num[start] < num[end]) {
				if (num[start] > leftMax) {
					leftMax = num[start];
				} else {
					water += leftMax - num[start];
				}
				start++;
			} else {
				if (num[end] > rightMax) {
					rightMax = num[end];
				} else {
					water += rightMax - num[end];
				}
				end--;
			}
		}
		return water;
	}

	public static int maxWater(int[] num) {
		int start = 0;
		int end = num.length - 1;
		int leftMax = 0;
		int rightMax = 0;
		int water = 0;
		while (start <= end) {
			if (rightMax <= leftMax) {
				water += Math.max(0, rightMax - num[end]);
				rightMax = Math.max(rightMax, num[end]);
				end -= 1;
			} else {
				water += Math.max(0, leftMax - num[start]);
				leftMax = Math.max(leftMax, num[start]);
				start += 1;
			}
		}
		return water;
	}

	public static int rainWater_self(int num[]) {
		int water = 0;
		int leftArray[] = new int[num.length];
		int rightArray[] = new int[num.length];
		int max = num[0];
		leftArray[0] = max;
		for (int i = 1; i < num.length; i++) {
			if (max < num[i]) {
				max = num[i];
			}
			leftArray[i] = max;
		}

		max = num[num.length - 1];
		rightArray[num.length - 1] = max;
		for (int i = num.length - 2; i >= 0; i--) {
			if (max < num[i]) {
				max = num[i];
			}
			rightArray[i] = max;
		}

		for (int i = 0; i < num.length; i++) {
			water += Math.min(leftArray[i], rightArray[i]) - num[i];
		}
		return water;
	}
}
