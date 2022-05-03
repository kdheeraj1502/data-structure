package dynamic.programming.another;

public class minjumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] arr = { 2, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		int arr[] = { 2, 1, 4, 2, 5, 7, 2, 5, 3, 6, 8 };
//		int arr[] = { 12, 1, 4, 2, 5, 7, 2, 5, 3, 6, 8 };
//		int[] arr = { 1, 4, 3, 2, 6, 7 };
//		int[] arr = { 1, 1, 2, 2, 6, 7 };
		System.out.println(minJumps(arr, arr.length));
		System.out.println(minJumps_leetcode(arr, arr.length));
		// solvedp(arr);
		// System.out.println(solveopti(arr));

	}

	// O(n^2) -> time
	public static void solvedp(int[] arr) {

		int[] dp = new int[arr.length];

		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] + i >= arr.length - 1) {
				dp[i] = 1;
			} else {
				int min = Integer.MAX_VALUE;
				for (int j = i + 1; j <= i + arr[i]; j++) {
					if (min > dp[j]) {
						min = dp[j];
					}
				}
				dp[i] = min + 1;
			}
		}

		for (int i = 0; i < dp.length; i++) {
			// System.out.print(dp[i] + " ");
		}
		System.out.println();
		if (dp[0] < 0) {
			// System.out.println(-1);
		} else {
			// System.out.println(dp[0]);
		}

	}

	// O(n) -> time
	public static int solveopti(int[] arr) {

		int steps = arr[0], minjumps = 1, maxreachidx = arr[0];
		if (arr[0] == 0) {
			return -1;
		}
		for (int i = 1; i < arr.length; i++) {
			if (i == arr.length - 1) {
				return minjumps;
			}
			maxreachidx = Math.max(maxreachidx, arr[i] + i);
			steps--;
			if (steps == 0) {
				if (i >= maxreachidx)
					return -1;
				minjumps++;
				steps = maxreachidx - i;
			}
		}

		return -1;

	}
//2, 1, 4, 2, 5, 7, 2, 5, 3, 6, 8
	private static int minJumps(int[] nums, int n) {
		int jumps[] = new int[n];
		int i, j;
		if (n == 0 || nums[0] == 0)
			return Integer.MAX_VALUE;
		jumps[0] = 0;
		for (i = 1; i < n; i++) {
			jumps[i] = Integer.MAX_VALUE;
			for (j = 0; j < i; j++) {
				System.out.println("If i == " + i + " is <= j : " + j + " + nums[" + j + "] : "+ nums[j] + " == " + (j + nums[j]));
				if (i <= j + nums[j] && jumps[j] != Integer.MAX_VALUE) {
					System.out.println("(j + nums[" + j + "]) :: " + "(" + j + " + " + nums[j] + ") == " + (j + nums[j]));
					System.out.println("(jumps[" + j + "] + 1) :: " + jumps[j] + " + 1 " + " === " + (jumps[j] + 1));
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
					System.out.println("(jumps[" + i + "] = " + jumps[i] + " )");
					System.out.println("---------------------------------------------------------------");
					break;
				}
			}
		}
		return jumps[n - 1];
	}

	//2, 1, 4, 2, 5, 7, 2, 5, 3, 6, 8
	private static int minJumps_leetcode(int[] nums, int n) {
		int currEnd = 0;
		int farthest = 0;
		int jumps = 0;
		for(int i = 0; i < nums.length - 1; i++) {
			farthest = Math.max(farthest, i + nums[i]);
			if(i == currEnd) {
				jumps++;
				currEnd = farthest;
			}
		}
		
		return jumps;
	}
}
