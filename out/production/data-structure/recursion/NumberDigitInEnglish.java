package recursion;

public class NumberDigitInEnglish {
   static String[] digit = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

   public static void numDigitName(int num) {
      if (num > 0) {
         int a = num % 10;
         num /= 10;
         numDigitName(num);
         System.out.print(digit[a] + " ");
      }
   }

   public static void main(String[] args) {
      numDigitName(43010);
   }
}
