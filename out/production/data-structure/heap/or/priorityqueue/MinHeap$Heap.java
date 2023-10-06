package heap.or.priorityqueue;

class MinHeap$Heap {
   int[] num;
   int capacity;
   int size;

   private MinHeap$Heap(int[] num, int size) {
      this.size = size;
      this.num = num;

      for(int i = (size - 1) / 2; i >= 0; --i) {
         this.minHeapify(i);
      }

   }

   private int parent(int i) {
      return (i - 1) / 2;
   }

   private int left(int i) {
      return 2 * i + 1;
   }

   private int right(int i) {
      return 2 * i + 2;
   }

   private int getMin() {
      return this.num[0];
   }

   private int extractMin() {
      if (this.size == 0) {
         return Integer.MAX_VALUE;
      } else {
         int root = this.num[0];
         if (this.size > 1) {
            this.num[0] = this.num[this.size - 1];
            this.minHeapify(0);
         }

         --this.size;
         return root;
      }
   }

   private void minHeapify(int i) {
      int l = this.left(i);
      int r = this.right(i);
      int smallest = i;
      if (l < this.size && this.num[l] < this.num[i]) {
         smallest = l;
      }

      if (r < this.size && this.num[r] < this.num[smallest]) {
         smallest = r;
      }

      if (smallest != i) {
         int t = this.num[i];
         this.num[i] = this.num[smallest];
         this.num[smallest] = t;
         this.minHeapify(smallest);
      }

   }

   // $FF: synthetic method
   MinHeap$Heap(int[] x0, int x1, MinHeap.1 x2) {
      this(x0, x1);
   }

   // $FF: synthetic method
   static int access$100(MinHeap$Heap x0) {
      return x0.extractMin();
   }

   // $FF: synthetic method
   static int access$200(MinHeap$Heap x0) {
      return x0.getMin();
   }
}
