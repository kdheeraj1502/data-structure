package heap.or.priorityqueue;

public class MinHeapBuild2 {
   private int[] heap;
   private int size;
   private int capacity;

   public MinHeapBuild2(int capacity) {
      this.capacity = capacity;
      this.size = 0;
      this.heap = new int[this.capacity];
   }

   private int left(int i) {
      return 2 * i + 1;
   }

   private int right(int i) {
      return 2 * i + 2;
   }

   private int parent(int i) {
      return (i - 1) / 2;
   }

   private void swap(int[] num, int i, int j) {
      int temp = num[i];
      num[i] = num[j];
      num[j] = temp;
   }

   public void insert(int val) {
      this.heap[this.size] = val;
      int current = this.size;

      for(int parent = this.parent(current); this.heap[current] < this.heap[parent]; parent = this.parent(parent)) {
         this.swap(this.heap, current, parent);
         current = parent;
      }

      ++this.size;
   }

   public void heapify(int i) {
      int small = i;
      int left = this.left(i);
      int right = this.right(i);
      if (left < this.size && this.heap[left] < this.heap[i]) {
         small = left;
      }

      if (right < this.size && this.heap[right] < this.heap[small]) {
         small = right;
      }

      if (small != i) {
         this.swap(this.heap, small, i);
         this.heapify(small);
      }

   }

   public int extractMin() {
      int root = this.heap[0];
      if (this.size > 0) {
         this.heap[0] = this.heap[this.size - 1];
         this.heapify(0);
      }

      --this.size;
      return root;
   }

   public int kthSmallest(int k) {
      for(int i = 0; i < k - 1; ++i) {
         this.extractMin();
      }

      return this.extractMin();
   }

   public void print() {
      for(int i = 0; i <= this.heap.length / 2; ++i) {
         System.out.println("PARENT : " + this.heap[i] + " LEFT CHILD : " + (2 * i + 1 < this.heap.length ? this.heap[2 * i + 1] : null) + " RIGHT CHILD : " + (2 * i + 2 < this.heap.length ? this.heap[2 * i + 2] : null));
      }

   }

   public static void main(String[] args) {
      int[] num = new int[]{73, 188, 894, 915, 940, 616, 900, 548};
      MinHeapBuild2 minHeapBuild2 = new MinHeapBuild2(num.length);
      int[] var3 = num;
      int var4 = num.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         int in = var3[var5];
         minHeapBuild2.insert(in);
      }

      minHeapBuild2.print();
      System.out.println(minHeapBuild2.kthSmallest(7));
   }
}
