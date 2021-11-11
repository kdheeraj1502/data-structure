package array;

// In the array find the minimum missing positive number
// For example in array { 1, 3, 4, 6 } 2 is the minimum missing number
// For example in array { 3, 4, -1, 1 } 2 is the minimum missing number
// For example in array { 7, 8, 9, 11, 12 } 1 is the minimum missing number
public class FirstMissingPositiveNumber {

	// Take auxilary array to store the count of the number
	// for example in aux[2] will have 1 as value bcz aux[2] is third index of array
	// And in input array we have 3 hence at aux[2] we set value 1 if we find again
	// then make it 2
	public static int firstMissingPositive(int[] nums) {
		int aux[] = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			/// the number has to be positive the number has to be smaller than aux array length
			if (nums[i] > 0 && nums[i] < aux.length) {
				aux[nums[i] - 1]++;
			}
		}
		// Now loop in aux array from index 0 at index 0 we must find value 1 else 1 is
		// missing
		// then on index 2, 3, 4 etc to find the missing number
		// If the input array starts from aux length higher forst value then 1 is the
		// smallest missing number
		for (int i = 0; i < aux.length; i++) {
			if (aux[i] == 0) {
				return i + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int nums[] = { 3, 1, 0 }; // output 2
		int nums1[] = { 3, 4, -1, 1 }; // output 2
		int nums2[] = { 7, 8, 9, 11, 12 }; // output 1
		/// System.out.println("Smallest missing positive number is " +
		/// firstMissingPositive(nums));
		// System.out.println("Smallest missing positive number is " +
		/// firstMissingPositive(nums1));
		System.out.println("Smallest missing positive number is " + firstMissingPositive(nums2));
	}
}
