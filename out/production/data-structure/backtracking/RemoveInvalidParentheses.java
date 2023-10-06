package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class RemoveInvalidParentheses {
   HashSet<String> map = new HashSet();
   HashSet<String> ans = new HashSet();

   public int getmin(String s) {
      Stack<Character> st = new Stack();

      for(int i = 0; i < s.length(); ++i) {
         if (!st.isEmpty() && s.charAt(i) == ')' && (Character)st.peek() == '(') {
            st.pop();
         } else if (s.charAt(i) == '(' || s.charAt(i) == ')') {
            st.push(s.charAt(i));
         }
      }

      return st.size();
   }

   public static void main(String[] args) {
      new RemoveInvalidParentheses_1();
      String s = "()())()";
   }

   public void showResult() {
      List<String> fans = new ArrayList();
      Iterator var2 = this.ans.iterator();

      while(var2.hasNext()) {
         String val = (String)var2.next();
         fans.add(val);
      }

      System.out.println(fans);
   }

   public void print(String s, int minnoofremoval) {
      if (minnoofremoval == 0 && this.getmin(s) == 0 && !this.ans.contains(s)) {
         this.ans.add(s);
      }

      for(int i = 0; i < s.length(); ++i) {
         if (s.charAt(i) == ')' || s.charAt(i) == '(') {
            String res = s.substring(0, i) + s.substring(i + 1);
            if (!this.map.contains(res)) {
               this.map.add(res);
               this.print(res, minnoofremoval - 1);
            }
         }
      }

   }
}
