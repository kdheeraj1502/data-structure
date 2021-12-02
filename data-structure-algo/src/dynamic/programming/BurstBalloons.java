package dynamic.programming;

// https://leetcode.com/problems/burst-balloons/

public class BurstBalloons {
	
	public static int maxCoins_1(int[] nums) {
        int arr[] = new int[nums.length + 2];
        arr[0] = arr[arr.length - 1] = 1;
        for(int i = 0; i < nums.length; i++)
            arr[i + 1] = nums[i];
        int dp[][] = new int[arr.length + 1][arr.length + 1];
        return burstbaloon(arr, dp);
    }

	public static int maxCoins(int[] nums) {
		int arr[] = new int[nums.length + 2];
		arr[0] = arr[arr.length - 1] = 1;
		for (int i = 0; i < nums.length; i++)
			arr[i + 1] = nums[i];
		int dp[][] = new int[arr.length + 1][arr.length + 1];
		return burstbaloon(arr, dp);
	}

	public static int burstbaloon(int[] arr, int[][] dp) {
		for (int gap = 2; gap < arr.length; gap++) {
			for (int left = 0, right = gap; right < arr.length; left++, right++) {
				int max = Integer.MIN_VALUE;
				for (int k = left + 1; k < right; k++) {
					int leftCost = dp[left][k];
					int rightCost = dp[k][right];
					int mc = arr[left] * arr[right] * arr[k];
					int tc = leftCost + rightCost + mc;
					max = Math.max(max, tc);
				}
				dp[left][right] = max;
			}
		}
		return dp[0][arr.length - 1];
	}
	
    private static int  burstbaloon_1(int arr[], int dp[][]){
        for(int gap = 2; gap < arr.length; gap++){
            for(int left = 0, right = gap; right < arr.length; left++, right++){
                int max = Integer.MIN_VALUE;
                for(int k = left + 1; k < right; k++){
                    int leftCost = dp[left][k];
                    int rightCost = dp[k][right];
                    int mc = arr[left] * arr[right] * arr[k];
                    int tc = leftCost + rightCost + mc;
                    max = Math.max(max, tc);
                }
                dp[left][right] = max;
            }
        }
        return dp[0][arr.length - 1];
    }

	public static void main(String[] args) {
		int nums[] = { 3, 1, 5, 8 };
		System.out.println(maxCoins(nums));
		System.out.println(maxCoins_1(nums));
	}
}
