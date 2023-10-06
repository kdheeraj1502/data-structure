package backtracking;

public class printallpallindromicsubstring {
   public static void main(String[] args) {
      String s = "nittin";
      print(s, "");
   }

   public static void print(String s, String ans) {
      if (s.length() == 0) {
         System.out.println(ans);
      } else {
         for(int i = 0; i < s.length(); ++i) {
            String prefix = s.substring(0, i + 1);
            if (check(prefix)) {
               String res = s.substring(i + 1);
               print(res, ans + prefix + " ");
            }
         }

      }
   }

   private static boolean check(String prefix) {
      if (prefix.length() == 1) {
         return true;
      } else {
         int i = 0;

         for(int j = prefix.length() - 1; i < j; --j) {
            if (prefix.charAt(i) != prefix.charAt(j)) {
               return false;
            }

            ++i;
         }

         return true;
      }
   }
}
