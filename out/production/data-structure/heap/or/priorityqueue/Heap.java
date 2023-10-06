package heap.or.priorityqueue;

public class Heap {
   private static final int CAPACITY = 32;
   private int size = 0;
   private int[] arr = new int[32];
   private boolean isMinHeap;

   public Heap(boolean isMin) {
      this.isMinHeap = isMin;
   }

   public boolean isEmpty() {
      return this.size == 0;
   }

   public int size() {
      return this.size;
   }

   public int peek() {
      if (this.isEmpty()) {
         throw new IllegalStateException();
      } else {
         return this.arr[0];
      }
   }

   public static void main(String[] args) {
      int g = 16;

      int count;
      for(count = 0; g > 0; ++count) {
         g &= g - 1;
      }

      System.out.println("1 count is " + count);

      int n;
      for(n = 0; g > 0; ++n) {
         g /= 10;
      }

      System.out.println(n);
      String key = "Dheeraj";
      int h = key.hashCode();
      System.out.println("h is " + h);
      System.out.println((h = key.hashCode()) ^ h >>> 16);
      System.out.println("Only shift " + (h >>> 16));
      int m = 65536;
      int div = h / m;
      System.out.println("new shift is " + (h ^ div));
      System.out.println("Shift 1 " + (h ^ h >>> 16));
      System.out.println("Shift 1 " + (h ^ '쑞'));
      System.out.println(" 2 ^1 3");
      System.out.println(128);
      System.out.println(2);
   }
}
