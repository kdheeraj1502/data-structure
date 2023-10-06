package stack;

import java.util.Stack;

public class InfixToPostFix {
   public static int precedence(char x) {
      if (x == '(') {
         return 0;
      } else if (x != '+' && x != '-') {
         if (x != '*' && x != '/' && x != '%') {
            return x == '^' ? 3 : 4;
         } else {
            return 2;
         }
      } else {
         return 1;
      }
   }

   public static String infixToPostFix(String expn) {
      String output = "";
      char[] out = infixToPostFix(expn.toCharArray());
      char[] var3 = out;
      int var4 = out.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         char ch = var3[var5];
         output = output + ch;
      }

      return output;
   }

   public static char[] infixToPostFix(char[] expn) {
      Stack<Character> stack = new Stack();
      String output = "";
      char[] var4 = expn;
      int var5 = expn.length;

      char out;
      for(int var6 = 0; var6 < var5; ++var6) {
         char ch = var4[var6];
         if (ch <= '9' && ch >= '0') {
            output = output + ch;
         } else {
            switch (ch) {
               case '%':
               case '*':
               case '+':
               case '-':
               case '/':
               case '^':
                  while(!stack.isEmpty() && precedence(ch) <= precedence((Character)stack.peek())) {
                     out = (Character)stack.pop();
                     output = output + " " + out;
                  }

                  stack.push(ch);
                  output = output + " ";
                  break;
               case '(':
                  stack.push(ch);
                  break;
               case ')':
                  while(!stack.isEmpty() && (out = (Character)stack.pop()) != '(') {
                     output = output + " " + out + " ";
                  }
            }
         }
      }

      while(!stack.isEmpty()) {
         out = (Character)stack.pop();
         output = output + out + " ";
      }

      return output.toCharArray();
   }

   public static void main(String[] args) {
      String expn = "10+((3))*5/(16-4)";
      String value = infixToPostFix(expn);
      System.out.println("Inflix Expn : " + expn);
      System.out.println("Postfix expn: " + value);
   }
}
