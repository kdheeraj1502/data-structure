package binary.search;

import java.util.ArrayDeque;

public class IsCompleteTree {
   public static boolean isCompleteTree(Node root) {
      ArrayDeque<Node> que = new ArrayDeque();
      int noChild = false;
      if (root != null) {
         que.add(root);
      }

      while(!que.isEmpty()) {
         Node temp = (Node)que.remove();
         if (temp.left != null) {
            if (noChild) {
               return false;
            }

            que.add(temp.left);
         } else {
            noChild = true;
         }

         if (temp.right != null) {
            if (noChild) {
               return false;
            }

            que.add(temp.right);
         } else {
            noChild = true;
         }
      }

      return true;
   }
}
