package sorting;

import array.reduction.Main;

public class SelectionSort {
   public static void sort(int[] num) {
      for(int i = 0; i < num.length; ++i) {
         int max = 0;

         for(int j = 1; j < num.length - i; ++j) {
            if (num[j] > num[max]) {
               max = j;
            }
         }

         Main.swap(num, max, num.length - 1 - i);
      }

   }
}
