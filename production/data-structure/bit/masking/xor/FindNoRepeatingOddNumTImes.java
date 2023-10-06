package bit.masking.xor;

public class FindNoRepeatingOddNumTImes {
   public static void main(String[] args) {
      int[] num = new int[]{5, 4, 1, 4, 3, 2, 5, 1, 2};
      int xor = 0;
      int[] var3 = num;
      int var4 = num.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         int in = var3[var5];
         xor ^= in;
      }

      System.out.println(xor);

      int a;
      for(a = 19; a > 0; a &= a - 1) {
         System.out.println("a is " + Integer.toBinaryString(a) + " :: " + a);
         System.out.println("a - 1 is " + Integer.toBinaryString(a - 1) + " :: " + (a - 1));
      }

      System.out.println("a is " + Integer.toBinaryString(a) + " :: " + a);
   }
}
