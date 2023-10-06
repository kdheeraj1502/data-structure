package binary.search;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeDepth {
   public static int treeDepth(Node root) {
      if (root == null) {
         return 0;
      } else {
         int left = treeDepth(root.left);
         int right = treeDepth(root.right);
         return Math.max(left, right) + 1;
      }
   }

   public static int treeDepthWithoutRecursion(Node root) {
      Node curr = root;
      Queue<Node> que = new ArrayDeque();
      que.add(root);

      int depth;
      for(depth = 0; !que.isEmpty(); ++depth) {
         for(int j = que.size(); j > 0; --j) {
            if (!que.isEmpty()) {
               curr = (Node)que.remove();
            }
         }

         if (curr.left != null) {
            que.add(curr.left);
         }

         if (curr.right != null) {
            que.add(curr.right);
         }
      }

      return depth;
   }
}
