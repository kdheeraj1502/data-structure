package stack;

import java.util.Stack;

public class InfixToPreFix {
   public static void main(String[] args) {
      String expn = "10+((3))*5/(16-4)";
      String value = infixToPreFix(expn);
      System.out.println("Inflix Expn : " + expn);
      System.out.println("Postfix expn: " + value);
   }

   private static String infixToPreFix(String expn) {
      Stack<Character> stack = new Stack();
      char[] ch = expn.toCharArray();
      String output = "";
      char[] var4 = ch;
      int var5 = ch.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         char c = var4[var6];
         if (c != '+' && c != '-' && c != '*' && c != '/' && c != '(' && c != ')') {
            output = c + output;
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

                  output = op + output;
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

                        output = op + output;
                     }
                  }

                  stack.push(c);
               }
            }
         }
      }

      while(!stack.isEmpty()) {
         output = stack.pop() + output;
      }

      return output;
   }

   private static int getPriority(char op) {
      return op != '+' && op != '-' ? 2 : 1;
   }
}
