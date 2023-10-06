package greedy;

import java.util.Arrays;

public class smallestsubsetwithgrtrsum {
   public static void main(String[] args) {
      int[] arr = new int[]{1, 1, 1, 1, 1, 1};
      sum(arr);
   }

   public static void sum(int[] arr) {
      int sum = 0;

      int l;
      for(l = 0; l < arr.length; ++l) {
         sum += arr[l];
      }

      Arrays.parallelSort(arr);
      l = 0;
      int subsetsum = 0;

      for(int i = arr.length - 1; i >= 0 && subsetsum <= sum / 2; --i) {
         subsetsum += arr[i];
         ++l;
      }

      System.out.println(subsetsum + " " + l);
   }
}
