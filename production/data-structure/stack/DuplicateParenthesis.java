package stack;

import java.util.Stack;

public class DuplicateParenthesis {
   public static boolean findDuplicateParenthesis(String exp) {
      Stack<Character> stack = new Stack();

      for(int i = 0; i < exp.length(); ++i) {
         char ch = exp.charAt(i);
         if (ch != ')') {
            stack.push(ch);
         } else {
            int count;
            for(count = 0; stack.size() != 0 && (Character)stack.peek() != '('; ++count) {
               stack.pop();
            }

            if (count >= 1) {
               return true;
            }
         }
      }

      return false;
   }

   public static void main(String[] args) {
      String exp = "(((a + b)) + c)";
      System.out.println(findDuplicateParenthesis(exp));
   }
}
