package stackandqueue;

import java.util.Stack;

public class redundantbrackets {
   public static void main(String[] args) {
      String s = "((a+b)+(d+e))";
      System.out.println(redundant(s));
   }

   public static boolean redundant(String s) {
      Stack<Character> st = new Stack();

      for(int i = 0; i < s.length(); ++i) {
         char ch = s.charAt(i);
         if (ch != ')') {
            st.push(ch);
         } else {
            boolean flag = true;

            for(char op = (Character)st.peek(); op != '('; op = (Character)st.peek()) {
               if (op == '+' || op == '-' || op == '*' || op == '/') {
                  flag = false;
               }

               st.pop();
            }

            st.pop();
            if (flag) {
               return true;
            }
         }
      }

      return false;
   }
}
