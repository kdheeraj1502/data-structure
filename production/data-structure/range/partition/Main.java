package range.partition;

import java.util.Arrays;

public class Main {
   public static void swap(int[] num, int a, int b) {
      int temp = num[a];
      num[a] = num[b];
      num[b] = temp;
   }

   public static boolean ifFirstIsGreaterThanSecond(int a, int b) {
      return a > b;
   }

   public static void main(String[] args) {
      int[] num = new int[]{1, 21, 2, 20, 3, 19, 4, 18, 5, 17, 6, 16, 7, 15, 8, 14, 9, 13, 10, 12, 11};
      RangePartition.rangePartition(num);
      System.out.println(Arrays.toString(num));
   }
}
