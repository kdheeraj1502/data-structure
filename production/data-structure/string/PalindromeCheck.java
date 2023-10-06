package string;

public class PalindromeCheck {
   public boolean isPalindrome(String str) {
      int start = 0;

      int end;
      for(end = str.length() - 1; start < end && str.charAt(start) == str.charAt(end); --end) {
         ++start;
      }

      return start >= end;
   }

   public static void main(String[] args) {
      PalindromeCheck pc = new PalindromeCheck();
      System.out.println(pc.isPalindrome("hello"));
      System.out.println(pc.isPalindrome("eoloe"));
   }
}
