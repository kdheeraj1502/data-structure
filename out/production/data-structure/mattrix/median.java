package mattrix;

import java.util.Arrays;

public class median {
   public static void main(String[] args) {
      int[][] m = new int[][]{{2, 2, 6, 11, 11, 11, 14, 19, 19}, {2, 8, 12, 13, 14, 15, 16, 17, 19}, {1, 2, 5, 6, 12, 13, 18, 20, 20}, {5, 5, 10, 11, 12, 15, 17, 17, 20}, {4, 5, 6, 9, 9, 11, 12, 17, 17}, {2, 4, 6, 10, 12, 14, 18, 18, 19}, {3, 3, 8, 8, 11, 13, 14, 15, 18}, {4, 7, 10, 15, 16, 17, 18, 19, 20}, {1, 1, 2, 10, 11, 12, 16, 17, 19}, {1, 1, 2, 5, 9, 10, 12, 16, 18}, {4, 6, 7, 8, 13, 14, 15, 15, 18}};
      print(m);
   }

   public static void print(int[][] m) {
      int[] arr = new int[m.length * m[0].length];
      int k = 0;

      int i;
      for(i = 0; i < m.length; ++i) {
         for(int j = 0; j < m[0].length; ++j) {
            arr[k++] = m[i][j];
         }
      }

      Arrays.sort(arr);

      for(i = 0; i < arr.length; ++i) {
         System.out.println(i + " -- " + arr[i]);
      }

   }

   public static int median(int[][] m) {
      int k = (m.length * m[0].length + 1) / 2;
      int lo = Integer.MAX_VALUE;
      int hi = Integer.MIN_VALUE;

      int mid;
      for(mid = 0; mid < m.length; ++mid) {
         if (lo > m[mid][0]) {
            lo = m[mid][0];
         }

         if (hi < m[mid][m[0].length - 1]) {
            hi = m[mid][m[0].length - 1];
         }
      }

      while(lo < hi) {
         mid = lo + (hi - lo) / 2;
         int j = m[0].length - 1;
         int count = 0;

         for(int i = 0; i < m.length; ++i) {
            while(j >= 0 && m[i][j] > mid) {
               --j;
            }

            count += j + 1;
         }

         if (count < k) {
            lo = mid + 1;
         } else {
            hi = mid;
         }
      }

      return lo;
   }
}
