package array;

import java.util.Arrays;

public class RemoveDuplicates {
   public static int[] remove(int[] num) {
      Arrays.sort(num);
      int j = 0;

      for(int i = 1; i < num.length; ++i) {
         System.out.println(num[i] + " " + num[j]);
         if (num[i] != num[j]) {
            ++j;
            num[j] = num[i];
         }

         System.out.println(Arrays.toString(num));
      }

      return Arrays.copyOf(num, j + 1);
   }

   public static void main(String[] args) {
      int[] num = new int[]{2, 7, 6, 3, 4, 1, 1, 2, 9, 4, 8, 1, 3, 9, 5};
      System.out.println(Arrays.toString(remove(num)));
   }
}
