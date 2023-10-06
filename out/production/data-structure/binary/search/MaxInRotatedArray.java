package binary.search;

public class MaxInRotatedArray {
   public static int maxInRotatedArray(int[] num, int low, int high) {
      int max = true;
      int mid = low + (high - low) / 2;
      if (high == low) {
         return num[low];
      } else if ((mid == 0 || num[mid] > num[mid + 1]) && (mid == num.length - 1 || num[mid] > num[mid - 1])) {
         return num[mid];
      } else {
         int max;
         if (num[low] > num[mid]) {
            max = maxInRotatedArray(num, low, mid - 1);
         } else {
            max = maxInRotatedArray(num, mid + 1, high);
         }

         return max;
      }
   }

   public static void main(String[] args) {
      int[] num = new int[]{90, 8, 11, 15, 25, 34, 57, 74, 76};
      System.out.println(maxInRotatedArray(num, 0, num.length - 1));
   }
}
