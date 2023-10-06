package heap;

public class convertmintomaxheap {
   public static void main(String[] args) {
      new minheap();
      int[] arr = new int[]{3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
      int n = arr.length;

      int i;
      for(i = (n - 2) / 2; i >= 0; --i) {
         maxheapify(arr, i, n);
      }

      for(i = 0; i < arr.length; ++i) {
         System.out.println(arr[i]);
      }

   }

   public static void maxheapify(int[] heap, int pi, int n) {
      int lc = 2 * pi + 1;
      int rc = 2 * pi + 2;
      int maxi = pi;
      if (lc < n && heap[pi] < heap[lc]) {
         maxi = lc;
      }

      if (rc < n && heap[maxi] < heap[rc]) {
         maxi = rc;
      }

      if (maxi != pi) {
         int temp = heap[pi];
         heap[pi] = heap[maxi];
         heap[maxi] = temp;
         maxheapify(heap, maxi, n);
      }

   }
}
