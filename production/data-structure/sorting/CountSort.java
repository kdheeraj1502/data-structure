package sorting;

public class CountSort {
   public static void sort(int[] num) {
      sort(num, 100);
   }

   public static void sort(int[] num, int maxVal) {
      int[] aux = new int[maxVal + 1];

      int i;
      for(i = 0; i < num.length; ++i) {
         ++aux[num[i]];
      }

      int j = 0;

      for(i = 0; i < aux.length; ++i) {
         for(int val = aux[i]; val > 0; --val) {
            num[j++] = i;
         }
      }

   }
}
