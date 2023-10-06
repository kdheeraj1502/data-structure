package bit.masking.xor;

public class NumMupltiRepeatExcept1Num {
   public static int twoTimesRepeat(int[] num) {
      int xor = 0;
      int[] var2 = num;
      int var3 = num.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         int val = var2[var4];
         xor ^= val;
      }

      return xor;
   }

   public static int threeTimesRepeat(int[] num) {
      int xor = 0;
      int[] var2 = num;
      int var3 = num.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         int val = var2[var4];
         xor ^= val;
      }

      return xor;
   }

   public static void main(String[] args) {
      int[] num = new int[]{3, 9, 8, 4, 3, 14, 8, 4, 9};
      int[] num1 = new int[]{8, 9, 4, 3, 3, 9, 8, 4, 3, 77, 8, 4, 9};
      System.out.println(twoTimesRepeat(num));
      System.out.println(threeTimesRepeat(num1));
   }
}
