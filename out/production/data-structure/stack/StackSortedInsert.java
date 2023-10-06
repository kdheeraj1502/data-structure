package stack;

import java.util.Stack;

public class StackSortedInsert {
   public void sortedInsert(Stack<Integer> stack, int val) {
      if (!stack.isEmpty() && val <= (Integer)stack.peek()) {
         int temp = (Integer)stack.pop();
         this.sortedInsert(stack, val);
         stack.push(temp);
      } else {
         stack.push(val);
      }

   }

   public void sortStack(Stack<Integer> stack) {
      if (!stack.isEmpty()) {
         int temp = (Integer)stack.pop();
         this.sortStack(stack);
         this.sortedInsert(stack, temp);
      }

   }

   public Stack<Integer> sortStackIteration(Stack<Integer> stack) {
      Stack<Integer> stk = new Stack();

      while(!stack.isEmpty()) {
         int temp = (Integer)stack.pop();
         this.sortedInsert(stk, temp);
      }

      return stk;
   }

   public static Stack<Integer> sortStackGEEK(Stack<Integer> input) {
      Stack<Integer> tmpStack = new Stack();

      while(!input.isEmpty()) {
         int tmp = (Integer)input.pop();

         while(!tmpStack.isEmpty() && (Integer)tmpStack.peek() > tmp) {
            input.push(tmpStack.pop());
         }

         tmpStack.push(tmp);
      }

      return tmpStack;
   }

   public static Stack<Integer> sortStackGEEKSelf(Stack<Integer> input) {
      Stack<Integer> tmpStack = new Stack();

      while(!input.isEmpty()) {
         int temp = (Integer)input.pop();

         while(!tmpStack.isEmpty() && (Integer)tmpStack.peek() > temp) {
            input.push(tmpStack.pop());
         }

         tmpStack.push(temp);
      }

      return tmpStack;
   }
}
