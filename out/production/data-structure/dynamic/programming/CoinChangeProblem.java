package dynamic.programming;

public class CoinChangeProblem {
   int[][] dp;
   int N;

   CoinChangeProblem(int[] coins, int N) {
      this.dp = new int[coins.length + 1][N + 1];
      this.N = N;
   }

   public int numOfWays(int[] coins) {
      int i;
      for(i = 0; i < this.dp.length; ++i) {
         this.dp[i][0] = 1;
      }

      for(i = 0; i < this.N + 1; ++i) {
         this.dp[1][i] = 1;
      }

      int j;
      for(i = 1; i < this.dp.length; ++i) {
         for(j = 1; j < this.dp[0].length; ++j) {
            if (coins[i - 1] > j) {
               this.dp[i][j] = this.dp[i - 1][j];
            } else {
               this.dp[i][j] = this.dp[i - 1][j] + this.dp[i][j - coins[i - 1]];
            }
         }
      }

      System.out.println("--------------num of ways--------");

      for(i = 0; i < this.dp.length; ++i) {
         for(j = 0; j < this.dp[0].length; ++j) {
            System.out.print(this.dp[i][j] + " ");
         }

         System.out.println();
      }

      System.out.println("--------------num of ways--------");
      System.out.println("--------------min coin--------");
      this.minCoin(coins);
      return this.dp[this.dp.length - 1][this.N];
   }

   public void minCoin(int[] coins) {
      this.dp = new int[coins.length + 1][this.N + 1];

      int i;
      for(i = 0; i < coins.length; ++i) {
         this.dp[i][0] = 0;
      }

      for(i = 0; i < this.dp[0].length; this.dp[0][i] = i++) {
      }

      int j;
      for(i = 1; i < this.dp.length; ++i) {
         for(j = 1; j < this.dp[0].length; ++j) {
            if (coins[i - 1] > j) {
               this.dp[i][j] = this.dp[i - 1][j];
            } else {
               this.dp[i][j] = Math.min(this.dp[i - 1][j], 1 + this.dp[i][j - coins[i - 1]]);
            }
         }
      }

      System.out.println("--------------coin count-----------");

      for(i = 0; i < this.dp.length; ++i) {
         for(j = 0; j < this.dp[0].length; ++j) {
            System.out.print(this.dp[i][j] + " ");
         }

         System.out.println();
      }

      System.out.println("-------------coin count----------");
      System.out.println("----------set of coins ---------");
      this.printChange(coins);
   }

   private void printChange(int[] coins) {
      int i = this.dp.length - 1;
      int j = this.N;
      int min = this.dp[i][j];

      while(j > 0) {
         if (this.dp[i - 1][j] == min) {
            --i;
         } else {
            System.out.print(coins[i - 1] + ", ");
            j -= coins[i - 1];
            min = this.dp[i][j];
         }
      }

      System.out.println();
      System.out.println("------------set of coins---------------");
   }

   public static void main(String[] args) {
      int[] coins = new int[]{1, 2, 3};
      int N = 5;
      CoinChangeProblem ccp = new CoinChangeProblem(coins, N);
      int a = ccp.numOfWays(coins);
      System.out.println("-----------Total num of ways----------");
      System.out.println(a);
   }

   public int numOfWays_recursion(int[] coins, int index, int N) {
      if (N == 0) {
         return 1;
      } else if (N < 0) {
         return 0;
      } else {
         return index <= 0 && N >= 1 ? 0 : this.numOfWays_recursion(coins, index - 1, N) + this.numOfWays_recursion(coins, index, N - coins[index - 1]);
      }
   }
}
