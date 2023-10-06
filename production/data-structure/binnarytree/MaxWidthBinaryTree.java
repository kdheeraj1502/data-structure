package binnarytree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthBinaryTree {
   static Node root;

   public static int widthOfBinaryTree(Node root) {
      if (root == null) {
         return 0;
      } else {
         Queue<Pair<Node, Integer>> queue = new LinkedList();
         queue.offer(new Pair(root, 0));

         int result;
         int left;
         int right;
         for(result = 1; !queue.isEmpty(); result = Math.max(right - left + 1, result)) {
            int size = queue.size();
            left = ((Pair)queue.peek()).getValue();
            right = left;

            for(int i = 0; i < size; ++i) {
               Pair<Node, Integer> p = (Pair)queue.poll();
               Node node = p.getKey();
               right = p.getValue();
               if (node.left != null) {
                  queue.offer(new Pair(node.left, right * 2));
               }

               if (node.right != null) {
                  queue.offer(new Pair(node.right, right * 2 + 1));
               }
            }
         }

         return result;
      }
   }

   public static int width(Node root) {
      Queue<Pair<Node, Integer>> queue = new ArrayDeque();
      queue.add(new Pair(root, 0));

      int max;
      int lm;
      int rm;
      for(max = 0; !queue.isEmpty(); max = Math.max(max, rm - lm + 1)) {
         int size = queue.size();
         lm = ((Pair)queue.peek()).index;
         rm = ((Pair)queue.peek()).index;

         while(size-- > 0) {
            Pair<Node, Integer> temp = (Pair)queue.remove();
            rm = temp.index;
            if (temp.node.left != null) {
               queue.add(new Pair(temp.node.left, 2 * lm + 1));
            }

            if (temp.node.right != null) {
               queue.add(new Pair(temp.node.right, 2 * rm + 2));
            }
         }
      }

      return max;
   }

   public static void main(String[] args) {
      root = new Node(10);
      root.left = new Node(30);
      root.right = new Node(20);
      root.left.left = new Node(60);
      root.left.right = new Node(50);
      root.left.left.right = new Node(9);
      root.right.right = new Node(90);
      root.right.left = new Node(70);
      root.right.right.right = new Node(100);
      root.right.right.left = new Node(6);
      System.out.println(widthOfBinaryTree(root));
   }
}
