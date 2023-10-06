package string.algorithms;

public class StringMatch {
   public static void main(String[] args) {
      String Str = new String("Welcome to thisworld");
      System.out.print("Does String contains regex (.*)this(.*) ? : ");
      System.out.println(Str.matches("(.*)this(.*)"));
      System.out.print("Does String contains regex this ? : ");
      System.out.println(Str.matches("this"));
      System.out.println("----------Region Match---------------");
      String str1 = new String("Welcome to thisworld");
      String str2 = new String("THIS");
      System.out.println(str1.regionMatches(true, 11, str2, 0, 4));
   }
}
