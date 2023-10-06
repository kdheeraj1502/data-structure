package stack;

import java.util.Stack;

public class MinRemoveToMakeValid {
   public static String minRemoveToMakeValid(String s) {
      Stack<Integer> stack = new Stack();
      StringBuilder sb = new StringBuilder();

      int i;
      for(i = 0; i < s.length(); ++i) {
         char ch = s.charAt(i);
         if (ch == '(') {
            stack.push(i);
         }

         if (ch == ')') {
            if (!stack.isEmpty() && s.charAt((Integer)stack.peek()) == '(') {
               stack.pop();
            } else {
               stack.push(i);
            }
         }
      }

      if (stack.isEmpty()) {
         return s;
      } else {
         for(i = s.length() - 1; i >= 0; --i) {
            if (!stack.isEmpty() && (Integer)stack.peek() == i) {
               stack.pop();
            } else {
               sb.append(s.charAt(i));
            }
         }

         return sb.reverse().toString();
      }
   }

   public static void main(String[] args) {
      String s = "lee(t(c)o)de)";
      System.out.println(minRemoveToMakeValid(s));
   }
}
