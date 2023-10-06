package binnarytree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class levelorder {
   public static void levelorder(Node parent) {
      Queue<Node> queue = new ArrayDeque();
      queue.add(parent);

      while(!queue.isEmpty()) {
         Node temp = (Node)queue.remove();
         System.out.print(temp.data + " ");
         if (temp.left != null) {
            queue.add(temp.left);
         }

         if (temp.right != null) {
            queue.add(temp.right);
         }
      }

   }

   public static void reverseLevelorder(Node parent) {
      Queue<Node> queue = new ArrayDeque();
      Stack<Node> stack = new Stack();
      queue.add(parent);

      Node temp;
      while(!queue.isEmpty()) {
         temp = (Node)queue.remove();
         stack.push(temp);
         if (temp.right != null) {
            queue.add(temp.right);
         }

         if (temp.left != null) {
            queue.add(temp.left);
         }
      }

      while(!stack.isEmpty()) {
         temp = (Node)stack.pop();
         System.out.print(temp.data + " ,");
      }

   }

   public static void main(String[] args) {
      Node root = new Node(10);
      root.left = new Node(20);
      root.right = new Node(30);
      root.right.right = new Node(70);
      root.left.left = new Node(40);
      root.left.right = new Node(60);
      levelorder(root);
      System.out.println();
      reverseLevelorder(root);
   }
}
