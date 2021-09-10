package array;

public class MinimumAbosulteDifference {

	public static int minAbsDiff(int num[]) {
		int diff = Integer.MIN_VALUE;
		if (num.length < 2)
			return -1;
		for (int i = 0; i < num.length - 1; i++) {
			System.out.println("Element is " + num[i] + " Num [i + 1] " + (num[(i + 1)] + 
					" num[i] - num[(i + 1)] " + Math.abs(num[i] - num[(i + 1)])));
			//diff = Math.min(Math.abs(num[i]), Math.abs(num[i] - num[(i + 1) % 2]));
			diff = Math.min(Math.abs(num[i]), Math.abs(num[i] - num[(i + 1)]));
		}
		return diff;
	}

	public static void main(String[] args) {
		int num[] = { 8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1 };
		int i = 0;
		/*
		 * while(i < num.length * 2) { System.out.println(num[(i + 1) % 2]); i++; }
		 */
		
		System.out.println(minAbsDiff(num));
	}
}
