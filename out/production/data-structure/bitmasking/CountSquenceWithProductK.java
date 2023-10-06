package bitmasking;

import java.util.ArrayList;

public class CountSquenceWithProductK {
   public static void main(String[] args) {
      int[] arr = new int[]{1, 2, 3, 4};
      System.out.println(solverecursive(arr, 0, new ArrayList(), 8));
      solvedp(arr, 8);
   }

   public static int solverecursive(int[] arr, int i, ArrayList<Integer> ans, int k) {
      int prod;
      if (i != arr.length) {
         int myans = 0;
         ans.add(arr[i]);
         prod = myans + solverecursive(arr, i + 1, ans, k);
         ans.remove(ans.size() - 1);
         prod += solverecursive(arr, i + 1, ans, k);
         return prod;
      } else {
         prod = 1;

         for(int j = 0; j < ans.size(); ++j) {
            System.out.print(ans.get(j) + " ");
            prod *= (Integer)ans.get(j);
         }

         System.out.println(" -> " + prod);
         return prod < k && ans.size() != 0 ? 1 : 0;
      }
   }

   public static void solvedp(int[] arr, int k) {
      int[][] dp = new int[arr.length + 1][k + 1];

      int i;
      int j;
      for(i = 1; i < dp.length; ++i) {
         for(j = 1; j < dp[0].length; ++j) {
            dp[i][j] = dp[i - 1][j];
            if (arr[i - 1] <= j && arr[i - 1] > 0) {
               dp[i][j] += dp[i - 1][j / arr[i - 1]] + 1;
            }
         }
      }

      for(i = 0; i < dp.length; ++i) {
         for(j = 0; j < dp[0].length; ++j) {
            System.out.print(dp[i][j] + " ");
         }

         System.out.println();
      }

   }
}
