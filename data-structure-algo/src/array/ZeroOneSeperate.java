package array;

import java.util.Arrays;

import sorting.Main;

public class ZeroOneSeperate {

	public static void zeroOneSeperate(int num[]) {
		int start= 0;
		int end = num.length - 1;
		int i = 0;
		while(start < end) {
			
			while(num[start] % 2 == 0)
				start++;
			while(num[end] % 2 != 0)
				end--;
			if(start < end) {
				Main.swap(num, start, end);
				start++;
				end--;
			}
		}
	}
	public static void main(String[] args) {
		int num[] = { 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1 };
		zeroOneSeperate(num);
		System.out.println(Arrays.toString(num));
	}
}
