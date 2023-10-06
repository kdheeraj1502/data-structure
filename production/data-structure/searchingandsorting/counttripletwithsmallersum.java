package searchingandsorting;

import java.util.Arrays;

public class counttripletwithsmallersum {
   public static void main(String[] args) {
   }

   long countTriplets(long[] arr, int n, int sum) {
      Arrays.sort(arr);
      long c = 0L;

      for(int i = 0; i < n; ++i) {
         int j = i + 1;
         int k = n - 1;
         int s = (int)((long)sum - arr[i]);

         while(j < k) {
            if (arr[j] + arr[k] < (long)s) {
               c = c + (long)k - (long)j;
               ++j;
            } else {
               --k;
            }
         }
      }

      return c;
   }
}
