package searching;

public class FindMissingNumberXOR {
   public static int findMissingNumberXOR(int[] num) {
      int i = false;
      int xorSum = 0;

      int i;
      for(i = 1; i <= 10; ++i) {
         xorSum ^= i;
      }

      System.out.println(xorSum);

      for(i = 0; i < num.length; ++i) {
         System.out.println(xorSum + " xor " + num[i] + ", ");
         xorSum ^= num[i];
      }

      System.out.println();
      return xorSum;
   }
}
