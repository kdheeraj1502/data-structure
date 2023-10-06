package queue;

import java.util.Stack;

public class QueueUsingStack {
   private Stack<Integer> stack1 = new Stack();
   private Stack<Integer> stack2 = new Stack();

   public void add(int val) {
      this.stack1.push(val);
   }

   public int remove() {
      if (!this.stack2.isEmpty()) {
         return (Integer)this.stack2.pop();
      } else {
         while(!this.stack1.isEmpty()) {
            this.stack2.add(this.stack1.pop());
         }

         return (Integer)this.stack2.pop();
      }
   }

   public static void main(String[] args) {
      QueueUsingStack qus = new QueueUsingStack();
      qus.add(86);
      qus.add(78);
      qus.add(45);
      System.out.println(qus.remove());
      System.out.println(qus.remove());
   }
}
