package stackandqueue;

import java.util.Stack;

public class nextgreater {
   public static void main(String[] args) {
      long[] arr = new long[]{2L, 1L, 3L, 8L, 6L, 7L, 5L};
      long[] ans = nextLargerElement(arr);
      long[] var3 = ans;
      int var4 = ans.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         long l = var3[var5];
         System.out.println(l);
      }

   }

   public static long[] nextLargerElement(long[] arr) {
      long[] ans = new long[arr.length];
      ans[arr.length - 1] = -1L;
      Stack<Long> st = new Stack();
      st.push(arr[arr.length - 1]);

      for(int i = arr.length - 2; i >= 0; --i) {
         while(st.size() > 0 && (Long)st.peek() <= arr[i]) {
            st.pop();
         }

         if (st.size() == 0) {
            ans[i] = -1L;
         } else {
            ans[i] = (Long)st.peek();
         }

         st.push(arr[i]);
      }

      return ans;
   }
}
