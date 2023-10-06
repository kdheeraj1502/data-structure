package backtracking;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses_1 {
   public List<String> removeInvalidParentheses(String s) {
      List<String> ans = new ArrayList();
      this.remove(s, ans, 0, 0, new char[]{'(', ')'});
      return ans;
   }

   public void remove(String s, List<String> ans, int last_i, int last_j, char[] par) {
      int stack = 0;

      for(int i = last_i; i < s.length(); ++i) {
         if (s.charAt(i) == par[0]) {
            ++stack;
         }

         if (s.charAt(i) == par[1]) {
            --stack;
         }

         if (stack < 0) {
            for(int j = last_j; j <= i; ++j) {
               if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1])) {
                  this.remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
               }
            }

            return;
         }
      }

      String reversed = (new StringBuilder(s)).reverse().toString();
      if (par[0] == '(') {
         this.remove(reversed, ans, 0, 0, new char[]{')', '('});
      } else {
         ans.add(reversed);
      }

   }

   public static void main(String[] args) {
      String s = "((((((";
      RemoveInvalidParentheses_1 rp = new RemoveInvalidParentheses_1();
      System.out.println(rp.removeInvalidParentheses(s));
   }
}
