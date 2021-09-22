package binary.search;

public class SumOfTripletLessThanVal {

	public static void sumOfTriplet(int num[], int val) {
		int start = 0;
		int end = num.length - 1;
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < num.length - 2; i++) {
			int a = num[i];
			start = i + 1;
			while (start < end) {
				int sum = ((a + num[start] + num[end]));
				if (sum >= val) {
					end--;
				} else {
					System.out.println(a + " + " + num[start] + " + " + num[end] + " = " + sum);
					start++;
				}
			}

		}
	}

	public static void main(String[] args) {
		int num[] = { -15, 11, -6, -35, -23, -2, -1, 0, 19, -91, 3, 13, 7, 8, 9, 12, 18, 82 };
		sumOfTriplet(num, 45);
	}
}
