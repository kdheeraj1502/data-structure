package stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class firstnegative {
   public static void main(String[] args) {
      int[] var10000 = new int[]{12, -1, -7, 8, -15, 30, 16, 28};
      int k = true;
   }

   public long[] printFirstNegativeInteger(long[] arr, int N, int K) {
      Queue<Integer> q = new LinkedList();
      long[] ans = new long[N - K + 1];
      int k = 0;

      int i;
      for(i = 0; i < K; ++i) {
         if (arr[i] < 0L) {
            q.add(i);
         }
      }

      for(; i < arr.length; ++i) {
         if (q.size() == 0) {
            ans[k++] = 0L;
         } else {
            ans[k++] = arr[(Integer)q.peek()];
         }

         while(!q.isEmpty() && (Integer)q.peek() <= i - K) {
            q.remove();
         }

         if (arr[i] < 0L) {
            q.add(i);
         }
      }

      if (q.size() == 0) {
         ans[k++] = 0L;
      } else {
         ans[k++] = arr[(Integer)q.peek()];
      }

      return ans;
   }
}
