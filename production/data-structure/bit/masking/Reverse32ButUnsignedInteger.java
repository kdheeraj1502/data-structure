package bit.masking;

public class Reverse32ButUnsignedInteger {
   public static long reverse(long n) {
      long reverse = n & 1L;

      for(int i = 1; i < 32; ++i) {
         n >>= 1;
         reverse <<= 1;
         reverse += n & 1L;
      }

      return reverse;
   }

   public static void main(String[] args) {
      System.out.println(reverse(6L));
      int num = 6;
      int i = 1;

      int reverse;
      for(reverse = num & 1; i < 32; ++i) {
         num >>= 1;
         reverse <<= 1;
         reverse += num & 1;
      }

      System.out.println(reverse);
   }
}
