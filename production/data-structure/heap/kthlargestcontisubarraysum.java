package heap;

import java.util.PriorityQueue;

public class kthlargestcontisubarraysum {
   public static void main(String[] args) {
      int[] a = new int[]{20, -5, -1};
      subarray(a, 1);
   }

   public static void subarray(int[] arr, int k) {
      int c = false;
      int[] presum = new int[arr.length + 1];
      presum[1] = arr[0];
      System.out.println(presum[1]);

      for(int i = 2; i <= arr.length; ++i) {
         presum[i] = presum[i - 1] + arr[i - 1];
         System.out.println(presum[i]);
      }

      PriorityQueue<Integer> heap = new PriorityQueue();

      for(int i = 1; i <= arr.length; ++i) {
         for(int j = i; j <= arr.length; ++j) {
            int sum = presum[j] - presum[i - 1];
            if (heap.size() < k) {
               heap.add(sum);
            } else if ((Integer)heap.peek() < sum) {
               heap.remove();
               heap.add(sum);
            }
         }
      }

      System.out.println();
      System.out.println(heap.remove());
   }
}
