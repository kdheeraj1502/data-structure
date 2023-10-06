package binnarytree;

import java.util.Scanner;
import java.util.Stack;

public class chechkmirror$BinaryTree {
   private chechkmirror.BinaryTree.Node root;
   private int size;
   // $FF: synthetic field
   final chechkmirror this$0;

   chechkmirror$BinaryTree(chechkmirror this$0, String s) {
      this.this$0 = this$0;
      this.root = null;
      this.size = 0;
      new Scanner(System.in);
      this.root = this.inputfromstring(s, (chechkmirror.BinaryTree.Node)null);
   }

   private chechkmirror.BinaryTree.Node inputfromstring(String s, chechkmirror.BinaryTree.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         chechkmirror.BinaryTree.Node node = new chechkmirror.BinaryTree.Node(this, 0, (chechkmirror.BinaryTree.Node)null, (chechkmirror.BinaryTree.Node)null);
         node.data = Integer.parseInt(String.valueOf(s.charAt(0)));
         if (s.length() > 1) {
            Stack<Character> stack = new Stack();
            stack.push(s.charAt(1));

            int i;
            for(i = 2; !stack.isEmpty() && i < s.length(); ++i) {
               if (s.charAt(i) == '(') {
                  stack.push(s.charAt(i));
               } else if (s.charAt(i) == ')') {
                  stack.pop();
               }
            }

            String leftsub = s.substring(2, i - 1);
            node.left = this.inputfromstring(leftsub, node);
            if (i + 1 < s.length() - 1) {
               String rightsub = s.substring(i + 1, s.length() - 1);
               node.right = this.inputfromstring(rightsub, node);
            }
         }

         return node;
      }
   }

   public void display() {
      this.display(this.root);
   }

   private void display(chechkmirror.BinaryTree.Node parent) {
      String str = "";
      if (parent.left != null) {
         str = str + parent.left.data + " => ";
      } else {
         str = str + "End => ";
      }

      str = str + parent.data;
      if (parent.right != null) {
         str = str + " <= " + parent.right.data;
      } else {
         str = str + " <= End";
      }

      System.out.println(str);
      if (parent.left != null) {
         this.display(parent.left);
      }

      if (parent.right != null) {
         this.display(parent.right);
      }

   }

   public boolean checkmirror(chechkmirror$BinaryTree tree1) {
      return this.checkmirror(this.root, tree1.root);
   }

   private boolean checkmirror(chechkmirror.BinaryTree.Node parent1, chechkmirror.BinaryTree.Node parent2) {
      if (parent1 == null && parent2 == null) {
         return true;
      } else if (parent1 != null && parent2 != null) {
         boolean left = this.checkmirror(parent1.left, parent2.right);
         boolean right = this.checkmirror(parent1.right, parent2.left);
         boolean ans = parent1.data == parent2.data && left && right;
         return ans;
      } else {
         return false;
      }
   }
}
