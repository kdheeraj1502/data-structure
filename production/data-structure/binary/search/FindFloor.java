package binary.search;

import java.util.Arrays;

public class FindFloor {
   public static int findFloor(int[] num, int val) {
      int start = 0;
      int end = num.length - 1;
      Arrays.sort(num);
      int floor = -1;

      while(start <= end) {
         int mid = (start + end) / 2;
         if (num[mid] == val || val > num[mid] && (mid == num.length - 1 || val < num[mid + 1])) {
            floor = num[mid];
            break;
         }

         if (val > num[mid]) {
            start = mid + 1;
         } else {
            end = mid - 1;
         }
      }

      return floor;
   }

   public static void main(String[] args) {
      int[] num = new int[]{8, 11, 10, 9, 7, 15, 1, 25, 34, 1, 57, 3, 74, 76, 90};
      int[] num1 = new int[]{10, 12, 14, 19, 17, 115, 81, 45, 41, 1, 27, 23, 73, 71, 89};
      System.out.print("[ ");
      int[] var3 = num1;
      int var4 = num1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         int in = var3[var5];
         System.out.print(in + " :: " + findFloor(num, in) + ", ");
      }

      System.out.print(" ]");
   }
}
