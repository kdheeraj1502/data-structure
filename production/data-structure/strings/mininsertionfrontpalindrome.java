package strings;

public class mininsertionfrontpalindrome {
   public static void main(String[] args) {
      palinromeoptimised("abc");
   }

   public static int palindrome(String s) {
      for(int j = s.length() - 1; j > 0; --j) {
         if (checkpalindrome(s, j)) {
            return s.length() - j - 1;
         }
      }

      return s.length() - 1;
   }

   public static boolean checkpalindrome(String s, int j) {
      for(int i = 0; i <= j; ++i) {
         if (s.charAt(i) != s.charAt(j)) {
            return false;
         }

         --j;
      }

      return true;
   }

   public static void palinromeoptimised(String s) {
      String temp = s + "@";

      for(int i = s.length() - 1; i >= 0; --i) {
         temp = temp + s.charAt(i);
      }

      System.out.println(temp);
      int[] pitable = new int[temp.length() + 1];
      int i = 0;
      int j = -1;

      for(pitable[0] = -1; i < temp.length(); pitable[i] = j) {
         while(j >= 0 && temp.charAt(i) != temp.charAt(j)) {
            j = pitable[j];
         }

         ++i;
         ++j;
      }

      for(int k = 0; k < pitable.length; ++k) {
         System.out.println(pitable[k]);
      }

      System.out.println(s);
      System.out.println("ans " + (s.length() - pitable[temp.length()]));
   }
}
