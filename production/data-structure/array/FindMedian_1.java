package array;

public class FindMedian_1 {
   public static int findMedian(int[] num1, int[] num2) {
      return 0;
   }

   public static void main(String[] args) {
      int[] nums1 = new int[]{15, 20, 25, 35, 45, 67, 78, 89};
      int[] nums2 = new int[]{1, 2};
      System.out.println(findMedian(nums1, nums2));
   }

   public static int findMedian_self(int[] num1, int[] num2) {
      int i = 0;
      int j = 0;
      int count = 0;

      for(int index = (num1.length + num2.length + (num1.length + num2.length) % 2) / 2; count < index - 1; ++count) {
         if (i < num1.length - 1 && num1[i] < num2[j]) {
            ++i;
         } else {
            ++j;
         }
      }

      if (num1[i] < num2[j]) {
         return num1[i];
      } else {
         return num2[j];
      }
   }
}
