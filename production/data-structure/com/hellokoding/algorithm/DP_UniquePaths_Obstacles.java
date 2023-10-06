package com.hellokoding.algorithm;

public class DP_UniquePaths_Obstacles {
   int countUniquePaths(int[][] A) {
      if (A[0][0] == 1) {
         return 0;
      } else {
         int rows = A.length;
         int cols = A[0].length;
         int[][] cache = new int[rows][cols];
         cache[0][0] = 1;

         int i;
         for(i = 1; i < rows; ++i) {
            if (A[i][0] == 0) {
               cache[i][0] = cache[i - 1][0];
            }
         }

         for(i = 1; i < cols; ++i) {
            if (A[0][i] == 0) {
               cache[0][i] = cache[0][i - 1];
            }
         }

         for(i = 1; i < rows; ++i) {
            for(int j = 1; j < cols; ++j) {
               if (A[i][j] == 0) {
                  cache[i][j] = cache[i - 1][j] + cache[i][j - 1];
               }
            }
         }

         return cache[rows - 1][cols - 1];
      }
   }

   public static void main(String[] args) {
      DP_UniquePaths_Obstacles uniquePaths = new DP_UniquePaths_Obstacles();
      int[][] A = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
      System.out.println(uniquePaths.countUniquePaths(A));
   }
}
