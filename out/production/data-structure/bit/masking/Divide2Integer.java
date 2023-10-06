package bit.masking;

public class Divide2Integer {
   public static int divide(int dividend, int divisor) {
      boolean sign = (dividend >= 0 || divisor >= 0) && (dividend <= 0 || divisor <= 0);
      if (dividend <= Integer.MAX_VALUE && dividend >= Integer.MIN_VALUE && divisor <= Integer.MAX_VALUE && divisor >= Integer.MIN_VALUE) {
         dividend = Math.abs(dividend);
         divisor = Math.abs(divisor);

         int res;
         int count;
         for(res = 0; dividend - divisor >= 0; dividend -= divisor << count) {
            for(count = 0; dividend - (divisor << 1 << count) >= 0; ++count) {
            }

            res += 1 << count;
         }

         return sign ? -res : res;
      } else {
         return sign ? -2147483647 : Integer.MAX_VALUE;
      }
   }

   public static void main(String[] args) {
      int a = Integer.MIN_VALUE;
      int b = -1;
      System.out.println(divide(a, b));
   }
}
