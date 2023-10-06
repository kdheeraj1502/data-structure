package sorting;

import array.reduction.Main;

public class QuickSort {
   public static void sort(int[] num) {
      quickSort(num, 0, num.length - 1);
   }

   private static void quickSort(int[] num, int low, int high) {
      if (low < high) {
         int mid = (low + high) / 2;
         int pivot = num[mid];
         int i = low;
         int j = high;

         while(i <= j) {
            while(num[i] < pivot) {
               ++i;
            }

            while(num[j] > pivot) {
               --j;
            }

            if (i <= j) {
               Main.swap(num, i, j);
               ++i;
               --j;
            }
         }

         if (low < j) {
            quickSort(num, low, j);
         }

         if (high > i) {
            quickSort(num, i, high);
         }

      }
   }
}
