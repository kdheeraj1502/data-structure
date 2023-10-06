package binary.search;

import java.util.Stack;

public class RecoverTree {
   static TreeNode last;
   static TreeNode n1;
   static TreeNode n2;

   public static void recoverTree(TreeNode root) {
      dfs(root);
      int temp = n1.val;
      n1.val = n2.val;
      n2.val = temp;
   }

   private static void dfs(TreeNode root) {
      if (root != null) {
         dfs(root.left);
         if (last != null && root.val <= last.val) {
            if (n1 == null) {
               n1 = last;
               n2 = root;
            } else {
               n2 = root;
            }
         }

         last = root;
         dfs(root.right);
      }
   }

   public static void main(String[] args) {
      TreeNode node = new TreeNode(1);
      node.left = new TreeNode(3);
      node.left.right = new TreeNode(2);
      recoverTree(node);
      Stack<TreeNode> stack = new Stack();
      stack.add(n2);

      while(!stack.isEmpty()) {
         TreeNode n = (TreeNode)stack.pop();
         if (n.left != null) {
            stack.push(n.left);
         }

         System.out.print(n.val + ", ");
         if (n.right != null) {
            stack.push(n.right);
         }
      }

   }
}
