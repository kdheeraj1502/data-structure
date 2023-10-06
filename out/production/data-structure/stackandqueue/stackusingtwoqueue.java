package stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class stackusingtwoqueue {
   Queue<Integer> q1 = new LinkedList();
   Queue<Integer> q2 = new LinkedList();

   public static void main(String[] args) {
   }

   void push(int a) {
      this.q1.add(a);
   }

   int pop() {
      if (this.q1.isEmpty()) {
         return -1;
      } else {
         while(this.q1.size() != 1) {
            this.q2.add(this.q1.remove());
         }

         int ans = (Integer)this.q1.remove();
         Queue<Integer> temp = this.q1;
         this.q1 = this.q2;
         this.q2 = temp;
         return ans;
      }
   }

   void push1(int a) {
      this.q2.add(a);

      while(!this.q1.isEmpty()) {
         this.q2.add(this.q1.remove());
      }

      Queue<Integer> temp = this.q1;
      this.q1 = this.q2;
      this.q2 = temp;
   }

   int pop1() {
      return this.q1.isEmpty() ? -1 : (Integer)this.q1.remove();
   }
}
