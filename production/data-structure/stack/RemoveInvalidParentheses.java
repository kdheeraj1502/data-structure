package stack;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveInvalidParentheses {
   public int getMin(String s) {
      Stack<Integer> stack = new Stack();

      for(int i = 0; i < s.length(); ++i) {
         char ch = s.charAt(i);
         if (ch == '(') {
            stack.push(i);
         } else if (!stack.isEmpty() && ch == ')' && s.charAt((Integer)stack.peek()) == '(') {
            stack.pop();
         } else {
            stack.push(i);
         }
      }

      return stack.size();
   }

   public void removeInvalidParentheses(String s) {
      int remove = this.getMin(s);
      Set<String> result = new HashSet();
      this.removeInvalidParentheses(s, remove, result);
      PrintStream var10001 = System.out;
      result.forEach(var10001::println);
   }

   public void removeInvalidParentheses(String s, int remove, Set<String> buffer) {
      int i;
      if (remove == 0) {
         i = this.getMin(s);
         if (i == 0 && !buffer.contains(s)) {
            buffer.add(s);
         }
      }

      for(i = 0; i < s.length(); ++i) {
         String left = s.substring(0, i);
         String right = s.substring(i + 1);
         String res = left + right;
         this.removeInvalidParentheses(res, remove - 1, buffer);
      }

   }

   public static void main(String[] args) {
      String s = "()())()";
      RemoveInvalidParentheses rip = new RemoveInvalidParentheses();
      rip.removeInvalidParentheses(s);
   }
}
