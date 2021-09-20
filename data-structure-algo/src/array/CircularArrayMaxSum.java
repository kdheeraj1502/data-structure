package array;

public class CircularArrayMaxSum {

	static int maxSum(int arr[], int n) {
		// Compute sum of all array elements
		int cum_sum = 0;
		for (int i = 0; i < n; i++)
			cum_sum += arr[i];

		// Compute sum of i*arr[i] for
		// initial configuration.
		
		int curr_val = 0;
		for (int i = 0; i < n; i++) {
			System.out.println(
					" i " + i + " arr[i] " + arr[i] + " multiply = " + i * arr[i] + " curr_val is " + curr_val);
			curr_val += i * arr[i];
		}

		System.out.println("Sum is " + cum_sum + " and Val is " + curr_val);
		
		// Initialize result
		int res = curr_val;

		// Compute values for other iterations
		for (int i = 1; i < n; i++) {
			// Compute next value using previous
			// value in O(1) time
			int next_val = curr_val - (cum_sum - arr[i - 1]) + arr[i - 1] * (n - 1);
			System.out.println(next_val + " =  " + curr_val + " - " + " (" + cum_sum + " - " + arr[i - 1] + " ) = " + (cum_sum - arr[i - 1]) + " + "
					+ arr[i - 1] + " * ( " + n + " - " + 1 + " ) " + "= " + arr[i - 1] * (n - 1) );

			// Update current value
			curr_val = next_val;

			// Update result if required
			res = Math.max(res, next_val);
		}

		return res;
	}

	public static void main(String[] args) {
		int num[] = { 8,1, 3, 2 };
		System.out.println(maxSum(num, num.length));
	}
}
