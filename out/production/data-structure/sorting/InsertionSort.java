package sorting;

public class InsertionSort {
   public static void sort(int[] num) {
      for(int i = 1; i < num.length; ++i) {
         int temp = num[i];

         int j;
         for(j = i; j > 0 && num[j - 1] > temp; --j) {
            num[j] = num[j - 1];
         }

         num[j] = temp;
      }

   }
}
