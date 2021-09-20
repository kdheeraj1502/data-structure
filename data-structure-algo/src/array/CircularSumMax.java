package array;

public class CircularSumMax {

	public static int maxSum(int num[]) {
		int max = 0;
		int multipleVal = 0;
		int sum = 0;

		for (int i = 0; i < num.length; i++) {
			sum += num[i];
			multipleVal += (i * num[i]);
		}

		for (int i = 0; i < num.length; i++) {
			System.out.print(multipleVal + " - ");
	//		System.out.print((sum - num[i]) + (num[i] * (num.length - 1)));
	//		System.out.print( " = ");
	//		System.out.print(multipleVal - (sum - num[i]) + (num[i] * (num.length - 1)));
			System.out.print((sum - num[i]));
			System.out.print(" + ");
			System.out.print((num[i] * (num.length - 1)));
			int next = multipleVal - (sum - num[i]) + (num[i] * (num.length - 1));
			System.out.println(" Next is " + next);
			multipleVal = next;
			max = Math.max(max, next);
		}
		return max;
	}

	public static void main(String[] args) {
		int num[] = { 8, 3, 1, 2 };
		int val = maxSum(num);
		System.out.println("---------------------");
		System.out.println(val);
	}
}
