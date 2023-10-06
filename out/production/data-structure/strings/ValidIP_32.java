package strings;

public class ValidIP_32 {
   public static void main(String[] args) {
      backtrack("19002426", "", 0);
   }

   public static void backtrack(String s, String ans, int count) {
      if (count == 4 && s.length() == 0) {
         System.out.println(ans);
      } else if (count != 4) {
         for(int i = 2; i >= 0; --i) {
            if (i < s.length()) {
               String A = s.substring(0, i + 1);
               int k = 0;

               int len;
               for(len = 0; k < A.length(); ++k) {
                  if (A.charAt(k) == '0') {
                     ++len;
                  }
               }

               if ((len == A.length() || A.charAt(0) != '0') && Integer.parseInt(A) >= 0 && Integer.parseInt(A) <= 255) {
                  String ros = s.substring(i + 1);
                  ++count;
                  if (count == 4) {
                     backtrack(ros, ans + A, count);
                  } else {
                     backtrack(ros, ans + A + ".", count);
                  }

                  --count;
               }
            }
         }

      }
   }
}
