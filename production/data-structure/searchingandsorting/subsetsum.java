package searchingandsorting;

import java.util.Arrays;

public class subsetsum {
   public static void main(String[] args) {
      long[] arr = new long[]{1L, 2L};
      solve(arr, -1L, 2L, arr.length);
   }

   public static void solve(long[] arr, long a, long b, int n) {
      long[] sum1 = subsets(arr, 0, n / 2 - 1);
      long[] sum2 = subsets(arr, n / 2, n - 1);
      Arrays.parallelSort(sum2);

      int i;
      for(i = 0; i < sum1.length; ++i) {
         System.out.println(sum1[i]);
      }

      System.out.println();

      for(i = 0; i < sum2.length; ++i) {
         System.out.println(sum2[i]);
      }

      System.out.println();
      long c = 0L;

      for(int i = 0; i < sum1.length; ++i) {
         long lower = a - sum1[i];
         long upper = b - sum1[i];
         int lb = lower_bound(sum2, lower);
         int ub = upper_bound(sum2, upper);
         System.out.println(ub + " - " + lb);
         c += (long)(ub - lb + 1);
      }

      System.out.println();
      System.out.println(c);
   }

   public static int upper_bound(long[] arr, long k) {
      int s = 0;
      int e = arr.length - 1;

      while(s != e) {
         int mid = s + e >> 1;
         if (arr[mid] <= k) {
            s = mid + 1;
         } else {
            e = mid;
         }
      }

      if (s == arr.length) {
         return -1;
      } else {
         return s;
      }
   }

   public static int lower_bound(long[] arr, long k) {
      int s = 0;
      int e = arr.length - 1;

      while(s != e) {
         int mid = s + e >> 1;
         if (arr[mid] < k) {
            s = mid + 1;
         } else {
            e = mid;
         }
      }

      if (s == arr.length) {
         return -1;
      } else {
         return s;
      }
   }

   private static long[] subsets(long[] arr, int start, int end) {
      int limit = 1 << end - start + 1;
      long[] ans = new long[limit];

      for(int i = 0; i < limit; ++i) {
         int sum = 0;
         int temp = i;

         for(int j = end; j >= start; --j) {
            if ((temp & 1) == 1) {
               sum = (int)((long)sum + arr[j]);
            }

            temp >>= 1;
         }

         ans[i] = (long)sum;
      }

      return ans;
   }
}
