package bitmasking;

public class PositionOfOnlySetBit_6 {
   public static void main(String[] args) {
   }

   static int findPosition(int n) {
      if (!isPowerofTwo(n)) {
         return -1;
      } else {
         int pos;
         for(pos = 0; n != 1; n >>= 1) {
            ++pos;
         }

         return pos + 1;
      }
   }

   public static boolean isPowerofTwo(int n) {
      if (n == 0) {
         return false;
      } else {
         return (n & n - 1) == 0;
      }
   }
}
