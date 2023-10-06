package heap.or.priorityqueue;

public class MaxHeap {
   int[] num;
   int size;
   int maxSize;

   public MaxHeap(int maxSize) {
      this.maxSize = maxSize;
      this.num = new int[this.maxSize];
      this.size = 0;
   }

   private int parent(int i) {
      return (i - 1) / 2;
   }

   private int leftChild(int i) {
      return 2 * i + 1;
   }

   private int rightChild(int i) {
      return 2 * i + 2;
   }

   private boolean isLeaf(int pos) {
      return pos > this.size / 2 && pos <= this.size;
   }

   private void swap(int i, int j) {
      int tmp = this.num[i];
      this.num[i] = this.num[j];
      this.num[j] = tmp;
   }

   private void maxHeapify(int i) {
      if (!this.isLeaf(i)) {
         int max = i;
         int left = this.leftChild(i);
         int right = this.rightChild(i);
         if (left < this.num.length && this.num[left] > this.num[i]) {
            max = left;
         }

         if (right < this.num.length && this.num[right] > this.num[i]) {
            max = right;
         }

         if (max != i) {
            this.swap(i, max);
            this.maxHeapify(max);
         }

      }
   }

   public void insert(int element) {
      this.num[this.size] = element;

      for(int current = this.size; this.num[current] > this.num[this.parent(current)]; current = this.parent(current)) {
         this.swap(current, this.parent(current));
      }

      ++this.size;
   }

   public void print() {
      for(int i = 0; i <= this.size / 2; ++i) {
         System.out.print(" PARENT : " + this.num[i] + " LEFT CHILD : " + (2 * i + 1 < this.num.length ? this.num[2 * i + 1] : null) + " RIGHT CHILD :" + (2 * i + 2 < this.num.length ? this.num[2 * i + 2] : null));
         System.out.println();
      }

   }

   public int extractMax() {
      int popped = this.num[0];
      this.num[0] = this.num[--this.size];
      this.maxHeapify(0);
      return popped;
   }

   public static void main(String[] arg) {
      System.out.println("The Max Heap is ");
      int[] num = new int[]{1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
      MaxHeap maxHeap = new MaxHeap(num.length);
      int[] var3 = num;
      int var4 = num.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         int in = var3[var5];
         maxHeap.insert(in);
      }

      maxHeap.print();
      System.out.println("The max val is " + maxHeap.extractMax());
   }
}
