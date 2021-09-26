package bit.masking;

public class XOROfSubarray {
	static int getTotalXorOfSubarrayXors(int arr[], int N) {

// if even number of terms are
// there, all numbers will appear
// even number of times. So result is 0.
		if (N % 2 == 0)
			return 0;

// else initialize result
// by 0 as (a xor 0 = a)
		int res = 0;
		for (int i = 0; i < N; i += 2)
			res ^= arr[i];

		return res;
	}

// Driver Code
	public static void main(String[] args) {
		int arr[] = { 3, 5, 2, 4, 6, 7 };
		int N = arr.length;

		System.out.println(getTotalXorOfSubarrayXors(arr, N));
	}
}