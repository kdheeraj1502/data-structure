package bit.masking;

public class CountSetBits {
   public static int countSetBits(int n) {
      if (n <= 0) {
         return 0;
      } else {
         int power2 = nearestPower2(n);
         int result = (1 << power2 - 1) * power2 + n - (1 << power2) + 1 + countSetBits(n - (1 << power2));
         return result;
      }
   }

   private static int nearestPower2(int val) {
      int i = 1;

      for(int power2 = 1; power2 <= val; power2 = 1 << i) {
         ++i;
      }

      return i - 1;
   }

   public static void main(String[] args) {
      System.out.println(countSetBits(15));
   }
}
