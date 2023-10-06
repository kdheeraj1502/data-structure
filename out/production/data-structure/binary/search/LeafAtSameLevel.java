package binary.search;

import java.util.LinkedList;
import java.util.Queue;

public class LeafAtSameLevel {
   public static boolean check(Node root) {
      Queue<Node> queue = new LinkedList();
      queue.add(root);
      int level = 0;
      int result = Integer.MAX_VALUE;

      while(!queue.isEmpty()) {
         int size = queue.size();
         ++level;

         while(size-- > 0) {
            Node temp = (Node)queue.remove();
            if (temp.left != null) {
               queue.add(temp.left);
               if (temp.left.left == null && temp.left.right == null) {
                  if (result == Integer.MAX_VALUE) {
                     result = level;
                  } else if (result != level) {
                     return false;
                  }
               }
            }

            if (temp.right != null) {
               queue.add(temp.right);
               if (temp.right.left == null && temp.right.right == null) {
                  if (result == Integer.MAX_VALUE) {
                     result = level;
                  } else if (result != level) {
                     return false;
                  }
               }
            }
         }
      }

      return true;
   }
}
