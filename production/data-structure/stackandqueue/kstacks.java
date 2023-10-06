package stackandqueue;

public class kstacks {
   private int[] data;
   private int[] next;
   private int[] top;
   private int n;
   private int k;
   private int free;

   kstacks(int n, int k) {
      this.n = n;
      this.k = k;
      this.data = new int[this.n];
      this.next = new int[this.n];
      this.top = new int[this.k];

      int i;
      for(i = 0; i < this.top.length; ++i) {
         this.top[i] = -1;
      }

      this.free = 0;

      for(i = 0; i < this.next.length; ++i) {
         this.next[i] = i + 1;
      }

      this.next[n - 1] = -1;
   }

   public boolean isFull() {
      return this.free == -1;
   }

   public boolean isEmpty(int sn) {
      return this.top[sn] == -1;
   }

   public void push(int x, int sn) {
      if (this.isFull()) {
         System.out.println("No available space");
      } else {
         int i = this.free;
         this.free = this.next[i];
         this.next[i] = this.top[sn];
         this.top[sn] = i;
         this.data[i] = x;
      }
   }

   public int pop(int sn) {
      if (this.isEmpty(sn)) {
         System.out.println("Stack Empty");
         return -1;
      } else {
         int i = this.top[sn];
         this.top[sn] = this.next[i];
         this.next[i] = this.free;
         this.free = i;
         return this.data[i];
      }
   }

   public void display(int sn) {
      if (this.isEmpty(sn)) {
         System.out.println("Stack empty");
      } else {
         for(int i = this.top[sn]; i != -1; i = this.next[i]) {
            System.out.print(this.data[i] + " ");
         }

         System.out.println();
      }
   }
}
