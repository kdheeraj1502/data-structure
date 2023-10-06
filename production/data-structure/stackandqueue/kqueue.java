package stackandqueue;

public class kqueue {
   private int[] data;
   private int[] next;
   private int[] front;
   private int[] rear;
   private int free;

   kqueue(int n, int k) {
      this.data = new int[n];
      this.next = new int[n];
      this.front = new int[k];
      this.rear = new int[k];

      int i;
      for(i = 0; i < this.front.length; ++i) {
         this.front[i] = -1;
         this.rear[i] = -1;
      }

      this.free = 0;

      for(i = 0; i < this.next.length; ++i) {
         this.next[i] = i + 1;
      }

      this.next[n - 1] = -1;
   }

   public boolean isfull() {
      return this.free == -1;
   }

   public boolean isEmpty(int qn) {
      return this.front[qn] == -1;
   }

   public void add(int val, int qn) {
      if (this.isfull()) {
         System.out.println("queue is full");
      } else {
         int nextFree = this.next[this.free];
         if (this.isEmpty(qn)) {
            this.rear[qn] = this.front[qn] = this.free;
         } else {
            this.next[this.rear[qn]] = this.free;
            this.rear[qn] = this.free;
         }

         this.next[this.free] = -1;
         this.data[this.free] = val;
         this.free = nextFree;
      }
   }

   public int remove(int qn) {
      if (this.isEmpty(qn)) {
         System.out.println("queue is empty");
         return -1;
      } else {
         int i = this.front[qn];
         this.front[qn] = this.next[i];
         this.next[i] = this.free;
         this.free = i;
         return this.data[i];
      }
   }

   public void display(int qn) {
      if (this.isEmpty(qn)) {
         System.out.println("queue is empty");
      } else {
         for(int i = this.front[qn]; i != -1; i = this.next[i]) {
            System.out.print(this.data[i] + " ");
         }

         System.out.println();
      }
   }
}
