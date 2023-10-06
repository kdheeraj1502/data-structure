package binnarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class TopView_self {
   private static Node root;

   public static void main(String[] args) {
      root = new Node(1);
      root.right = new Node(2);
      System.out.println(topView(root));
   }

   static ArrayList<Integer> topView(Node root) {
      ArrayList<Integer> result = new ArrayList();
      Stack<Integer> stack = leftView(root);
      ArrayList<Integer> right = rightView(root);

      while(!stack.isEmpty()) {
         result.add(stack.pop());
      }

      for(int i = 1; i < right.size(); ++i) {
         if (right != null && right.get(i) != null) {
            result.add(right.get(i));
         }
      }

      return result;
   }

   static ArrayList<Integer> rightView(Node root) {
      ArrayList<Integer> list = new ArrayList();
      Queue<Node> queue = new ArrayDeque();
      queue.add(root);

      while(!queue.isEmpty()) {
         int size = queue.size();

         for(int i = 1; i <= size; ++i) {
            Node temp = (Node)queue.remove();
            if (i == 1) {
               list.add(temp.data);
            }

            if (temp.right != null) {
               queue.add(temp.right);
            }

            if (temp.left != null) {
               queue.add(temp.left);
            }
         }
      }

      return list;
   }

   static Stack<Integer> leftView(Node root) {
      Stack<Integer> stack = new Stack();
      Queue<Node> queue = new ArrayDeque();
      queue.add(root);

      while(!queue.isEmpty()) {
         int size = queue.size();

         for(int i = 1; i <= size; ++i) {
            Node temp = (Node)queue.remove();
            if (i == 1) {
               stack.push(temp.data);
            }

            if (temp.left != null) {
               queue.add(temp.left);
            }

            if (temp.right != null) {
               queue.add(temp.right);
            }
         }
      }

      return stack;
   }
}
