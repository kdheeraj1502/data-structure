package dp;

import java.util.Arrays;
import java.util.HashMap;

public class maxrectanglewithsum0 {
   public static void main(String[] args) {
      int[][] arr = new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {1, 8, 7, 9}, {0, 0, 0, 0}};
      solvedp(arr);
   }

   public static void solvedp(int[][] arr) {
      int[] dp = new int[arr[0].length];
      int si = 0;
      int sj = 0;
      int ei = 0;
      int ej = 0;

      int k;
      int i;
      for(k = 0; k < arr.length; ++k) {
         for(i = k; i < arr.length; ++i) {
            HashMap<Integer, Integer> map = new HashMap();
            int sum = 0;
            map.put(sum, -1);

            for(int j = 0; j < arr[0].length; ++j) {
               dp[j] += arr[i][j];
               sum += dp[j];
               if (map.containsKey(sum)) {
                  int currlength = j - (Integer)map.get(sum);
                  int currbreadth = i - k + 1;
                  int currarea = currlength * currbreadth;
                  int maxarea = (ei - si + 1) * (ej - sj + 1);
                  if (currarea > maxarea) {
                     si = k;
                     ei = i;
                     sj = (Integer)map.get(sum) + 1;
                     ej = j;
                  }
               } else {
                  map.put(sum, j);
               }
            }
         }

         Arrays.fill(dp, 0);
      }

      for(k = si; k <= ei; ++k) {
         for(i = sj; i <= ej; ++i) {
            System.out.print(arr[k][i] + " ");
         }

         System.out.println();
      }

   }
}
