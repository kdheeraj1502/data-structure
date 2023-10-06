package reverse;

public class PalindromCheck {
   public boolean isPalindrom(String s) {
      int a = 0;
      int b = s.length() - 1;

      do {
         if (a >= b) {
            return true;
         }
      } while(s.charAt(a++) == s.charAt(b--));

      return false;
   }

   public static void main(String[] args) {
      PalindromCheck pc = new PalindromCheck();
      System.out.println(pc.isPalindrom("abctmcba"));
   }
}
