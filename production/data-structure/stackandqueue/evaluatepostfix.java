package stackandqueue;

import java.util.Stack;

public class evaluatepostfix {
   public static void main(String[] args) {
   }

   public static int evaluatePostFix(String s) {
      Stack<Integer> st = new Stack();

      for(int i = 0; i < s.length(); ++i) {
         if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            st.push(s.charAt(i) - 48);
         } else {
            char ch = s.charAt(i);
            int a = (Integer)st.pop();
            int b = (Integer)st.pop();
            if (ch == '+') {
               st.push(b + a);
            } else if (ch == '-') {
               st.push(b - a);
            } else if (ch == '*') {
               st.push(b * a);
            } else {
               st.push(b / a);
            }
         }
      }

      return (Integer)st.pop();
   }
}
