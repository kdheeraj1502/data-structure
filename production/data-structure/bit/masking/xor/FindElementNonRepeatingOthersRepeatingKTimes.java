package bit.masking.xor;

public class FindElementNonRepeatingOthersRepeatingKTimes {
   public static int findNum(int[] num, int k) {
      int[] result = new int[32];

      int output;
      for(output = 0; output < num.length; ++output) {
         String str = Integer.toBinaryString(num[output]);
         int j = str.length() - 1;

         for(int index = 0; j >= 0; ++index) {
            if (str.charAt(j) == '1') {
               int var10002 = result[index]++;
            }

            --j;
         }
      }

      for(output = 0; output < result.length; ++output) {
         result[output] %= k;
      }

      output = 0;

      for(int i = 0; i < result.length; ++i) {
         output = (int)((double)output + (double)result[i] * Math.pow(2.0, (double)i));
      }

      return output;
   }

   public static int findNum_self(int[] num, int k) {
      int result = 0;

      for(int i = 0; i < 32; ++i) {
         int countOn = 0;
         int[] var5 = num;
         int var6 = num.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            int val = var5[var7];
            if ((val & 1 << i) != 0) {
               ++countOn;
            }
         }

         result += countOn % k * (1 << i);
      }

      return result;
   }

   public static void main(String[] args) {
      int[] num = new int[]{673, 3452, 187, 769, 673, 187, 3452, 3452, 187, 3452, 673, 187, 187, 3452, 673, 673};
      int xor = 0;
      int[] var3 = num;
      int var4 = num.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         int val = var3[var5];
         xor ^= val;
      }

      System.out.println(xor);
      System.out.println(findNum_self(num, 5));
   }
}
