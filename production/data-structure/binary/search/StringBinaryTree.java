package binary.search;

import java.util.Stack;

public class StringBinaryTree {
   static Node root;

   public static int findIndex(String str, int start, int end) {
      if (start > end) {
         return -1;
      } else {
         Stack<Character> stack = new Stack();

         for(int i = start; i <= end; ++i) {
            if (str.charAt(i) == '(') {
               stack.push(str.charAt(i));
            } else if (str.charAt(i) == ')') {
               if ((Character)stack.peek() == '(') {
                  stack.pop();
               }

               if (stack.isEmpty()) {
                  return i;
               }
            }
         }

         return -1;
      }
   }

   public static Node stringToTree(String str, int start, int end) {
      if (start > end) {
         return null;
      } else {
         Node root = new Node(str.charAt(start) - 48);
         int index = -1;
         if (str.charAt(start + 1) == '(' && start + 1 <= end) {
            index = findIndex(str, start + 1, end);
         }

         if (index != -1) {
            root.left = stringToTree(str, start + 2, index - 1);
            root.right = stringToTree(str, index + 2, end - 1);
         }

         return root;
      }
   }

   public static void main(String[] args) {
      String str = "4(2(3)(1))(6(5))";
      System.out.println(stringToTree(str, 0, str.length() - 1));
   }
}
