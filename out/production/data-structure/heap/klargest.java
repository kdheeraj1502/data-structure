package heap;

public class klargest {
   public static void main(String[] args) {
      int[] arr = new int[]{3, 2, 1, 5, 6, 4};
      int k = 3;
      largest(arr, k);
   }

   public static void largest(int[] arr, int k) {
      minheap heap = new minheap();

      for(int i = 0; i < arr.length; ++i) {
         if (i < k) {
            heap.add(arr[i]);
         } else if ((Integer)heap.heap.get(0) < arr[i]) {
            heap.remove();
            heap.add(arr[i]);
         }
      }

      while(heap.heap.size() > 0) {
         System.out.println(heap.remove());
      }

   }
}
