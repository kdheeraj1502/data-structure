package heap.or.priorityqueue;

public class MinHeap {
   public static int kthSmallest(int[] num, int k) {
      Heap heap = new Heap(num, num.length, (1)null);

      for(int i = 0; i < k - 1; ++i) {
         heap.or.priorityqueue.MinHeap.Heap.access$100(heap);
      }

      return heap.or.priorityqueue.MinHeap.Heap.access$200(heap);
   }

   public static void main(String[] args) {
      int[] num = new int[]{73, 188, 894, 915, 940, 616, 900, 548};
      System.out.println("ans " + kthSmallest(num, 7));

      for(int i = 1; i <= num.length; ++i) {
      }

   }
}
