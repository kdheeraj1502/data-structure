package sorting;

import array.reduction.Main;

public class MinimusSwapRequired {
   public static int swapRequired(int[] num) {
      return swapRequired(num, 7);
   }

   private static int swapRequired(int[] num, int key) {
      int a = 0;
      int b = num.length - 1;
      int swapCount = 0;

      while(a <= b) {
         if (num[a] < key) {
            ++a;
         } else if (num[b] > key) {
            --b;
         } else {
            Main.swap(num, a, b);
            ++swapCount;
            ++a;
            --b;
         }
      }

      return swapCount;
   }
}
