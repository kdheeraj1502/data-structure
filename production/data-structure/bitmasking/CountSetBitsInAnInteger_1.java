package bitmasking;

public class CountSetBitsInAnInteger_1 {
   public static void main(String[] args) {
      System.out.println(setBits2(7));
      System.out.println(6);
   }

   static int setBits(int n) {
      int c;
      for(c = 0; n != 0; n >>= 1) {
         c += n & 1;
      }

      return c;
   }

   static int setBits2(int n) {
      int c;
      for(c = 0; n != 0; n &= n - 1) {
         ++c;
      }

      return c;
   }
}
