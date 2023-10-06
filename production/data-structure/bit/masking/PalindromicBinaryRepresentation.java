package bit.masking;

public class PalindromicBinaryRepresentation {
   public static int findNumberBinaryPalindrom(int A) {
      int count = 1;

      int len;
      int eleForThisLen;
      for(len = 1; count < A; count += eleForThisLen) {
         ++len;
         eleForThisLen = 1 << (len - 1) / 2;
      }

      count -= 1 << (len - 1) / 2;
      int offSet = A - count - 1;
      int result = 1 << len - 1;
      result |= offSet << len / 2;
      int valForRev = result >> len / 2;
      int rev = getRev(valForRev);
      result |= rev;
      return result;
   }

   private static int getRev(int n) {
      int rev;
      for(rev = 0; n > 0; n >>= 1) {
         int lb = n & 1;
         rev |= lb;
         rev <<= 1;
      }

      rev >>= 1;
      return rev;
   }

   public static void main(String[] args) {
      System.out.println(findNumberBinaryPalindrom(1));
   }
}
