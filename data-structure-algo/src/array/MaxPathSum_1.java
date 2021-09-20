package array;

public class MaxPathSum_1 {

	
	public static int maxSum(int num1[], int num2[]) {
		int sum1 = 0;
		int sum2 = 0;
		int maxSum = 0;
		int i = 0; int j = 0;
		
		while(i < num1.length && j < num2.length) {
			if(num1[i] < num2[j]) {
				sum1 += num1[i++];
			}
			else if(num1[i] > num2[j]) {
				sum2 += num2[j++];
			}
			else if(num1[i] == num2[j]) {
				maxSum += Math.max(sum1, sum2);
				maxSum += num1[i];
				sum1 = 0;
				sum2 = 0;
				i++;
				j++;
			}
		}
		
		while(i < num1.length) {
			sum1 += num1[i++];
		}
		while(j < num2.length) {
			sum2 += num2[j++];
		}
		maxSum += Math.max(sum1, sum2);
		
		return maxSum;
	}
	
	public static void main(String[] args) {
		int num1[] = { 12, 13, 18, 20, 22, 26, 70 };
		int num2[] = { 11, 15, 18, 19, 20, 26, 30, 31 };
		
		System.out.println(maxSum(num1, num2));
	}
}
