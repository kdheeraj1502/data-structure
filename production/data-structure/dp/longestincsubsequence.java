package dp;

public class longestincsubsequence {
   public static void main(String[] args) {
      int[] arr = new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80, 3};
      solvedp(arr);
   }

   public static void solvedp(int[] arr) {
      int[] dp = new int[arr.length];
      dp[0] = 1;

      int max;
      int i;
      for(max = 1; max < dp.length; ++max) {
         i = 0;

         for(int j = max - 1; j >= 0; --j) {
            if (arr[max] > arr[j] && i < dp[j]) {
               i = dp[j];
            }
         }

         dp[max] = i + 1;
      }

      max = Integer.MIN_VALUE;

      for(i = 0; i < dp.length; ++i) {
         if (max < dp[i]) {
            max = dp[i];
         }
      }

      System.out.println(max);
   }
}
