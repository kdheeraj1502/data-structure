package interview;

public class MaxContigousSubArray {
	
	public int maxSum(int nums[]) {
		int curr = 0;
		int max = 0;
		for(int i = 0; i < nums.length; i++) {
			curr = Math.max(curr + nums[i], nums[i]);
			if(curr < 0) {
				curr = 0;
			}
			max = Math.max(max, curr);
		}
		return max;
	}

	public static void main(String[] args) {
			int nums[] = { 1, -2, 3, 4, -5, 8 };
			MaxContigousSubArray mca = new MaxContigousSubArray();
			System.out.println(mca.maxSum(nums));
	}
}
