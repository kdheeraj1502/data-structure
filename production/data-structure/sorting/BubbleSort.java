package sorting;

import array.reduction.Main;

public class BubbleSort {
   public static void sort(int[] num) {
      int swapped = true;

      for(int i = 0; i < num.length && swapped; ++i) {
         swapped = false;

         for(int j = 0; j < num.length - i - 1; ++j) {
            if (Main.ifFirstIsGreaterThanSecond(num[j], num[j + 1])) {
               Main.swap(num, j, j + 1);
               swapped = true;
            }
         }
      }

   }
}
