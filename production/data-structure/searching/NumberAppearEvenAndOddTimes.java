package searching;

public class NumberAppearEvenAndOddTimes {
   public static int findOddTimesNum(int[] num) {
      int xor = 0;

      for(int i = 0; i < num.length; ++i) {
         xor ^= num[i];
      }

      return xor;
   }

   public static void main(String[] args) {
      int[] num = new int[]{5, 3, 1, 1, 6, 5, 4, 3};
      System.out.println(findOddTimesNum(num));
   }
}
