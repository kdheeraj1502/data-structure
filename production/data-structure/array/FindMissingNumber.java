package array;

public class FindMissingNumber {
   public static int findMissing(int[] num) {
      int xor = 0;

      int i;
      for(i = 0; i < num.length; ++i) {
         xor ^= num[i];
      }

      for(i = 0; i <= 10; ++i) {
         xor ^= i;
      }

      return xor;
   }

   public static void main(String[] args) {
      int[] num = new int[]{1, 4, 2, 3, 6, 7, 8, 9, 10};
      System.out.println(findMissing(num));
   }
}
