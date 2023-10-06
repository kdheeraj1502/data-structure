package greedy;

import java.util.Arrays;

public class arrangeamplifiers {
   public static void main(String[] args) {
      FastReader scn = new FastReader();

      for(int t = scn.nextInt(); t > 0; --t) {
         int n = scn.nextInt();
         long[] arr = new long[n];
         int count1 = 0;

         for(int i = 0; i < arr.length; ++i) {
            arr[i] = scn.nextLong();
            if (arr[i] == 1L) {
               ++count1;
            }
         }

         solve(arr, count1);
      }

   }

   private static void solve(long[] arr, int count1) {
      Arrays.parallelSort(arr);

      int i;
      for(i = 0; i < count1; ++i) {
         System.out.print(arr[i] + " ");
      }

      if (arr.length - count1 == 2 && arr[count1] == 2L && arr[count1 + 1] == 3L) {
         System.out.print(arr[count1] + " " + arr[count1 + 1]);
      } else {
         for(i = arr.length - 1; i >= count1; --i) {
            System.out.print(arr[i] + " ");
         }
      }

      System.out.println();
   }
}
