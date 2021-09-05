package array;

public class LargestSunContigousArray {

	public static int largestSum(int num[]) {
		int maxSoFar = 0;
		int maxSum = 0;
		int i;
		for(i = 0; i < num.length; i++) {
			maxSoFar += num[i];
			if(maxSoFar < 0) {
				maxSoFar = 0;
			}
			if(maxSoFar > maxSum) {
				System.out.print(num[i] + ", ");
				maxSum = Math.max(maxSoFar, maxSum);
			}
		}
		System.out.println();
		return maxSum;
	}
	
	public static void main(String[] args) {
		int num[] = { 1, -2, 3, 4, -4, 6, -4, 3, 2 };
		System.out.println(largestSum(num));
	}
}
