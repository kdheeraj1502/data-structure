package binary.search;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
   public static Node invertTree_recursion1(Node root) {
      if (root == null) {
         return root;
      } else {
         invertTree_recursion1(root.left);
         invertTree_recursion1(root.right);
         Node temp = root.left;
         root.left = root.right;
         root.right = temp;
         return root;
      }
   }

   public static Node invertTree_recursion2(Node root) {
      if (root == null) {
         return null;
      } else {
         Node newRoot = new Node(root.val);
         newRoot.left = invertTree_recursion2(root.right);
         newRoot.right = invertTree_recursion2(root.left);
         return newRoot;
      }
   }

   public static Node invertTree_iteration(Node root) {
      if (root == null) {
         return null;
      } else {
         Queue<Node> queue = new LinkedList();
         queue.add(root);

         while(!queue.isEmpty()) {
            Node temp = (Node)queue.poll();
            if (temp != null) {
               Node temp1 = temp.left;
               temp.left = temp.right;
               temp.right = temp1;
               queue.add(temp.left);
               queue.add(temp.right);
            }
         }

         return root;
      }
   }

   public static void main(String[] args) {
      Node root = new Node(16);
      root.left = new Node(12);
      root.right = new Node(20);
      root.left.left = new Node(10);
      root.left.right = new Node(14);
      root.right.left = new Node(18);
      root.right.right = new Node(22);
      root.left.left.left = new Node(7);
      root.left.left.right = new Node(11);
      root.left.right.left = new Node(13);
      root.left.right.right = new Node(15);
      root.right.left.left = new Node(17);
      root.right.left.right = new Node(19);
      root.right.right.left = new Node(21);
      root.right.right.right = new Node(23);
      invertTree_recursion1(root);
   }
}
