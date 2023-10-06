package array;

import java.util.PriorityQueue;

public class kthmaxmin {
   public static void main(String[] args) {
      int[] arr = new int[]{1, 8, 3, 7, 2, 6, 9, 5, 4, 21};
      int k = 4;
      --k;
      int p = partition(arr, 0, arr.length - 1, arr[arr.length - 1]);

      while(p != k) {
         if (p > k) {
            p = partition(arr, 0, p - 1, arr[p - 1]);
         } else if (p < k) {
            p = partition(arr, p + 1, arr.length - 1, arr[arr.length - 1]);
         }
      }

      int i;
      for(i = 0; i < arr.length; ++i) {
         System.out.println(arr[i]);
      }

      System.out.println("kth smallest - > " + arr[p]);
      quicksort(arr, 0, arr.length - 1);

      for(i = 0; i < arr.length; ++i) {
         System.out.println(arr[i]);
      }

   }

   public static int partition(int[] arr, int start, int end, int pivot) {
      int i = start;
      int j = start;

      while(j <= end) {
         if (arr[j] > pivot) {
            ++j;
         } else {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            ++i;
            ++j;
         }
      }

      return i - 1;
   }

   public static void quicksort(int[] arr, int start, int end) {
      if (start < end) {
         int p = partition(arr, start, end, arr[end]);
         quicksort(arr, start, p - 1);
         quicksort(arr, p + 1, end);
      }
   }

   public static int KthMaximum(int[] a, int k) {
      PriorityQueue<Integer> pq = new PriorityQueue();

      for(int i = 0; i < a.length; ++i) {
         if (i < k) {
            pq.add(a[i]);
         } else if (a[i] > (Integer)pq.peek()) {
            pq.remove();
            pq.add(a[i]);
         }
      }

      return (Integer)pq.peek();
   }
}
