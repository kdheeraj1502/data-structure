package binary.search;

import java.util.LinkedList;
import java.util.Queue;

public class IsSameTree {
   public boolean isSameTree(TreeNode p, TreeNode q) {
      if (p == null && q == null) {
         return true;
      } else if (p == null && q == null) {
         return this.isSameTree(p.left, q.left) && this.isSameTree(p.right, q.right) && p.val != q.val;
      } else {
         return false;
      }
   }

   static boolean areIdentical(TreeNode root1, TreeNode root2) {
      if (root1 == null && root2 == null) {
         return true;
      } else if (root1 != null && root2 != null) {
         Queue<TreeNode> q1 = new LinkedList();
         Queue<TreeNode> q2 = new LinkedList();
         q1.add(root1);
         q2.add(root2);

         while(true) {
            if (!q1.isEmpty() && !q2.isEmpty()) {
               TreeNode n1 = (TreeNode)q1.peek();
               TreeNode n2 = (TreeNode)q2.peek();
               if (n1.val != n2.val) {
                  return false;
               }

               q1.remove();
               q2.remove();
               if (n1.left != null && n2.left != null) {
                  q1.add(n1.left);
                  q2.add(n2.left);
               } else if (n1.left != null || n2.left != null) {
                  return false;
               }

               if (n1.right != null && n2.right != null) {
                  q1.add(n1.right);
                  q2.add(n2.right);
                  continue;
               }

               if (n1.right == null && n2.right == null) {
                  continue;
               }

               return false;
            }

            return true;
         }
      } else {
         return false;
      }
   }
}
