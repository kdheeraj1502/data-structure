package string;

public class ToUpperCase {
   public char convert(char c) {
      if (c >= 'a' && c <= 'z') {
         c = (char)(c - 32);
      }

      return c;
   }

   public static void main(String[] args) {
      ToUpperCase tuc = new ToUpperCase();
      System.out.println(tuc.convert('g'));
   }
}
