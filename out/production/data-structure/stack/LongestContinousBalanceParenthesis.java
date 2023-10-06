package stack;

import java.util.Stack;

public class LongestContinousBalanceParenthesis {
   public static int logestContBalParen(String exp) {
      Stack<Integer> stack = new Stack();
      int length = 0;

      for(int i = 0; i < exp.length(); ++i) {
         if (exp.charAt(i) == '(') {
            stack.push(i);
         }

         if (exp.charAt(i) == ')') {
            stack.pop();
            if (stack.size() != 0) {
               length = Math.max(length, i - (Integer)stack.peek());
            } else {
               stack.push(i);
            }
         }
      }

      return length;
   }

   public static int logestContBalParenSelf(String exp) {
      Stack<Integer> stack = new Stack();
      int length = 0;
      stack.push(-1);

      for(int i = 0; i < exp.length(); ++i) {
         if (exp.charAt(i) == '(') {
            stack.push(i);
         } else {
            stack.pop();
            if (stack.size() != 0) {
               length = Math.max(length, i - (Integer)stack.peek());
            } else {
               stack.push(i);
            }
         }
      }

      return length;
   }

   public static void main(String[] args) {
      String exp = "(()()((())))";
      int val = logestContBalParen(exp);
      System.out.println("Longest balanced parenthesis is : " + val);
      System.out.println(logestContBalParenSelf(exp));
   }
}
