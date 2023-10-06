package binnarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class reverselevelorder {
   public ArrayList<Integer> reverseLevelOrder(Node parent) {
      LinkedList<Node> queue = new LinkedList();
      ArrayList<Integer> ans = new ArrayList();
      Stack<Integer> stack = new Stack();
      queue.addLast(parent);

      while(!queue.isEmpty()) {
         Node rv = (Node)queue.removeFirst();
         stack.push(rv.data);
         if (rv.right != null) {
            queue.addLast(rv.right);
         }

         if (rv.left != null) {
            queue.addLast(rv.left);
         }
      }

      while(!stack.empty()) {
         ans.add(stack.pop());
      }

      return ans;
   }

   public static void main(String[] args) {
   }
}
