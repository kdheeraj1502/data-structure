package dp;

public class maxsumsequenceno3consecutive {
   public static void main(String[] args) {
      int[] arr = new int[]{3000, 2000, 1000, 3, 10};
      solve(arr);
   }

   public static void solve(int[] arr) {
      int[] dp = new int[arr.length];
      dp[0] = arr[0];
      dp[1] = arr[0] + arr[1];
      dp[2] = Math.max(dp[1], Math.max(arr[1] + arr[2], arr[0] + arr[2]));

      int ans;
      int i;
      for(ans = 3; ans < dp.length; ++ans) {
         i = dp[ans - 1];
         int b = arr[ans] + dp[ans - 2];
         int c = arr[ans] + arr[ans - 1] + dp[ans - 3];
         dp[ans] = Math.max(i, Math.max(b, c));
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
