package binary.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
   public static void preOrder(Node root) {
      if (root != null) {
         System.out.print(root.val + ", ");
         preOrder(root.left);
         preOrder(root.right);
      }

   }

   public static void preOrderIterative(Node root) {
      Stack<Node> stack = new Stack();
      stack.push(root);

      while(stack.size() > 0) {
         Node temp = (Node)stack.pop();
         System.out.print(temp.val + ", ");
         if (temp.right != null) {
            stack.push(temp.right);
         }

         if (temp.left != null) {
            stack.push(temp.left);
         }
      }

   }

   public static List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList();
      if (root == null) {
         return result;
      } else {
         Stack<TreeNode> stack = new Stack();
         stack.push(root);

         while(!stack.isEmpty()) {
            TreeNode node = (TreeNode)stack.pop();
            result.add(node.val);
            if (node.right != null) {
               stack.push(node.right);
            }

            if (node.left != null) {
               stack.push(node.left);
            }
         }

         return result;
      }
   }

   public static List<Integer> preorderTraversal_1(TreeNode root) {
      List<Integer> result = new ArrayList();
      Stack<TreeNode> stack = new Stack();
      stack.push(root);

      while(!stack.isEmpty()) {
         TreeNode node = (TreeNode)stack.pop();
         result.add(node.val);
         if (node.right != null) {
            stack.push(node.right);
         }

         if (node.left != null) {
            stack.push(node.left);
         }
      }

      return result;
   }

   public static List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList();
      Stack<TreeNode> stack = new Stack();
      stack.push(root);

      while(!stack.isEmpty()) {
         TreeNode node = (TreeNode)stack.pop();
         result.add(node.val);
         if (node.right != null) {
            stack.push(node.right);
         }

         if (node.left != null) {
            stack.push(node.left);
         }
      }

      return result;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);
      root.left.left.right = new TreeNode(8);
      root.right = new TreeNode(3);
      root.right.right = new TreeNode(7);
      root.right.left = new TreeNode(6);
      System.out.println(preorderTraversal_1(root));
   }
}
