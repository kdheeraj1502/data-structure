package array;

public class FindMedianBinarySearchSelf {

	public static void main(String[] args) {
		int[] nums1 = { 1 };
		int[] nums2 = { 1 };
		System.out.println(findMedianSortedArrays(nums1, nums2));
		System.out.println(findMedianSortedArraysLeet(nums1, nums2));
	}

	private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int nums1Array[] = nums1;
		int nums2Array[] = nums2;
		if (nums1.length < nums2.length) {
			nums1Array = nums1;
			nums2Array = nums2;
		} else {
			nums1Array = nums2;
			nums2Array = nums1;
		}
		int left1 = 0;
		int left2 = 0;
		int right1 = 0;
		int right2 = 0;
		int start = 0;
		int end = nums1Array.length;
		int mid1;
		int mid2;
		while (start <= end) {
			mid1 = (start + end) / 2;
			mid2 = ((nums1Array.length + nums2Array.length  + 1) / 2) - mid1;

			left1 = mid1 == 0 ? Integer.MIN_VALUE : nums1Array[mid1 - 1];
			left2 = mid2 == 0 ? Integer.MIN_VALUE : nums2Array[mid2 - 1];

			right1 = mid1 == nums1Array.length ? Integer.MAX_VALUE : nums1Array[mid1];
			right2 = mid2 == nums2Array.length ? Integer.MAX_VALUE : nums2Array[mid2];

			if (left1 <= right2 && left2 <= right1) {
				if ((nums1Array.length + nums2Array.length) % 2 == 0) {
					return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
				} else
					return Math.max(left1, left2);
			} else if (left1 > right2) {
				end = mid1 - 1;
			} else
				start = mid1 + 1;
		}

		return 0.0;
	}
	
	public static double findMedianSortedArraysLeet(int[] nums1, int[] nums2) {
        int nums1Array[] = nums1;
        int nums2Array[] = nums2;
        if(nums1.length < nums2.length){
            nums1Array = nums1;
            nums2Array = nums2;
        }
        else{
            nums1Array = nums2;
            nums2Array = nums1;
        }
        int left1 = 0;
        int left2 = 0;
        int right1 = 0;
        int right2 = 0;
        int mid1 = 0;
        int mid2 = 0;
        int start = 0;
        int end = nums1Array.length;
        while(start <= end){
            mid1 = (start + end)/2;
            mid2 = ((nums1Array.length + nums2Array.length + 1)/2) - mid1;
            
            left1 = mid1 == 0 ? Integer.MIN_VALUE : nums1Array[mid1 - 1];
            left2 = mid2 == 0 ? Integer.MIN_VALUE : nums2Array[mid2 - 1];
            
            right1 = mid1 == nums1Array.length ? Integer.MAX_VALUE : nums1Array[mid1];
            right2 = mid2 == nums2Array.length ? Integer.MAX_VALUE : nums2Array[mid2];
            
            if(left1 <= right2 && left2 <= right1){
                if((nums1Array.length + nums2Array.length) % 2 == 0)
                    return (Math.max(left1, left2) + Math.min(right1, right2))/2.0;
                else
                     return Math.max(left1, left2);
                        
            }
            else if(left1 > right2){
                end = mid1 - 1;
            }
            else{
                start = mid1 + 1;
            }
        }
        return 0.0;
    }
}
