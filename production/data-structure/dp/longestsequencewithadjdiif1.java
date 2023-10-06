package dp;

public class longestsequencewithadjdiif1 {
   public static void main(String[] args) {
      int[] arr = new int[]{1, 2, 3, 4, 5};
      solve(arr);
   }

   public static void solve(int[] arr) {
      int[] dp = new int[arr.length];
      dp[0] = 1;

      int ans;
      int i;
      for(ans = 1; ans < dp.length; ++ans) {
         i = 0;

         for(int j = 0; j < ans; ++j) {
            if (Math.abs(arr[j] - arr[ans]) == 1 && i < dp[j]) {
               i = dp[j];
            }
         }

         dp[ans] = i + 1;
      }

      ans = 0;

      for(i = 0; i < dp.length; ++i) {
         if (ans < dp[i]) {
            ans = dp[i];
         }
      }

      System.out.println(ans);
   }
}
