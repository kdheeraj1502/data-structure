package dp;

public class paintingfence {
   public static void main(String[] args) {
      System.out.println(countWays(3, 2));
   }

   public static long countWays(int n, int k) {
      if (n == 1) {
         return (long)k;
      } else {
         int mod = 1000000007;
         long same = (long)k;
         long diff = (long)(k * (k - 1));
         long total = same + diff;

         for(int i = 3; i <= n; ++i) {
            same = diff % (long)mod;
            diff = total * (long)(k - 1) % (long)mod;
            total = (same + diff) % (long)mod;
         }

         return total;
      }
   }
}
