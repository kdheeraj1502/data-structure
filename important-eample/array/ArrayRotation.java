package array;

import java.util.Arrays;

public class ArrayRotation {

	public static void leftRotate(int nums[], int lr) {
		int lrNums[] = new int[lr];
		int j = lr;
		for (int i = 0; j < nums.length; i++) {
			if (i < lr) {
				lrNums[i] = nums[i];
			}
			nums[i] = nums[j++];
		}

		int k = nums.length - lr;
		j = 0;
		for (int i = k; i < nums.length; i++) {
			nums[i] = lrNums[j++];
		}
		System.out.println(Arrays.toString(nums));

	}

	public static void leftRotateTripleJump(int nums[], int lr) {
		int len = nums.length;
		int gcd = gcdCal(len, lr);
		leftRotateTripleJumpExe(nums, gcd, lr);
	}

	private static void leftRotateTripleJumpExe(int[] nums, int gcd, int lr) {
		if (gcd < lr)
			gcd = lr;
		for (int i = 0; i < gcd; i++) {
			int val = nums[i];
			int a = gcd + i;
			int b = i;
			while (a < nums.length) {
				nums[b] = nums[a];
				b = a;
				a += gcd;
			}
			nums[b] = val;
		}
		System.out.println(Arrays.toString(nums));
	}

	private static int gcdCal(int len, int lr) {
		return lr != 0 ? gcdCal(lr, len % lr) : len;
	}

	public static void main(String[] args) {
		int nums[] = { 5, 8, 2, 4, 1, 0, 3, 9, 7 };
		// {4, 1, 0, 3, 9, 7, 5, 8, 2};
		int leftRotate = 5;
		leftRotateTripleJump(nums, leftRotate);
	}
}
