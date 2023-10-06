package stackandqueue;

import java.util.Stack;

public class celebrityproblem {
   public static void main(String[] args) {
   }

   int celebrity(int[][] m, int n) {
      Stack<Integer> st = new Stack();

      int celb;
      for(celb = 0; celb < n; ++celb) {
         st.push(celb);
      }

      int i;
      while(st.size() >= 2) {
         celb = (Integer)st.pop();
         i = (Integer)st.pop();
         if (m[celb][i] == 1) {
            st.push(i);
         } else {
            st.push(celb);
         }
      }

      celb = (Integer)st.pop();

      for(i = 0; i < n; ++i) {
         if (i != celb && (m[celb][i] == 1 || m[i][celb] == 0)) {
            return -1;
         }
      }

      return celb;
   }
}
