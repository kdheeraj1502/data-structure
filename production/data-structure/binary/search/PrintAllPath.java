package binary.search;

import java.util.Stack;

public class PrintAllPath {
   public static void printAllPath(Node root) {
      Stack<Integer> stack = new Stack();
      printAllPathSelf(root, stack);
   }

   private static void printAllPath(Node root, Stack<Integer> stack) {
      if (root != null) {
         stack.push(root.val);
         if (root.left == null && root.right == null) {
            System.out.println(stack);
            stack.pop();
         } else {
            printAllPath(root.right, stack);
            printAllPath(root.left, stack);
            stack.pop();
         }
      }
   }

   private static void printAllPathSelf(Node root, Stack<Integer> stack) {
      if (root != null) {
         stack.push(root.val);
         if (root.left == null && root.right == null) {
            System.out.println(stack);
            stack.pop();
         } else {
            printAllPathSelf(root.right, stack);
            printAllPathSelf(root.left, stack);
            stack.pop();
         }
      }
   }
}
