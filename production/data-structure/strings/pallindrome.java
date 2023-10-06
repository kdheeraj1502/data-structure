package strings;

public class pallindrome {
   public static void main(String[] args) {
   }

   public static int pallindrome(String s) {
      int i = 0;

      for(int j = s.length() - 1; i < j; --j) {
         if (s.charAt(i) != s.charAt(j)) {
            return 0;
         }

         ++i;
      }

      return 1;
   }
}
