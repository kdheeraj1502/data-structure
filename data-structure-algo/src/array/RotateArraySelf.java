package array;

import java.util.Arrays;

public class RotateArraySelf {
	
	public static void rotateArray(int num[], int k) {
		reverse(num, 0, k - 1);
		reverse(num, k, num.length - 1);
		reverse(num, 0, num.length - 1);
	}
	
	public static void reverse(int num[], int i, int j) {
		while(i < j) {
			int temp = num[i];
			num[i++] = num[j];
			num[j--] = temp;
		}
	}

	public static void main(String[] args) {
		int num[] = {  10, 20, 30, 40, 50, 60 };
		rotateArray(num, 3);
		System.out.println(Arrays.toString(num));
	}
}
