package searchingandsorting;

import java.util.Scanner;

public class roti_prata {
   public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);

      for(int t = scn.nextInt(); t > 0; --t) {
         int n = scn.nextInt();
         int s = scn.nextInt();
         int[] arr = new int[s];

         for(int i = 0; i < arr.length; ++i) {
            arr[i] = scn.nextInt();
         }

         System.out.println(prata(arr, n));
      }

   }

   public static boolean check(int[] arr, long t, int n) {
      int nop = 0;

      for(int i = 0; i < arr.length; ++i) {
         int time = arr[i];

         for(int j = 2; (long)time <= t; ++j) {
            ++nop;
            time += arr[i] * j;
         }

         if (nop >= n) {
            return true;
         }
      }

      return false;
   }

   public static long prata(int[] arr, int n) {
      long lo = 0L;
      long ans = 0L;
      long hi = (long)Math.pow(10.0, 8.0);

      while(lo <= hi) {
         long mid = lo + (hi - lo) / 2L;
         if (check(arr, mid, n)) {
            ans = mid;
            hi = mid - 1L;
         } else {
            lo = mid + 1L;
         }
      }

      return ans;
   }
}
