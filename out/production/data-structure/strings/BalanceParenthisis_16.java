package strings;

import java.util.Stack;

public class BalanceParenthisis_16 {
   public static void main(String[] args) {
      System.out.println(balanced("()"));
   }

   public static boolean balanced(String s) {
      Stack<Character> list = new Stack();
      list.add(s.charAt(0));

      for(int i = 1; i < s.length(); ++i) {
         if (list.empty() || ((Character)list.peek() != '(' || s.charAt(i) != ')') && ((Character)list.peek() != '[' || s.charAt(i) != ']') && ((Character)list.peek() != '{' || s.charAt(i) != '}')) {
            list.add(s.charAt(i));
         } else {
            list.pop();
         }
      }

      if (list.empty()) {
         return true;
      } else {
         return false;
      }
   }
}
