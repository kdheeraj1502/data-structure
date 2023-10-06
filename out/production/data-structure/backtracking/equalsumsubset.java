package backtracking;

public class equalsumsubset {
   public static void main(String[] args) {
      int[] arr = new int[]{2, 4, 11, 10, 5};
      targetsubsetsum(arr, 16);
   }

   static int equalPartition(int N, int[] arr) {
      int prefixsum = 0;

      for(int i = 0; i < arr.length; ++i) {
         prefixsum += arr[i];
      }

      if (prefixsum % 2 == 0 && arr.length >= 2) {
         boolean fans = partition(arr, 0, 0, new int[2]);
         return fans ? 1 : 0;
      } else {
         return 0;
      }
   }

   public static boolean partition(int[] arr, int i, int psf, int[] sum) {
      if (i == arr.length) {
         return psf == 2 && sum[0] == sum[1];
      } else {
         for(int j = 0; j < 2; ++j) {
            if (sum[j] <= 0) {
               sum[j] += arr[i];
               if (partition(arr, i + 1, psf + 1, sum)) {
                  return true;
               }

               sum[j] -= arr[i];
               break;
            }

            sum[j] += arr[i];
            if (partition(arr, i + 1, psf, sum)) {
               return true;
            }

            sum[j] -= arr[i];
         }

         return false;
      }
   }

   public static void targetsubsetsum(int[] arr, int sum) {
      int[][] dp = new int[arr.length + 1][sum + 1];

      int i;
      for(i = 0; i < dp.length; ++i) {
         dp[i][0] = 1;
      }

      dp[1][arr[0]] = 1;

      int j;
      for(i = 2; i < dp.length; ++i) {
         for(j = 0; j < dp[0].length; ++j) {
            if (dp[i - 1][j] == 1) {
               dp[i][j] = 1;
            } else if (arr[i - 1] <= j && dp[i - 1][j - arr[i - 1]] == 1) {
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
