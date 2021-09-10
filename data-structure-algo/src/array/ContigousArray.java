package array;

public class ContigousArray {

	public static int contigousArray(int num[]) {
		int currMax = 0;
		int maxSum = 0;
		for(int i = 0; i < num.length; i++) {
			currMax = Math.max(num[i], currMax + num[i]);
			if(currMax < 0)
				currMax = 0;
			if(currMax > maxSum)
				maxSum = currMax;
		}
		return maxSum;
	}
	
	public static void main(String[] args) {
		int num[] = { 4, 9, -7, -3, 2, -8, 9, -8 };
		System.out.println(contigousArray(num));
	}
}
