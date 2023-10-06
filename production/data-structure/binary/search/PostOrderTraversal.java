package binary.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
   public static List<Integer> postorderTraversal(Node root) {
      List<Integer> result = new ArrayList();
      if (root == null) {
         return result;
      } else {
         Stack<Integer> resStack = new Stack();
         Stack<Node> stack = new Stack();
         stack.push(root);

         while(!stack.isEmpty()) {
            Node current = (Node)stack.pop();
            resStack.push(current.val);
            if (current.left != null) {
               stack.push(current.left);
            }

            if (current.right != null) {
               stack.push(current.right);
            }
         }

         while(!resStack.isEmpty()) {
            result.add(resStack.pop());
         }

         return result;
      }
   }

   public static void postOrder(Node root) {
      if (root != null) {
         postOrder(root.left);
         postOrder(root.right);
         System.out.print(root.val + ", ");
      }

   }

   public static void postOrderWithoutRecursion(Node root) {
      Node temp = root;
      Stack<Node> stack = new Stack();

      while(true) {
         while(temp != null || !stack.isEmpty()) {
            if (temp != null) {
               stack.push(temp);
               temp = temp.left;
            } else {
               Node temp2 = ((Node)stack.peek()).right;
               if (temp2 == null) {
                  temp2 = (Node)stack.pop();
                  System.out.print(temp2.val + ", ");

                  while(!stack.isEmpty() && temp2 == ((Node)stack.peek()).right) {
                     temp2 = (Node)stack.pop();
                     System.out.print(temp2.val + ", ");
                  }
               } else {
                  temp = temp2;
               }
            }
         }

         return;
      }
   }

   public static void postOrderWithoutRecursion_self(Node root) {
      Node temp = root;
      Stack<Node> stack = new Stack();

      while(true) {
         while(temp != null || !stack.isEmpty()) {
            if (temp != null) {
               stack.push(temp);
               temp = temp.left;
            } else {
               Node temp2 = ((Node)stack.peek()).right;
               if (temp2 == null) {
                  temp2 = (Node)stack.pop();
                  System.out.print(temp2.val + ", ");

                  while(!stack.isEmpty() && temp2 == ((Node)stack.peek()).right) {
                     temp2 = (Node)stack.pop();
                     System.out.print(temp2.val + ", ");
                  }
               } else {
                  temp = temp2;
               }
            }
         }

         return;
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
      postOrderWithoutRecursion(root);
      System.out.println();
      postOrderWithoutRecursion_self(root);
      System.out.println("----------------");
      System.out.println(postorderTraversal(root));
   }
}
