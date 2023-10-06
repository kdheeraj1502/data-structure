package queue;

import java.util.ArrayDeque;

public class StackUsing2Queue {
   private ArrayDeque<Integer> queue1 = new ArrayDeque();
   private ArrayDeque<Integer> queue2 = new ArrayDeque();

   public void push(int val) {
      if (!this.queue1.isEmpty()) {
         this.queue1.add(val);
      } else {
         this.queue1 = new ArrayDeque();
         this.queue1.add(val);
      }

   }

   public int pop() {
      if (!this.queue2.isEmpty()) {
         return (Integer)this.queue2.remove();
      } else {
         while(!this.queue1.isEmpty()) {
            this.queue2.add(this.queue1.remove());
         }

         return (Integer)this.queue2.remove();
      }
   }

   public static void main(String[] args) {
      StackUsing2Queue suq = new StackUsing2Queue();
      suq.push(86);
      suq.push(78);
      suq.push(45);
      System.out.println(suq.pop());
      System.out.println(suq.pop());
   }
}
