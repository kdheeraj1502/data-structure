package string;

public class ValidPalindrom {
   public boolean isPalindrome(String s) {
      s = s.toLowerCase();
      String rev = this.reverse(s.toCharArray());
      if (rev.length() != s.length()) {
         return false;
      } else {
         int first = 0;
         int second = 0;

         while(first < s.length() && second < rev.length()) {
            if ((s.charAt(first) > '9' || s.charAt(first) < '0') && (s.charAt(first) < 'a' || s.charAt(first) > 'z')) {
               ++first;
            } else if ((rev.charAt(second) > '9' || rev.charAt(second) < '0') && (rev.charAt(second) < 'a' || rev.charAt(second) > 'z')) {
               ++second;
            } else {
               if (s.charAt(first) != rev.charAt(second)) {
                  return false;
               }

               ++first;
               ++second;
            }
         }

         return true;
      }
   }

   private String reverse(char[] s) {
      int start = 0;

      char temp;
      for(int end = s.length - 1; start < end; s[end--] = temp) {
         temp = s[start];
         s[start++] = s[end];
      }

      return new String(s);
   }

   public static void main(String[] args) {
      String s = "A man, a plan, a canal: Panama";
      ValidPalindrom vp = new ValidPalindrom();
      System.out.println(vp.isPalindrome(s));
   }
}
