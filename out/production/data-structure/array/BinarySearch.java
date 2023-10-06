package array;

public class BinarySearch {
   public static int search(int[] num, int a) {
      int start = 0;
      int end = num.length;

      while(start < end) {
         int mid = (start + end) / 2;
         if (num[mid] == a) {
            return mid;
         }

         if (num[mid] > a) {
            end = mid - 1;
         } else {
            start = mid + 1;
         }
      }

      return -1;
   }
}
