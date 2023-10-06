package stack;

import java.util.Stack;

public class ReverseParenthesis {
   public static int reverseParenthesis(String exp) {
      Stack<Character> stack = new Stack();
      int openCount = 0;
      int closedCount = 0;
      if (exp.length() % 2 != 0) {
         System.out.println("not possible");
         return -1;
      } else {
         int rev;
         for(rev = 0; rev < exp.length(); ++rev) {
            char ch = exp.charAt(rev);
            if (ch == '(') {
               stack.push(ch);
            } else if (ch == ')') {
               if (stack.size() != 0 && (Character)stack.peek() == '(') {
                  stack.pop();
               } else {
                  stack.push(ch);
               }
            }
         }

         while(stack.size() != 0) {
            if ((Character)stack.pop() == '(') {
               ++openCount;
            } else {
               ++closedCount;
            }
         }

         rev = (int)(Math.ceil((double)(openCount / 2)) + Math.ceil((double)(closedCount / 2)));
         return rev;
      }
   }

   public static int reverseParenthesis_self(String exp) {
      Stack<Character> stack = new Stack();
      int open = 0;
      int close = 0;
      if (exp.length() % 2 != 0) {
         return -1;
      } else {
         int rev;
         for(rev = 0; rev < exp.length(); ++rev) {
            char ch = exp.charAt(rev);
            if (ch == '(') {
               stack.push(ch);
            } else if (ch == ')') {
               if (stack.size() != 0 && (Character)stack.peek() == '(') {
                  stack.pop();
               } else {
                  stack.push(ch);
               }
            }
         }

         while(stack.size() != 0) {
            if ((Character)stack.pop() == '(') {
               ++open;
            } else {
               ++close;
            }
         }

         rev = (int)(Math.ceil((double)(open / 2)) + Math.ceil((double)(close / 2)));
         return rev;
      }
   }

   public static void main(String[] args) {
      String exp = "())((()))(())()(()()()()))";
      int rev = reverseParenthesis_self(exp);
      System.out.println(rev);
   }
}
