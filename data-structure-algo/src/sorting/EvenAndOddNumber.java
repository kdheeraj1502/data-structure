package sorting;

import array.reduction.Main;

public class EvenAndOddNumber {

	public static void evenAndOddNumber(int num[]) {
		int a = 0;
		int b = num.length - 1;
		while(a <= b) {
			while(num[a] % 2 == 0) {
				a++;
			}
			while(num[b] % 2 != 0) {
				b--;
			}
			if(a <= b) {
				Main.swap(num, a, b);
				a++;
				b--;
			}
		}
	}
}
