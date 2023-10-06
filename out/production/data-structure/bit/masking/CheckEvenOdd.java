package bit.masking;

public class CheckEvenOdd {
   public static String isEven(int num) {
      return (num & 1) == 1 ? "odd" : "even";
   }

   public static void main(String[] args) {
      int[] num = new int[]{3, 6, 2, 43, 856, 78, 2, 357, 34, 23, 991, 13467};
      int[] var2 = num;
      int var3 = num.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         int in = var2[var4];
         System.out.println("Num " + in + " is " + isEven(in));
      }

   }
}
