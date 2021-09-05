package array;

public class FindMedianBinarySearch {
	public static void main(String[] args) {
		int[] nums1 = { 1 };
		int[] nums2 = { 1 };
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
	//	if (nums1.length > nums2.length)
		//	return findMedianSortedArrays(nums2, nums1);

		int num1Len = nums1.length;
		int num2Len = nums2.length;
		int start = 0, end = num1Len;
		while (start <= end) {
			int mid1 = (end + start) / 2;
			int mid2 = ((num1Len + num2Len + 1) / 2) - mid1;

			int left1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
			int left2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];

			int right1 = mid1 == num1Len ? Integer.MAX_VALUE : nums1[mid1];
			int right2 = mid2 == num2Len ? Integer.MAX_VALUE : nums2[mid2];

			if (left1 <= right2 && left2 <= right1) {
				if ((num1Len + num2Len) % 2 == 0)
					return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
				else
					return Math.max(left1, left2) / 1.0;
			} else if (left1 > right2) {
				end = mid1 - 1;
			} else {
				start = mid1 + 1;
			}

		}
		return 0.0;
	}
	/*
	 * public static int[] merge(int[] a, int[] b) {
	 * 
	 * int[] answer = new int[a.length + b.length]; int i = 0, j = 0, k = 0;
	 * 
	 * while (i < a.length && j < b.length) answer[k++] = a[i] < b[j] ? a[i++] :
	 * b[j++];
	 * 
	 * while (i < a.length) answer[k++] = a[i++];
	 * 
	 * while (j < b.length) answer[k++] = b[j++];
	 * 
	 * return answer; }
	 */

}
