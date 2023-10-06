package array;

public class OddCount {
   public static int findOddCountEle(int[] num) {
      int xor = 0;

      for(int i = 0; i < num.length; ++i) {
         xor ^= num[i];
      }

      return xor;
   }

   public static void main(String[] args) {
      int[] num = new int[]{2, 5, 2, 3, 1, 1, 6, 5, 4, 3, 2, 2};
      System.out.println(findOddCountEle(num));
   }
}
