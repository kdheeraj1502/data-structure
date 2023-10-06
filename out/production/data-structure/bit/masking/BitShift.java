package bit.masking;

public class BitShift {
   public static void main(String[] args) {
      System.out.println(-469762048);
      System.out.println(Integer.toBinaryString(28));
      System.out.println(Integer.toBinaryString(28));
      System.out.println(Integer.toBinaryString(-29));
      System.out.println(Integer.toBinaryString(2147483619));
      String num = Integer.toBinaryString(-29);
      int count = 0;
      char[] var3 = num.toCharArray();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         char c = var3[var5];
         if (c == '1') {
            ++count;
         }
      }

      System.out.println("1 is " + count + " total size is " + num.toCharArray().length);
   }
}
