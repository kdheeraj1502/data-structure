package dp;

public class binomialcoffecient {
   public static void main(String[] args) {
   }

   static int ncr(int n, int r) {
      if (n < r) {
         return 0;
      } else {
         return r != 0 && r != n ? ncr(n - 1, r - 1) + ncr(n - 1, r) : 1;
      }
   }

   static int nCropti(int n, int r) {
      if (n < r) {
         return 0;
      } else {
         int mod = 1000000007;
         int[] dp = new int[r + 1];
         dp[0] = 1;

         for(int i = 1; i <= n; ++i) {
            for(int j = r; j > 0; --j) {
               dp[j] = (dp[j] + dp[j - 1]) % mod;
            }
         }

         return dp[r];
      }
   }
}
