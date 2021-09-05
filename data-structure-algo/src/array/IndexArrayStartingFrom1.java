package array;

import java.util.Arrays;

public class IndexArrayStartingFrom1 {

	public static void orderNum(int num[]) {
		int curr, value, next;
		for (int i = 0; i < num.length; i++) {
			curr = i;
			value = -1;
			while (curr >= 0 && curr < num.length && num[curr] != curr + 1) {
				next = num[curr];
				num[curr] = value;
				value = next;
				curr = next - 1;
			}
		}
	}

	public static void main(String[] args) {
		int num[] = { 8, 5, 6, 1, -1, 3, 2, 7, 4, 10};
		orderNum(num);
		System.out.println(Arrays.toString(num));
	}
}
