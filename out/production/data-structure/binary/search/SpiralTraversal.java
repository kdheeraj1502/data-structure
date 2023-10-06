package binary.search;

import java.util.Stack;

public class SpiralTraversal {
   public static void spiralOrder(Node root) {
      Stack<Node> stack1 = new Stack();
      Stack<Node> stack2 = new Stack();
      if (root != null) {
         stack1.push(root);
      }

      while(stack1.size() > 0 || stack2.size() > 0) {
         int j = stack1.size();

         Node temp;
         while(!stack1.isEmpty()) {
            temp = (Node)stack1.pop();
            System.out.print(temp.val);
            if (temp.right != null) {
               stack2.push(temp.right);
            }

            if (temp.left != null) {
               stack2.push(temp.left);
            }

            --j;
            if (j > 0) {
               System.out.print(", ");
            }
         }

         System.out.println("");
         j = stack2.size();

         while(!stack2.isEmpty()) {
            temp = (Node)stack2.pop();
            System.out.print(temp.val);
            if (temp.left != null) {
               stack1.push(temp.left);
            }

            if (temp.right != null) {
               stack1.push(temp.right);
            }

            --j;
            if (j > 0) {
               System.out.print(", ");
            }
         }

         System.out.println("");
      }

   }
}
