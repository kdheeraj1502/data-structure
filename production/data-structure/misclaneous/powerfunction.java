package misclaneous;

public class powerfunction {
   public static void main(String[] args) {
      int x = 71045970;
      int n = 41535484;
      int d = 64735492;
      System.out.println(pow(x, n, d));
   }

   public static int pow(int x, int n, int d) {
      if (x == 0 && n == 0) {
         return 0;
      } else {
         long ans = 1L;
         long base = (long)x;

         while(n > 0) {
            if (n % 2 == 0) {
               base = base * base % (long)d;
               n /= 2;
            } else {
               ans = ans * base % (long)d;
               --n;
            }
         }

         if (ans < 0L) {
            long fans = ans * -1L;
            long mod = fans % (long)d;
            ans = (long)d - mod;
            return (int)ans;
         } else {
            return (int)ans % d;
         }
      }
   }
}
