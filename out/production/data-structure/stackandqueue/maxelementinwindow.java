package stackandqueue;

import java.util.Deque;
import java.util.LinkedList;

public class maxelementinwindow {
   public static void main(String[] args) {
      int[] arr = new int[]{1, 2, 3, 8, 4, 5, 2, 3, 6};
      int k = 3;
      maxinwindow2(arr, k);
   }

   public static void maxinwindow(int[] arr, int k) {
      Deque<Integer> q = new LinkedList();

      int i;
      for(i = 0; i < k; ++i) {
         while(!q.isEmpty() && arr[i] > arr[(Integer)q.getLast()]) {
            q.removeLast();
         }

         q.addLast(i);
      }

      while(i < arr.length) {
         System.out.print(arr[(Integer)q.getFirst()] + " ");

         while(!q.isEmpty() && (Integer)q.getFirst() <= i - k) {
            q.removeFirst();
         }

         while(!q.isEmpty() && arr[i] > arr[(Integer)q.getLast()]) {
            q.removeLast();
         }

         q.addLast(i);
         ++i;
      }

      System.out.print(arr[(Integer)q.getFirst()] + " ");
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

   public static void maxinwindow2(int[] arr, int k) {
      int[] nxtgrtr = new int[arr.length];
      nextgreater(arr, nxtgrtr);
      int j = 0;

      for(int i = 0; i <= nxtgrtr.length - k; ++i) {
         if (j < i) {
            j = i;
         }

         while(nxtgrtr[j] < i + k) {
            j = nxtgrtr[j];
         }

         System.out.print(arr[j] + " ");
      }

   }
}
