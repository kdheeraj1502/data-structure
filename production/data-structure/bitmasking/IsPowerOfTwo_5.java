package bitmasking;

public class IsPowerOfTwo_5 {
   public static void main(String[] args) {
      System.out.println(isPowerofTwo(98L));
   }

   public static boolean isPowerofTwo(long n) {
      if (n == 0L) {
         return false;
      } else {
         return (n & n - 1L) == 0L;
      }
   }

   public boolean isPowerOfTwo(int n) {
      if (n == 1) {
         return true;
      } else if (n % 2 == 0 && n != 0) {
         return this.isPowerOfTwo(n / 2);
      } else {
         return false;
      }
   }
}
