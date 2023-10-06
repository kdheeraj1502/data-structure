package heap.or.priorityqueue;

public class BuildMinHeap {
   private static int[] num;
   private int capacity;
   private static int size;

   public BuildMinHeap(int capacity) {
      this.capacity = capacity;
      num = new int[this.capacity];
      size = 0;
   }

   private static int left(int i) {
      return 2 * i + 1;
   }

   private static int right(int i) {
      return 2 * i + 2;
   }

   private static int parent(int i) {
      return (i - 1) / 2;
   }

   public static int getMax() {
      return num[--size];
   }

   public void insert(int val) {
      num[size] = val;
      int current = size;

      for(int parent = parent(current); num[current] < num[parent]; parent = parent(parent)) {
         swap(num, current, parent);
         current = parent;
      }

      ++size;
   }

   private static void heapify(int i) {
      int l = left(i);
      int r = right(i);
      int smallest = i;
      if (l < size && num[l] < num[i]) {
         smallest = l;
      }

      if (r < size && num[r] < num[smallest]) {
         smallest = r;
      }

      if (smallest != i) {
         swap(num, i, smallest);
         heapify(smallest);
      }

   }

   private static void swap(int[] num, int i, int j) {
      int temp = num[i];
      num[i] = num[j];
      num[j] = temp;
   }

   public static int extractMin() {
      if (size == 0) {
         return Integer.MAX_VALUE;
      } else {
         int root = num[0];
         if (size > 0) {
            num[0] = num[size - 1];
            heapify(0);
         }

         --size;
         return root;
      }
   }

   public static void print() {
      for(int i = 0; i <= size / 2; ++i) {
         System.out.print(" PARENT : " + num[i] + " LEFT CHILD : " + (2 * i + 1 < num.length ? num[2 * i + 1] : null) + " RIGHT CHILD :" + (2 * i + 2 < num.length ? num[2 * i + 2] : null));
         System.out.println();
      }

   }

   public static int kthSmallest(int[] num, int k) {
      for(int i = 0; i < k - 1; ++i) {
         System.out.println(" extractMin " + extractMin());
      }

      return extractMin();
   }

   public static void main(String[] arg) {
      System.out.println("The min Heap is ");
      int[] num = new int[]{73, 188, 894, 915, 940, 616, 900, 548};
      BuildMinHeap minHeap = new BuildMinHeap(num.length);
      int[] var3 = num;
      int var4 = num.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         int in = var3[var5];
         minHeap.insert(in);
      }

      System.out.println("ans " + kthSmallest(num, 7));
   }
}
