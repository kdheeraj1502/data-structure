package array;

import java.util.Arrays;

public class RemoveDuplicate {

	public static int[] remove(int num[]) {
		Arrays.sort(num);
		int j = 0;
		for (int i = 1; i < num.length; i++) {
			if (num[i] != num[j]) {
				j++;
				num[j] = num[i];
			}
		}
		return Arrays.copyOf(num, j + 1);
	}

	public static void main(String[] args) {
		int num[] = { 1, 1, 2, 2, 2, 3, 4, 4, 5, 7, 7, 8 };
		int res[] = remove(num);
		System.out.println(Arrays.toString(res));
	}
}
