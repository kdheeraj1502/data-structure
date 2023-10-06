package stackandqueue;

import java.util.Stack;

public class summinmaxinawindow {
   public static void main(String[] args) {
      int[] arr = new int[]{2, 5, -1, 7, -3, -1, -2};
      int k = 4;
      summinmax(arr, k);
   }

   public static void nextgreater(int[] arr, int[] ans) {
      Stack<Integer> st = new Stack();
      st.push(arr.length - 1);
      ans[arr.length - 1] = arr.length;

      for(int i = arr.length - 2; i >= 0; --i) {
         while(st.size() > 0 && arr[(Integer)st.peek()] <= arr[i]) {
            st.pop();
         }

         if (st.size() == 0) {
            ans[i] = arr.length;
         } else {
            ans[i] = (Integer)st.peek();
         }

         st.push(i);
      }

   }

   public static void nextsmaller(int[] arr, int[] ans) {
      Stack<Integer> st = new Stack();
      st.push(arr.length - 1);
      ans[arr.length - 1] = arr.length;

      for(int i = arr.length - 2; i >= 0; --i) {
         while(st.size() > 0 && arr[(Integer)st.peek()] >= arr[i]) {
            st.pop();
         }

         if (st.size() == 0) {
            ans[i] = arr.length;
         } else {
            ans[i] = (Integer)st.peek();
         }

         st.push(i);
      }

   }

   public static void summinmax(int[] arr, int k) {
      int[] nxtgrtr = new int[arr.length];
      nextgreater(arr, nxtgrtr);
      int[] nxtsmall = new int[arr.length];
      nextsmaller(arr, nxtsmall);
      int sum = 0;
      int maxi = 0;
      int mini = 0;

      for(int i = 0; i <= arr.length - k; ++i) {
         if (maxi < i) {
            maxi = i;
         }

         if (mini < i) {
            mini = i;
         }

         while(nxtgrtr[maxi] < i + k) {
            maxi = nxtgrtr[maxi];
         }

         while(nxtsmall[mini] < i + k) {
            mini = nxtsmall[mini];
         }

         System.out.println(arr[maxi] + "  " + arr[mini]);
         sum += arr[maxi] + arr[mini];
      }

      System.out.println(sum);
   }
}
