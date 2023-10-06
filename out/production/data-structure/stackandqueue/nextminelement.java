package stackandqueue;

import java.util.Stack;

public class nextminelement {
   public static void main(String[] args) {
      int[] arr = new int[]{4, 8, 5, 2, 25};
      nxtmin(arr);
   }

   public static void nxtmin(int[] arr) {
      Stack<Integer> st = new Stack();
      int[] ans = new int[arr.length];
      ans[arr.length - 1] = -1;
      st.push(arr[arr.length - 1]);

      int i;
      for(i = arr.length - 2; i >= 0; --i) {
         while(!st.isEmpty() && arr[i] < (Integer)st.peek()) {
            st.pop();
         }

         if (st.isEmpty()) {
            ans[i] = -1;
         } else {
            ans[i] = (Integer)st.peek();
         }

         st.push(arr[i]);
      }

      for(i = 0; i < ans.length; ++i) {
         System.out.println(ans[i]);
      }

   }
}
