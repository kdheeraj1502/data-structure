package bit.masking;

public class IsPowerOf2 {
   public static boolean isPower2(int n) {
      return (n != 0 && n < Integer.MAX_VALUE && n > Integer.MIN_VALUE ? n & n - 1 : 1) == 0;
   }

   public static boolean isPowerOfTwo(int n) {
      if (n == 1) {
         return true;
      } else if (n % 2 == 0 && n != 0) {
         return isPowerOfTwo(n / 2);
      } else {
         return false;
      }
   }

   public static void main(String[] args) {
      System.out.println("33554432 is power of 2 " + isPower2(33554432));
      System.out.println(Integer.toBinaryString(33554432));
      System.out.println(isPowerOfTwo(98));
   }
}
