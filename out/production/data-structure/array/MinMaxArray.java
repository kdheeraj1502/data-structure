package array;

import java.util.Arrays;

public class MinMaxArray {
   public static void findMinMaxArr(int[] num) {
      for(int i = 0; i < num.length; ++i) {
         reverse(num, i, num.length - 1);
      }

   }

   private static void reverse(int[] num, int i, int j) {
      while(i < j) {
         int temp = num[i];
         num[i++] = num[j];
         num[j--] = temp;
      }

   }

   public static void main(String[] args) {
      int[] num = new int[]{1, 2, 3, 4, 5, 6, 7};
      findMinMaxArr(num);
      System.out.println(Arrays.toString(num));
   }
}
