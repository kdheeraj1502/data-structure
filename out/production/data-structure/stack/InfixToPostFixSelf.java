package stack;

import java.util.Stack;

public class InfixToPostFixSelf {
   public static String infixToPostFixSelf(String exp) {
      Stack<Character> stack = new Stack();
      String postfix = "";
      char[] ch = exp.toCharArray();
      char[] var4 = ch;
      int var5 = ch.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         char c = var4[var6];
         if (c != '+' && c != '-' && c != '*' && c != '/' && c != '(' && c != ')') {
            postfix = postfix + c;
         } else if (c == '(') {
            stack.push(c);
         } else {
            char op;
            if (c == ')') {
               while(!stack.isEmpty()) {
                  op = (Character)stack.pop();
                  if (op == '(') {
                     break;
                  }

                  postfix = postfix + op;
               }
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
               if (stack.isEmpty()) {
                  stack.push(c);
               } else {
                  while(!stack.isEmpty()) {
                     op = (Character)stack.pop();
                     if (op == '(') {
                        stack.push(op);
                        break;
                     }

                     if (op == '+' || op == '-' || op == '*' || op == '/') {
                        if (getPriority(op) < getPriority(c)) {
                           stack.push(op);
                           break;
                        }

                        postfix = postfix + op;
                     }
                  }

                  stack.push(c);
               }
            }
         }
      }

      while(!stack.isEmpty()) {
         postfix = postfix + stack.pop();
      }

      return postfix;
   }

   private static int getPriority(char op) {
      return op != '+' && op != '-' ? 2 : 1;
   }

   public static void main(String[] args) {
      String expn = "10+((3))*5/(16-4)";
      String value = infixToPostFixSelf(expn);
      System.out.println("Inflix Expn : " + expn);
      System.out.println("Postfix expn: " + value);
   }
}
