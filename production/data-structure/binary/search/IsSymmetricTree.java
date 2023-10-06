package binary.search;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetricTree {
   public boolean isSymmetricIteration(TreeNode root) {
      if (root == null) {
         return true;
      } else {
         Queue<TreeNode> leftQueue = new LinkedList();
         Queue<TreeNode> rightQueue = new LinkedList();
         leftQueue.add(root.left);
         rightQueue.add(root.right);

         while(true) {
            if (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
               TreeNode nodeLeft = (TreeNode)leftQueue.peek();
               TreeNode nodeRight = (TreeNode)rightQueue.peek();
               leftQueue.remove();
               rightQueue.remove();
               if (nodeLeft == null && nodeRight == null) {
                  return true;
               }

               if (nodeLeft != null && nodeRight != null) {
                  if (nodeLeft.val != nodeRight.val) {
                     return false;
                  }

                  if (nodeLeft.left != null && nodeRight.right != null) {
                     leftQueue.add(nodeLeft.left);
                     rightQueue.add(nodeRight.right);
                  } else if (nodeLeft.left != null || nodeRight.right != null) {
                     return false;
                  }

                  if (nodeLeft.right != null && nodeRight.left != null) {
                     leftQueue.add(nodeLeft.right);
                     rightQueue.add(nodeRight.left);
                     continue;
                  }

                  if (nodeLeft.right == null && nodeRight.left == null) {
                     continue;
                  }

                  return false;
               }

               return false;
            }

            return true;
         }
      }
   }

   public boolean isSymmetriRecursion(TreeNode root) {
      return this.isSymmetriRecursion(root.left, root.right);
   }

   public boolean isSymmetriRecursion(TreeNode root1, TreeNode root2) {
      if (root1 == null && root2 == null) {
         return true;
      } else if (root1 != null && root2 != null) {
         return root1.val == root2.val && this.isSymmetriRecursion(root1.left, root2.right) && this.isSymmetriRecursion(root1.right, root2.left);
      } else {
         return false;
      }
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      IsSymmetricTree ist = new IsSymmetricTree();
      System.out.println(ist.isSymmetriRecursion(root));
   }
}
