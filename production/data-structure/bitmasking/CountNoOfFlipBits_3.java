package bitmasking;

public class CountNoOfFlipBits_3 {
   public static void main(String[] args) {
      int A = 10;
      int B = 20;
      System.out.println(countBitsFlip(A, B));
   }

   public static int countBitsFlip(int a, int b) {
      int z = a ^ b;

      int c;
      for(c = 0; z != 0; z &= z - 1) {
         ++c;
      }

      return c;
   }
}
