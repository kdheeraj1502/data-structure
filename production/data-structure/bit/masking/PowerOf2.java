package bit.masking;

public class PowerOf2 {
   static void PowerOfTwo(long N) {
      for(int i = 0; i < 64; ++i) {
         long x = 1L;
         if ((N & x << i) > 0L) {
            System.out.print(i + " ");
         }
      }

   }

   public static void main(String[] args) {
      long n = 12345L;

      int digit;
      for(digit = 0; n > 0L; ++digit) {
         n /= 2L;
      }

      System.out.println(digit);
      n = 12345L;

      for(int i = 0; i <= 14; ++i) {
         if ((n & (long)(1 << i)) > 0L) {
            System.out.print(i + " ");
            System.out.println(n & (long)(1 << i));
         }
      }

   }
}
