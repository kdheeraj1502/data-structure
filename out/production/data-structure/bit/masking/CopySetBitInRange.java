package bit.masking;

public class CopySetBitInRange {
   public static int copySerBitInRange(int x, int y, int l, int r) {
      int mask = false;
      int mask = 1 << r - l + 1;
      --mask;
      mask <<= l - 1;
      mask &= y;
      x |= mask;
      return x;
   }

   public static void main(String[] args) {
      int A = 10;
      int B = 13;
      int l = 2;
      int r = 3;
      System.out.println(copySerBitInRange(A, B, l, r));
   }
}
