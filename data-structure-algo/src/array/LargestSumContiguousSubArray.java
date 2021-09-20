package array;

public class LargestSumContiguousSubArray {
	
	public static int largestSun(int num[]) {
		int maxSum = 0;
		int currSum = 0;
		for(int i = 0; i < num.length; i++) {
			currSum = (currSum + num[i]);
			if(currSum < 0) {
				currSum = 0;
			}
			maxSum = Math.max(maxSum, currSum);
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int num[] = { 1, -2, 3, 4, -4, 6, -4, 3, 2 };
		System.out.println(largestSun(num));
	}
}
