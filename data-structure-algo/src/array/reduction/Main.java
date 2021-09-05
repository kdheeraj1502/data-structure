package array.reduction;

import sorting.MergeArray;

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
	}

}
