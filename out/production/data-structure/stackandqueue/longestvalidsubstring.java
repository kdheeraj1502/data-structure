package stackandqueue;

import java.util.Stack;

public class longestvalidsubstring {
   public static void main(String[] args) {
   }

   static int findMaxLen(String s) {
      Stack<Integer> st = new Stack();
      int max = 0;
      int i = 0;
      st.push(-1);

      for(; i < s.length(); ++i) {
         char ch = s.charAt(i);
         if (ch == '(') {
            st.push(i);
         } else {
            st.pop();
            if (st.size() == 0) {
               st.push(i);
            } else {
               int len = i - (Integer)st.peek();
               if (max < len) {
                  max = len;
               }
            }
         }
      }

      return max;
   }

   static int findMaxLenopti(String s) {
      int o = 0;
      int c = 0;
      int max = 0;

      int i;
      char ch;
      for(i = 0; i < s.length(); ++i) {
         ch = s.charAt(i);
         if (ch == '(') {
            ++o;
         } else {
            ++c;
         }

         if (c > o) {
            c = 0;
            o = 0;
         } else if (c == o && max < 2 * o) {
            max = 2 * o;
         }
      }

      o = 0;
      c = 0;

      for(i = s.length() - 1; i >= 0; --i) {
         ch = s.charAt(i);
         if (ch == '(') {
            ++o;
         } else {
            ++c;
         }

         if (o > c) {
            c = 0;
            o = 0;
         } else if (c == o && max < 2 * o) {
            max = 2 * o;
         }
      }

      return max;
   }
}
