package greedy;

import java.util.Arrays;

public class maxsumarr {
   public static void main(String[] args) {
   }

   int Maximize(int[] arr, int n) {
      int mod = (int)(Math.pow(10.0, 9.0) + 7.0);
      Arrays.sort(arr);
      long sum = 0L;

      for(int i = 0; i < n; ++i) {
         sum = (sum + (long)arr[i] * (long)i) % (long)mod;
      }

      return (int)sum;
   }
}
