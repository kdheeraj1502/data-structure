package array;

public class FindMedian_1 {

	public static int findMedian(int num1[], int num2[]) {
		return 0;}

	public static void main(String[] args) {
		int nums1[] = { 15, 20, 25, 35, 45, 67, 78, 89 };
		int nums2[] = { 1, 2 };
		System.out.println(findMedian(nums1, nums2));
	}

	public static int findMedian_self(int num1[], int num2[]) {
		int i = 0, j = 0, count = 0;
		int index = (num1.length + num2.length + (num1.length + num2.length) % 2) / 2;
		while (count < index - 1) {
			if (i < num1.length - 1 && num1[i] < num2[j])
				i++;
			else
				j++;
			count++;
		}
		if (num1[i] < num2[j])
			return num1[i];
		else
			return num2[j];
	}

}
