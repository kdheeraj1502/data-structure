package array;

public class FindMedianSortedArray {
   public static double findMedian(int[] num1, int[] num2) {
      int[] num1Array;
      int[] num2Array;
      if (num1.length <= num2.length) {
         num1Array = num1;
         num2Array = num2;
      } else {
         num1Array = num2;
         num2Array = num1;
      }

      int mid1 = false;
      int mid2 = false;
      int start = 0;
      int end = num1Array.length;

      while(start <= end) {
         int mid1 = (start + end) / 2;
         int mid2 = (num1Array.length + num2Array.length + 1) / 2 - mid1;
         int left1 = mid1 == 0 ? Integer.MIN_VALUE : num1Array[mid1 - 1];
         int left2 = mid2 == 0 ? Integer.MIN_VALUE : num2Array[mid2 - 1];
         int right1 = mid1 == num1Array.length ? Integer.MAX_VALUE : num1Array[mid1];
         int right2 = mid2 == num2Array.length ? Integer.MAX_VALUE : num2Array[mid2];
         if (left1 <= right2 && left2 <= right1) {
            if ((num1Array.length + num2Array.length) % 2 == 0) {
               return (double)(Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            }

            return (double)Math.max(left1, left2) / 1.0;
         }

         if (left1 > right2) {
            end = mid1 - 1;
         } else {
            start = mid1 + 1;
         }
      }

      return 0.0;
   }

   public static void main(String[] args) {
      int[] num1 = new int[]{4, 6, 9, 10};
      int[] num2 = new int[]{1, 2, 3, 5, 7, 8, 34};
      System.out.println(findMedian(num1, num2));
   }
}
