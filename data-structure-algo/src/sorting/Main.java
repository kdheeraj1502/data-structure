package sorting;

import java.util.Arrays;

public class Main {

	public static void swap(int num[], int a, int b) {
		int temp = num[a];
		num[a] = num[b];
		num[b] = temp;
	}

	public static boolean ifFirstIsGreaterThanSecond(int a, int b) {
		return a > b ? true : false;
	}

	public static void main(String[] args) {
	//	int num[] = { 5, 1, 1, 1, 2, 3, 5 };
	//	ArrayReduction.arrayReduction(num);
		int num1[] = { 1, 5, 9, 10, 15, 20 };
		int num2[] = { 2, 3, 8, 13 };
		MergeArray.merge(num1, num2);
		
		System.out.println(Arrays.toString(num1));
		System.out.println(Arrays.toString(num2));
	}

}
