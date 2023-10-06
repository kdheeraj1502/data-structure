package dp;

import java.util.Arrays;

public class sumpairwithdiff {
   public static void main(String[] args) {
   }

   public static int maxSumPairWithDifferenceLessThanK(int[] arr, int N, int K) {
      if (N == 1) {
         return arr[0] < K ? arr[0] : 0;
      } else {
         Arrays.sort(arr);
         int ans = 0;
         int i = N - 1;

         while(true) {
            while(i >= 0) {
               if (i - 1 >= 0 && arr[i] - arr[i - 1] < K) {
                  ans += arr[i] + arr[i - 1];
                  i -= 2;
               } else {
                  --i;
               }
            }

            return ans;
         }
      }
   }
}
