package array;

public class minjumpsps {
   public static void main(String[] args) {
      int[] arr = new int[]{3, 3, 0, 2, 1, 2, 4, 2, 0, 0};
      System.out.println(minjumpsnospace(arr, arr.length));
   }

   public static void minjumps(int[] arr, int n) {
      int[] dp = new int[arr.length];
      dp[n - 1] = 0;

      int i;
      for(i = n - 2; i >= 0; --i) {
         if (arr[i] == 0) {
            dp[i] = 0;
         } else if (arr[i] + i >= n - 1) {
            dp[i] = 1;
         } else {
            int min = Integer.MAX_VALUE;

            for(int j = i + 1; j <= i + arr[i] && j < arr.length; ++j) {
               if (dp[j] != 0 && dp[j] < min) {
                  min = dp[j];
               }
            }

            if (min != Integer.MAX_VALUE) {
               dp[i] = min + 1;
            } else {
               dp[i] = 0;
            }
         }
      }

      for(i = 0; i < dp.length; ++i) {
         System.out.println(dp[i]);
      }

   }

   public static int minjumpsnospace(int[] arr, int n) {
      if (arr[0] == 0) {
         return -1;
      } else if (arr.length <= 1) {
         return 0;
      } else {
         int maxreach = arr[0];
         int jumps = 1;
         int steps = arr[0];

         for(int i = 1; i < arr.length; ++i) {
            if (i == arr.length - 1) {
               return jumps;
            }

            maxreach = Math.max(maxreach, arr[i] + i);
            --steps;
            if (steps == 0) {
               ++jumps;
               if (maxreach >= n - 1) {
                  return jumps;
               }

               if (i >= maxreach) {
                  return -1;
               }

               steps = maxreach - i;
            }
         }

         return -1;
      }
   }
}
