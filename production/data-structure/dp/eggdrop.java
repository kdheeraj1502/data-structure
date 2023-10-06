package dp;

public class eggdrop {
   public static void main(String[] args) {
      int noe = 2;
      int tf = 3;
      System.out.println(solve(noe, tf));
      solvedp(noe, tf);
   }

   public static int solve(int noe, int tf) {
      if (tf != 0 && tf != 1) {
         if (noe == 1) {
            return tf;
         } else {
            int myans = Integer.MAX_VALUE;

            for(int i = 1; i <= tf; ++i) {
               int a = solve(noe - 1, i - 1);
               int b = solve(noe, tf - i);
               if (myans > Math.max(a, b)) {
                  myans = Math.max(a, b);
               }
            }

            return myans + 1;
         }
      } else {
         return tf;
      }
   }

   public static void solvedp(int noe, int tf) {
      int[][] dp = new int[noe + 1][tf + 1];

      for(int i = 1; i < dp.length; ++i) {
         for(int j = 1; j < dp[0].length; ++j) {
            if (j == 1) {
               dp[i][j] = 1;
            } else if (i == 1) {
               dp[i][j] = j;
            } else {
               int min = Integer.MAX_VALUE;
               int mj = j - 1;

               for(int pj = 0; mj >= 0; ++pj) {
                  int v1 = dp[i][mj];
                  int v2 = dp[i - 1][pj];
                  int val = Math.max(v1, v2);
                  min = Math.min(val, min);
                  --mj;
               }

               dp[i][j] = min + 1;
            }
         }
      }

      System.out.println(dp[noe][tf]);
   }
}
