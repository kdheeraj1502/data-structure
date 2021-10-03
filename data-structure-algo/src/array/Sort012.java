package array;

import java.util.Arrays;

public class Sort012 {

	public static int[] sort(int num[]) {
		int i = 0, end = num.length - 1;
		int start = 0;
		while (i <= end) {
			if (num[i] == 0) {
				swap(num, i, start);
				i++;
				start++;
			} else if (num[i] == 2) {
				swap(num, i, end);
				end--;
			}
			else 
				i++;
		}
		return num;
	}

	static int[] sort012(int num[]) {
		int start = 0;
		int end = num.length - 1;
		int i = 0;
		while (i <= end) {
			switch (num[i]) {
			case 0: {
				swap(num, start, i);
				start++;
				i++;
				break;
			}
			case 1:
				i++;
				break;
			case 2: {
				swap(num, end, i);
				end--;
				break;
			}
			}
		}
		return num;
	}

	private static void swap(int num[], int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	public static void main(String[] args) {
		int num[] = { 2, 0, 2, 0, 0, 1, 2, 2, 2, 1, 1, 0, 1, 1, 1, 2, 0, 1, 2, 1, 0, 1, 2, 0, 0, 0, 2, 0, 1, 0, 0, 0, 1,
				2, 1, 1, 1, 2, 1, 2, 1, 2, 2, 1, 1, 2, 0, 2, 0, 0, 1, 2, 1, 2, 1, 1, 2, 1, 2, 0, 0, 1, 0, 2, 1, 1, 2, 0,
				2, 0, 1, 2, 2, 2, 2, 1, 0, 1, 2, 2, 0, 1 };

		System.out.println(Arrays.toString(sort(num)));
		System.out.println(Arrays.toString(sort012(num)));
	}
}
