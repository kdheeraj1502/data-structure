package array;

public class FIndMissingElement {

	public static int findMissing(int nums[]) {
		int xor = 0;
		for(int i = 1; i < 10; i++) {
			System.out.println("Value of Array is : " + nums[i - 1] + ", And Value of i is " + i);
			xor ^= (nums[i - 1] ^ i);
		}
		System.out.println();
		
		xor ^= 10;
		
//		for(int i = 0; i < nums.length; i++) {
//			xor ^= nums[i];
//		}
		
		return xor;
	}
	
	public static void main(String[] args) {
		int nums[] = { 1, 2, 3, 4, 5, 7, 6, 8, 9 };
		//System.out.println(findMissing(nums));
		System.out.println(findMissing_1(nums, 1, 10));
	}
	
	public static int findMissing_1(int nums[], int start, int size) {
		int xor = 0;
		for(int i = start; i < size; i++) {
			xor ^= nums[i - 1] ^ i;
		}
		
		xor ^=  size;
		return xor;
	}
}
