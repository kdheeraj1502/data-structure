package string;

public class ASCIIToInt {
   public int myAtoi(String str) {
      int value = 0;

      for(int i = 0; i < str.length(); ++i) {
         char ch = str.charAt(i);
         value = (value << 3) + (value << 1) + (ch - 48);
      }

      return value;
   }

   public int convert_self(String str) {
      int result = 0;

      for(int i = 0; i < str.length(); ++i) {
         char ch = str.charAt(i);
         result = (result << 3) + (result << 1) + (ch - 48);
      }

      return result;
   }

   public static void main(String[] args) {
      ASCIIToInt ati = new ASCIIToInt();
      System.out.println(ati.myAtoi("52"));
      System.out.println(ati.convert_self("8976"));
   }
}
