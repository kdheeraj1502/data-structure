package heap;

import java.util.PriorityQueue;

public class connectropes {
   public static void main(String[] args) {
      long[] arr = new long[]{4L, 3L, 2L, 6L};
      System.out.println(minCost(arr, 4));
   }

   public static long minCost(long[] arr, int n) {
      PriorityQueue<Long> heap = new PriorityQueue();

      for(int i = 0; i < arr.length; ++i) {
         heap.add(arr[i]);
      }

      long a;
      long b;
      Long ans;
      for(ans = 0L; heap.size() > 1; ans = ans + a + b) {
         a = (Long)heap.remove();
         b = (Long)heap.remove();
         heap.add(a + b);
      }

      return ans;
   }
}
