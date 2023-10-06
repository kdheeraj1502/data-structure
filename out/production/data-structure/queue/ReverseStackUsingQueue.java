package queue;

import java.util.ArrayDeque;
import java.util.Stack;

public class ReverseStackUsingQueue {
   private ArrayDeque<Integer> queue = new ArrayDeque();

   ReverseStackUsingQueue() {
   }

   public void reverse(Stack<Integer> stack) {
      while(!stack.isEmpty()) {
         this.queue.add(stack.pop());
      }

      while(!this.queue.isEmpty()) {
         stack.push(this.queue.remove());
      }

   }

   public void reverseUsingArray(Stack<Integer> stack) {
      int[] arr = new int[stack.size()];

      for(int index = 0; !stack.isEmpty(); arr[index++] = (Integer)stack.pop()) {
      }

      for(int i = 0; i < arr.length; ++i) {
         stack.push(arr[i]);
      }

   }

   public static void main(String[] args) {
      ReverseStackUsingQueue rsuq = new ReverseStackUsingQueue();
      Stack<Integer> stack = new Stack();
      stack.push(56);
      stack.push(77);
      stack.push(51);
      stack.push(91);
      stack.push(23);
      System.out.println(stack);
      rsuq.reverse(stack);
      System.out.println(stack);
      rsuq.reverseUsingArray(stack);
      System.out.println(stack);
   }
}
