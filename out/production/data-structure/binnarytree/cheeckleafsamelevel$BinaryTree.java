package binnarytree;

import java.util.Scanner;
import java.util.Stack;

public class cheeckleafsamelevel$BinaryTree {
   private cheeckleafsamelevel.BinaryTree.Node root;
   private int size;
   int level;
   // $FF: synthetic field
   final cheeckleafsamelevel this$0;

   cheeckleafsamelevel$BinaryTree(cheeckleafsamelevel this$0, String s) {
      this.this$0 = this$0;
      this.root = null;
      this.size = 0;
      this.level = -1;
      new Scanner(System.in);
      this.root = this.inputfromstring(s, (cheeckleafsamelevel.BinaryTree.Node)null);
   }

   private cheeckleafsamelevel.BinaryTree.Node inputfromstring(String s, cheeckleafsamelevel.BinaryTree.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         cheeckleafsamelevel.BinaryTree.Node node = new cheeckleafsamelevel.BinaryTree.Node(this, 0, (cheeckleafsamelevel.BinaryTree.Node)null, (cheeckleafsamelevel.BinaryTree.Node)null);
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

   private void display(cheeckleafsamelevel.BinaryTree.Node parent) {
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

   public boolean checkleaf() {
      return this.checkleaf(this.root, 0);
   }

   private boolean checkleaf(cheeckleafsamelevel.BinaryTree.Node parent, int levelnode) {
      if (parent == null) {
         return true;
      } else {
         if (parent.left == null && parent.right == null) {
            if (this.level >= 0) {
               if (this.level != levelnode) {
                  return false;
               }

               return true;
            }

            this.level = levelnode;
         }

         boolean left = this.checkleaf(parent.left, levelnode + 1);
         boolean right = this.checkleaf(parent.right, levelnode + 1);
         return left && right;
      }
   }
}
