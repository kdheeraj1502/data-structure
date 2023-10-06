package stackandqueue;

import java.util.Stack;

public class balancedpara {
   public static void main(String[] args) {
      String x = "((({{}}))))";
      System.out.println(ispar(x));
   }

   static boolean ispar(String x) {
      Stack<Character> st = new Stack();

      for(int i = 0; i < x.length(); ++i) {
         char ch = x.charAt(i);
         if (ch != '{' && ch != '(' && ch != '[') {
            if (st.isEmpty()) {
               return false;
            }

            char cl = (Character)st.peek();
            if ((ch != ')' || cl != '(') && (ch != ']' || cl != '[') && (ch != '}' || cl != '{')) {
               return false;
            }

            st.pop();
         } else {
            st.push(ch);
         }
      }

      if (st.isEmpty()) {
         return true;
      } else {
         return false;
      }
   }
}
