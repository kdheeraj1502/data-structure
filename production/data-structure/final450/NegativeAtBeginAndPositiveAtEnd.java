package final450;

import java.util.Arrays;

public class NegativeAtBeginAndPositiveAtEnd {
   public static void shift(int[] num, int start, int end) {
      if (start < end) {
         int i = start;
         int j = end;

         while(i < j) {
            while(num[i] < 0) {
               ++i;
            }

            while(num[j] > 0) {
               --j;
            }

            if (i < j) {
               swap(num, i, j);
               ++i;
               --j;
            }

            if (i >= j) {
               break;
            }
         }

      }
   }

   private static void swap(int[] num, int i, int j) {
      int temp = num[i];
      num[i] = num[j];
      num[j] = temp;
   }

   public static void main(String[] args) {
      int[] num = new int[]{-1, 2, -3, 4, 5, 6, -7, 8, 9};
      shift(num, 0, num.length - 1);
      System.out.println(Arrays.toString(num));
   }
}
