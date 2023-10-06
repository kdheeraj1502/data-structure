package dp;

public class subsetsum {
   int[][] dp;
   int sum;

   subsetsum(int[] num, int sum) {
      this.dp = new int[num.length + 1][sum + 1];
      this.sum = sum;
   }

   public static void main(String[] args) {
      int[] arr = new int[]{4, 2, 7, 1, 3};
      subsetsum ss = new subsetsum(arr, 10);
      System.out.println("------------------------");
      ss.subsetsum_self(arr);
      System.out.println("------------");
      ss.subsetsum_count(arr);
   }

   public void subsetsum_count(int[] num) {
      int[][] dp = new int[num.length + 1][this.sum + 1];

      int i;
      int j;
      for(i = 1; i < dp.length; ++i) {
         dp[i][0] = 1;

         for(j = 1; j < dp[i].length; ++j) {
            if (num[i - 1] == j) {
               dp[i][j] = 1;
            }
         }
      }

      for(i = 1; i < dp.length; ++i) {
         for(j = 1; j < dp[i].length; ++j) {
            if (num[i - 1] >= j && num[i - 1] == j) {
               dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num[i - 1]];
            }
         }
      }

      System.out.println(dp[dp.length - 1][this.sum]);
   }

   public void subsetsum_self(int[] num) {
      int i;
      for(i = 0; i < this.dp.length; ++i) {
         this.dp[i][0] = 1;
      }

      int j;
      for(i = 1; i < this.dp.length; ++i) {
         for(j = 1; j < this.dp[0].length; ++j) {
            if (this.dp[i - 1][j] == 1) {
               this.dp[i][j] = this.dp[i - 1][j];
            } else {
               int val = num[i - 1];
               if (j >= val && this.dp[i - 1][j - val] == 1) {
                  this.dp[i][j] = this.dp[i - 1][j - val];
               }
            }
         }
      }

      for(i = 0; i < this.dp.length; ++i) {
         for(j = 0; j < this.dp[0].length; ++j) {
            System.out.print(this.dp[i][j] + " ");
         }

         System.out.println();
      }

      System.out.println("----------subset -----------");
      this.printSet_self(num);
   }

   private void printSet_self(int[] num) {
      int i = this.dp.length - 1;
      int j = this.sum;
      int min = this.dp[i][j];

      while(j > 0) {
         if (this.dp[i - 1][j] == min) {
            --i;
         } else {
            System.out.print(num[i - 1] + ", ");
            j -= num[i - 1];
            min = this.dp[i][j];
         }
      }

      System.out.println();
      System.out.println("----------subset -----------");
   }

   private void printSet(int[] num) {
      int i = this.dp.length - 1;
      int j = this.sum;
      int min = this.dp[i][j];

      while(j > 0) {
         System.out.println("i is " + i + " j is " + j);
         if (this.dp[i - 1][j] == min) {
            --i;
         } else {
            System.out.print(num[i - 1] + ", ");
            j -= num[i - 1];
            min = this.dp[i][j];
         }
      }

      System.out.println();
      System.out.println("----------subset -----------");
   }

   public void subsetsum(int[] arr) {
      int[][] dp = new int[arr.length + 1][this.sum + 1];
      dp[1][arr[0]] = 1;

      int i;
      for(i = 0; i < dp.length; ++i) {
         dp[i][0] = 1;
      }

      int j;
      for(i = 2; i < dp.length; ++i) {
         for(j = 1; j < dp[0].length; ++j) {
            if (dp[i - 1][j] == 1) {
               dp[i][j] = dp[i - 1][j];
            } else if (j - arr[i - 1] >= 0 && dp[i - 1][j - arr[i - 1]] == 1) {
               dp[i][j] = 1;
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
