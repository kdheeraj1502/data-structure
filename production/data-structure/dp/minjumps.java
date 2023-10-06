package dp;

public class minjumps {
   public static void main(String[] args) {
      int[] arr = new int[]{2, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
      solvedp(arr);
      System.out.println(solveopti(arr));
   }

   public static void solvedp(int[] arr) {
      int[] dp = new int[arr.length];

      int i;
      for(i = arr.length - 2; i >= 0; --i) {
         if (arr[i] + i >= arr.length - 1) {
            dp[i] = 1;
         } else {
            int min = Integer.MAX_VALUE;

            for(int j = i + 1; j <= i + arr[i]; ++j) {
               if (min > dp[j]) {
                  min = dp[j];
               }
            }

            dp[i] = min + 1;
         }
      }

      for(i = 0; i < dp.length; ++i) {
         System.out.print(dp[i] + " ");
      }

      System.out.println();
      if (dp[0] < 0) {
         System.out.println(-1);
      } else {
         System.out.println(dp[0]);
      }

   }

   public static int solveopti(int[] arr) {
      int steps = arr[0];
      int minjumps = 1;
      int maxreachidx = arr[0];
      if (arr[0] == 0) {
         return -1;
      } else {
         for(int i = 1; i < arr.length; ++i) {
            if (i == arr.length - 1) {
               return minjumps;
            }

            maxreachidx = Math.max(maxreachidx, arr[i] + i);
            --steps;
            if (steps == 0) {
               if (i >= maxreachidx) {
                  return -1;
               }

               ++minjumps;
               steps = maxreachidx - i;
            }
         }

         return -1;
      }
   }
}
