package heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class mergeksortedarrays {
   public static void main(String[] args) {
      int[][] arr = new int[][]{{1, 2, 3, 4}, {2, 2, 3, 4}, {5, 5, 6, 6}, {7, 8, 9, 9}};
      ArrayList<Integer> ans = mergeKArraysoptimised(arr, 4);
      System.out.println(ans);
   }

   public static ArrayList<Integer> mergeKArrays(int[][] arr, int k) {
      PriorityQueue<Integer> heap = new PriorityQueue();

      for(int i = 0; i < k; ++i) {
         for(int j = 0; j < k; ++j) {
            heap.add(arr[i][j]);
         }
      }

      ArrayList<Integer> ans = new ArrayList();

      while(heap.size() > 0) {
         ans.add(heap.remove());
      }

      return ans;
   }

   public static ArrayList<Integer> mergeKArraysoptimised(int[][] arr, int k) {
      PriorityQueue<pair> heap = new PriorityQueue();
      ArrayList<Integer> ans = new ArrayList();

      for(int i = 0; i < arr.length; ++i) {
         heap.add(new pair(0, i, arr[i][0]));
      }

      while(heap.size() > 0) {
         pair rv = (pair)heap.remove();
         ans.add(rv.val);
         int i = rv.i;
         int arrname = rv.arrname;
         if (i + 1 < k) {
            heap.add(new pair(rv.i + 1, rv.arrname, arr[rv.arrname][rv.i + 1]));
         }
      }

      return ans;
   }
}
