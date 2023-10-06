package bit.masking;

public class Divide2Integers {
   public static int divide(int dividend, int divisor) {
      if (dividend == Integer.MIN_VALUE && divisor == -1) {
         return Integer.MAX_VALUE;
      } else {
         boolean sign = dividend >= 0 == divisor >= 0;
         dividend = Math.abs(dividend);
         divisor = Math.abs(divisor);

         int q;
         int count;
         for(q = 0; dividend - divisor >= 0; dividend -= divisor << count) {
            for(count = 0; dividend - (divisor << 1 << count) >= 0; ++count) {
            }

            q += 1 << count;
         }

         return sign ? q : -q;
      }
   }

   public static int divide_self(int dividend, int divisor) {
      if (dividend == Integer.MIN_VALUE && divisor == -1) {
         return Integer.MAX_VALUE;
      } else {
         boolean sign = dividend >= 0 == divisor >= 0;
         dividend = Math.abs(dividend);
         divisor = Math.abs(divisor);

         int q;
         int count;
         for(q = 0; dividend - divisor >= 0; dividend -= divisor << count) {
            for(count = 0; dividend - (divisor << 1 << count) >= 0; ++count) {
            }

            q += 1 << count;
         }

         return sign ? q : -q;
      }
   }

   public static void main(String[] args) {
      int a = Integer.MIN_VALUE;
      int b = -1;
      System.out.println("output :: " + divide_self(a, b));
   }
}
