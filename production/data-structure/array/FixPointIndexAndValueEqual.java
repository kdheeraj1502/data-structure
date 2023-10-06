package array;

public class FixPointIndexAndValueEqual {
   public static int fixPoint(int[] num) {
      int start = 0;
      int end = num.length;

      while(start < end) {
         int mid = (start + end) / 2;
         if (num[mid] == mid) {
            return mid;
         }

         if (num[mid] < mid) {
            start = mid + 1;
         } else {
            end = mid - 1;
         }
      }

      return -1;
   }

   public static void main(String[] args) {
      int[] num = new int[]{1, 1, 2, 3, 4, 5};
      System.out.println(fixPoint(num));
   }
}
