package searchingandsorting;

import java.io.PrintWriter;

public class ekospoj {
   public static void main(String[] args) {
      FastReader scn = new FastReader();
      int n = scn.nextInt();
      long m = scn.nextLong();
      long[] arr = new long[n];

      for(int i = 0; i < arr.length; ++i) {
         arr[i] = scn.nextLong();
      }

      cut(arr, m);
   }

   public static void cut(long[] arr, long m) {
      long lo = Long.MAX_VALUE;
      long hi = 0L;

      for(int i = 0; i < arr.length; ++i) {
         if (lo > arr[i]) {
            lo = arr[i];
         }

         if (hi < arr[i]) {
            hi = arr[i];
         }
      }

      long ans = 0L;

      while(lo <= hi) {
         long mid = lo + (hi - lo) / 2L;
         long woodcut = 0L;

         for(int i = 0; i < arr.length; ++i) {
            if (arr[i] > mid) {
               woodcut += arr[i] - mid;
            }
         }

         if (woodcut >= m) {
            if (ans < mid) {
               ans = mid;
            }

            lo = mid + 1L;
         } else {
            hi = mid - 1L;
         }
      }

      PrintWriter writer = new PrintWriter(System.out);
      writer.print(ans);
      writer.flush();
      writer.close();
   }
}
