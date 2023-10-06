package string;

public class RegularExpMatch {
   public boolean match(String exp, String str) {
      return this.match(exp.toCharArray(), str.toCharArray(), 0, 0);
   }

   private boolean match(char[] exp, char[] str, int i, int j) {
      if (i == exp.length && j == str.length) {
         return true;
      } else if (i == exp.length && j != str.length || i != exp.length && j == str.length) {
         return false;
      } else if (exp[i] != '?' && exp[i] != str[j]) {
         if (exp[i] != '*') {
            return false;
         } else {
            return this.match(exp, str, i, j + 1) || this.match(exp, str, i + 1, j) || this.match(exp, str, i + 1, j + 1);
         }
      } else {
         return this.match(exp, str, i + 1, j + 1);
      }
   }

   public static void main(String[] args) {
      RegularExpMatch rem = new RegularExpMatch();
      System.out.println(rem.match("*llo,?World?", "Hello, World!"));
   }
}
