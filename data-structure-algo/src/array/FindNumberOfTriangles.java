package array;

import java.util.Arrays;

public class FindNumberOfTriangles {

	public static int numberOfTriangles(int num[]) {
		Arrays.sort(num);
		int start;
		int end;
		int i;
		int count = 0;
		for (i = num.length - 1; i > 0; i--) {
			start = 0;
			end = i - 1;
			int a = num[i];
			while (start < end) {
				int b = num[start];
				int c = num[end];
				int sum = b + c;
				if (sum > a) {
					System.out.println("Triplet : " + num[i] + " < " + num[start] + " + " + num[end]);
					count++;
					end--;
				} else {
					start++;
				}
			}
		}
		return count;
	}

	static void countTriangles(int[] A) {
		Arrays.sort(A);
		int count = 0;
		for (int i = A.length - 1; i >= 1; i--) {
			int start = 0, end = i - 1;
			while (start < end) {
				if (A[start] + A[end] > A[i]) {
					//count += end - start;
					count++;
					System.out.println("Triplet : " + A[i] + " < " + A[start] + " + " + A[end]);
					// checking for more possible solutions
				//	start++;
				}
				//} else // if not possible check for
					// higher values of arr[l]
					start++;
			}
		}
		System.out.print("No of possible solutions: " + count);
	}
	
	static void countTrianglesBook(int[] num) {
		int i, j, k, count = 0;
		Arrays.sort(num);
		for(i  = 0; i < num.length - 2; i++) {
			k = i + 2;
			for(j = i + 1; j < num.length - 1; j++) {
				while(k < num.length && num[i] + num[j] > num[k]) {
					System.out.println("Triplet : " + num[k] + " < " + num[i] + " + " + num[j]);
					k++;
					count += k -j - i;
				}
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		int num[] = { 1, 2, 3, 4, 5 };
		// 1 = 2 + 5;
		// 1 = 2 + 4;
		// 1 = 3 + 5;
		int count = numberOfTriangles(num);
		System.out.println(count);
		countTriangles(num);
		System.out.println();
		countTrianglesBook(num);
	}
}
