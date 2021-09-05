package array;

import java.util.Arrays;

public class ArithmeticProgressionTriplet_2MultiplyA_EqualsBplusC {

	public static void APTriplet(int num[]) {
		int i, j, k;
		for (i = 1; i < num.length; i++) {
			j = i - 1;
			k = i + 1;
			while (j >= 0 && k < num.length) {
				if (num[j] + num[k] == 2 * num[i]) {
					System.out.println("Triplet : " + num[j] + ", 2 * num[i] is " + 2 * num[i] + ", " + num[k]);
					k++;
					j--;
				} else if (num[j] + num[k] < 2 * num[i]) {
					k++;
				} else
					j--;

			}
		}
	}
	
	public static void APTripletSelf(int num[]) {
		Arrays.sort(num);
		int start;
		int end;
		for (int i = 0; i < num.length; i++) {
			start = 0;
			end = num.length - 1;
			//[-5, -4, 0, 1, 2, 3, 5, 7, 8, 12]
			while(start < end) {
				if (num[start] + num[end] == 2 * num[i]) {
					System.out.println("Triplet : " + ", 2 * " + num[i] + " = " + num[start] + " + " + num[end]);
					start++;
					end--;
				}
				else if (num[start] + num[end] < 2 * num[i]) {
					start++;
				} else
					end--;
			}
		}
	}
	
	public static void main(String[] args) {
		int num[] = { 2, 7, 3, 5, -5, 8, -4, 1, 0, 12 };
		APTriplet(num);
		System.out.println("-----------------------------------------------------------");
		APTripletSelf(num);
	}
}
