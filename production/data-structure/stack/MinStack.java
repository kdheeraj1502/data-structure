package stack;

import java.util.Stack;

public class MinStack {
   Stack<Integer> st = new Stack();
   Stack<Integer> mn = new Stack();

   public void push(int val) {
      if (this.st.isEmpty() || val <= (Integer)this.mn.peek()) {
         this.mn.push(val);
      }

      this.st.push(val);
   }

   public void pop() {
      if (((Integer)this.st.peek()).equals(this.mn.peek())) {
         this.mn.pop();
      }

      this.st.pop();
   }

   private int getMin() {
      return (Integer)this.mn.peek();
   }

   private int top() {
      return (Integer)this.st.peek();
   }

   public static void main(String[] args) {
      MinStack minStack = new MinStack();
      minStack.push(5);
      minStack.push(6);
      minStack.push(4);
      minStack.push(7);
      minStack.push(5);
      minStack.push(3);
      int param1 = minStack.getMin();
      minStack.pop();
      int param2 = minStack.top();
      int param3 = minStack.getMin();
      System.out.println(param1);
      System.out.println(param2);
      System.out.println(param3);
   }
}
