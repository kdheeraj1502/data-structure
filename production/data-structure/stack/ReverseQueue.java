package stack;

import java.util.ArrayDeque;
import java.util.Stack;

public class ReverseQueue {
   public static void reverseQueue(ArrayDeque<Integer> queue) {
      Stack<Integer> stack = new Stack();

      while(!queue.isEmpty()) {
         stack.push(queue.remove());
      }

      while(!stack.isEmpty()) {
         queue.add(stack.pop());
      }

   }

   public static void reverseKELeInQueue(ArrayDeque<Integer> queue, int k) {
      Stack<Integer> stack = new Stack();

      for(int i = k; i > 0; --i) {
         stack.push(queue.remove());
      }

      while(!stack.isEmpty()) {
         queue.add(stack.pop());
      }

      for(int diff = queue.size() - k; diff > 0; --diff) {
         int temp = (Integer)queue.remove();
         queue.add(temp);
      }

   }
}
