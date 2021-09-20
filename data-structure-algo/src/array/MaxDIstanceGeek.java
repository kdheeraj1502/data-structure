package array;

public class MaxDIstanceGeek {

	public static int maxIndexDiff(int arr[], int n) {
		int maxDiff;
		int i, j;

		int RMax[] = new int[n];
		int LMin[] = new int[n];

		/*
		 * Construct LMin[] such that LMin[i] stores the minimum value from (arr[0],
		 * arr[1], ... arr[i])
		 */
		LMin[0] = arr[0];
		for (i = 1; i < n; ++i)
			LMin[i] = Math.min(arr[i], LMin[i - 1]);

		/*
		 * Construct RMax[] such that RMax[j] stores the maximum value from (arr[j],
		 * arr[j+1], ..arr[n-1])
		 */
		RMax[n - 1] = arr[n - 1];
		for (j = n - 2; j >= 0; --j)
			RMax[j] = Math.max(arr[j], RMax[j + 1]);

		/*
		 * Traverse both arrays from left to right to find optimum j - i This process is
		 * similar to merge() of MergeSort
		 */
		//33, 9, 9, 3, 2, 2, 2, 2, 2
		//60, 60, 60, 60, 60, 60, 33, 33, 11
		i = 0;
		j = 0;
		maxDiff = -1;
		while (j < n && i < n) {
			if (LMin[i] <= RMax[j]) {
				maxDiff = Math.max(maxDiff, j - i);
				j = j + 1;
			} else
				i = i + 1;
		}

		return maxDiff;
	}
	
	
	public static int maxDiff(int num[]) {
		int maxDiff = -1;
		int leftMin[] = new int[num.length];
		int rightMax[] = new int[num.length];
		leftMin[0] = num[0];
		for(int i = 1; i < num.length; i++) {
			leftMin[i] = Math.min(num[i], leftMin[i - 1]);
		}
		rightMax[num.length - 1] = num[num.length - 1];
		for(int i = num.length - 2; i >=0; i--) {
			rightMax[i] = Math.max(num[i], rightMax[i + 1]);
		}
		
		int i = 0, j = 0;
		//33, 9, 9, 3, 2, 2, 2, 2, 2
		//60, 60, 60, 60, 60, 60, 33, 33, 11
		while(i < num.length && j < num.length) {
			if(leftMin[i] <= rightMax[j]) {
				maxDiff = Math.max(maxDiff, j - i);
				j++;
			}
			else {
				i++;
			}
		}
		return maxDiff;
	}

	public static void main(String[] args) {
		int num[] = { 33, 9, 10, 3, 2, 60, 30, 33, 11 };
	//	System.out.println(maxIndexDiff(num, num.length));
		System.out.println(maxDiff(num));
	}
}
