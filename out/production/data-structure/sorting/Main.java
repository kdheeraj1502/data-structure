package sorting;

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
      int[] num1 = new int[]{1, 5, 9, 10, 15, 20};
      int[] num2 = new int[]{2, 3, 8, 13};
      MergeArray.merge(num1, num2);
      System.out.println(Arrays.toString(num1));
      System.out.println(Arrays.toString(num2));
   }
}
