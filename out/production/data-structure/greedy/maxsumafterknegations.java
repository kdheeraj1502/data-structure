package greedy;

import java.util.Arrays;

public class maxsumafterknegations {
   public static void main(String[] args) {
   }

   public static long maximizeSum(long[] arr, int n, int k) {
      Arrays.sort(arr);
      int c = 0;

      int left;
      for(left = 0; left < n && c != k; ++left) {
         if (arr[left] < 0L) {
            ++c;
            arr[left] *= -1L;
         }
      }

      if (c != k) {
         Arrays.sort(arr);
         left = k - c;
         if (left % 2 != 0) {
            arr[0] *= -1L;
         }
      }

      long sum = 0L;

      for(int i = 0; i < n; ++i) {
         sum += arr[i];
      }

      return sum;
   }
}
