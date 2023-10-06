package heap;

import java.util.LinkedList;

public class maxofsubarrayinwindow {
   public static void main(String[] args) {
      int[] arr = new int[]{1, 2, 3, 8, 4, 5, 2, 3, 6};
      int k = 3;
      maxsubarray(arr, k);
   }

   public static void nextgreater(int[] arr, int[] ans) {
      LinkedList<Integer> st = new LinkedList();
      st.addFirst(arr.length - 1);
      ans[arr.length - 1] = arr.length;

      for(int i = arr.length - 2; i >= 0; --i) {
         while(st.size() > 0 && arr[(Integer)st.peek()] <= arr[i]) {
            st.removeFirst();
         }

         if (st.size() == 0) {
            ans[i] = arr.length;
         } else {
            ans[i] = (Integer)st.peek();
         }

         st.addFirst(i);
      }

   }

   public static void maxsubarray(int[] arr, int k) {
      int[] nxtgrt = new int[arr.length];
      nextgreater(arr, nxtgrt);
      int j = 0;

      for(int i = 0; i <= arr.length - k; ++i) {
         if (j < i) {
            j = i;
         }

         while(nxtgrt[j] < i + k) {
            j = nxtgrt[j];
         }

         System.out.println(arr[j]);
      }

   }
}
