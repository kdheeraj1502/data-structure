package stackandqueue;

public class queue {
   private int[] data;
   private static final int defcap = 10;
   private int size;
   private int rear;
   private int front;

   queue() {
      this(10);
   }

   queue(int capacity) {
      this.size = 0;
      this.rear = 0;
      this.front = 0;
      this.data = new int[capacity];
      this.rear = capacity - 1;
   }

   public void enqueue(int val) {
      if (this.size == this.data.length) {
         System.out.println("queue is full");
      } else {
         this.rear = (this.rear + 1) % this.data.length;
         this.data[this.rear] = val;
         ++this.size;
      }
   }

   public int dequeue() {
      if (this.size == 0) {
         System.out.println("queue is empty");
         return -1;
      } else {
         int val = this.data[this.front];
         this.front = (this.front + 1) % this.data.length;
         --this.size;
         return val;
      }
   }

   public void display() {
      int i = this.front;

      for(int c = 0; c < this.size; ++c) {
         System.out.print(this.data[i] + " ");
         i = (i + 1) % this.data.length;
      }

      System.out.println();
   }
}
