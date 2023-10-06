package array;

import java.util.Arrays;

public class MinMaxSortedArray {
   public static void findMinMaxArray(int[] num) {
      int[] aux = new int[num.length];
      aux = Arrays.copyOf(num, num.length);
      int start = 0;
      int stop = num.length - 1;

      for(int i = 0; i < num.length; ++i) {
         if (i % 2 == 0) {
            num[i] = aux[stop--];
         } else {
            num[i] = aux[start++];
         }
      }

   }

   public static void findMinMaxArrayOnReverse(int[] num) {
      int b = num.length - 1;

      for(int i = 0; i < num.length; ++i) {
         reverseArry(num, i, b);
      }

   }

   private static void reverseArry(int[] num, int start, int end) {
      while(start < end) {
         int temp = num[start];
         num[start++] = num[end];
         num[end--] = temp;
      }

   }

   public static void main(String[] args) {
      int[] num = new int[]{1, 2, 3, 4, 5, 6, 8};
      findMinMaxArrayOnReverse(num);
      System.out.println(Arrays.toString(num));
   }
}
