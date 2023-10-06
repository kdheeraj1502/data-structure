package maths.integer.string;

import java.util.Stack;

public class BodMass {
   public static int evaluate(String expression) {
      char[] tokens = expression.toCharArray();
      Stack<Integer> values = new Stack();
      Stack<Character> ops = new Stack();

      for(int i = 0; i < tokens.length; ++i) {
         char c = tokens[i];
         if (c != ' ') {
            if (c >= '0' && tokens[i] <= '9') {
               StringBuffer sbuf = new StringBuffer();

               while(i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
                  sbuf.append(tokens[i++]);
               }

               values.push(Integer.parseInt(sbuf.toString()));
               --i;
            } else if (tokens[i] == '(') {
               ops.push(tokens[i]);
            } else if (tokens[i] == ')') {
               while((Character)ops.peek() != '(') {
                  values.push(applyOp((Character)ops.pop(), (Integer)values.pop(), (Integer)values.pop()));
               }

               ops.pop();
            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
               while(!ops.empty() && hasPrecedence(tokens[i], (Character)ops.peek())) {
                  values.push(applyOp((Character)ops.pop(), (Integer)values.pop(), (Integer)values.pop()));
               }

               ops.push(tokens[i]);
            }
         }
      }

      while(!ops.empty()) {
         values.push(applyOp((Character)ops.pop(), (Integer)values.pop(), (Integer)values.pop()));
      }

      return (Integer)values.pop();
   }

   public static boolean hasPrecedence(char op1, char op2) {
      if (op2 != '(' && op2 != ')') {
         return op1 != '*' && op1 != '/' || op2 != '+' && op2 != '-';
      } else {
         return false;
      }
   }

   public static int applyOp(char op, int b, int a) {
      switch (op) {
         case '*':
            return a * b;
         case '+':
            return a + b;
         case ',':
         case '.':
         default:
            return 0;
         case '-':
            return a - b;
         case '/':
            if (b == 0) {
               throw new UnsupportedOperationException("Cannot divide by zero");
            } else {
               return a / b;
            }
      }
   }

   public static void main(String[] args) {
      System.out.println(evaluate("10 + 2 * 6"));
   }
}
