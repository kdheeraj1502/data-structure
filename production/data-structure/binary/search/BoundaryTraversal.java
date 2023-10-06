package binary.search;

import java.util.ArrayList;

public class BoundaryTraversal {
   static Node root;

   static void printLeaves(Node node, ArrayList<Integer> result) {
      if (node != null) {
         printLeaves(node.left, result);
         if (node.left == null && node.right == null) {
            result.add(node.data);
         }

         printLeaves(node.right, result);
      }
   }

   static void printBoundaryLeft(Node node, ArrayList<Integer> result) {
      if (node != null) {
         if (node.left != null) {
            result.add(node.data);
            printBoundaryLeft(node.left, result);
         } else if (node.right != null) {
            result.add(node.data);
            printBoundaryLeft(node.right, result);
         }

      }
   }

   static void printBoundaryRight(Node node, ArrayList<Integer> result) {
      if (node != null) {
         if (node.right != null) {
            printBoundaryRight(node.right, result);
            result.add(node.data);
         } else if (node.left != null) {
            printBoundaryRight(node.left, result);
            result.add(node.data);
         }

      }
   }

   static ArrayList<Integer> boundary(Node node) {
      ArrayList<Integer> result = new ArrayList();
      if (node == null) {
         return result;
      } else {
         result.add(node.data);
         printBoundaryLeft(node.left, result);
         printLeaves(node.left, result);
         printLeaves(node.right, result);
         printBoundaryRight(node.right, result);
         return result;
      }
   }

   public static void main(String[] args) {
      root = new Node(4);
      root.left = new Node(10);
      root.left.left = new Node(5);
      root.left.right = new Node(5);
      root.left.left.right = new Node(6);
      root.left.right.left = new Node(7);
      root.left.left.right.left = new Node(8);
      root.left.left.right.right = new Node(8);
      root.left.right.left.right = new Node(8);
      root.left.left.right.left.left = new Node(11);
      root.left.left.right.right.left = new Node(3);
      root.left.left.right.right.right = new Node(4);
      root.left.right.left.right.right = new Node(1);
      root.left.left.right.left.left.left = new Node(3);
      root.left.left.right.right.left.left = new Node(8);
      root.left.left.right.right.left.right = new Node(6);
      root.left.left.right.right.right.right = new Node(11);
      root.left.right.left.right.right.left = new Node(11);
      root.left.left.right.left.left.left.left = new Node(5);
      root.left.left.right.left.left.left.right = new Node(8);
      System.out.println(boundary(root));
   }
}
