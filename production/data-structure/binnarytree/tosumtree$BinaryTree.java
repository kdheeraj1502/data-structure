package binnarytree;

import java.util.Scanner;
import java.util.Stack;

public class tosumtree$BinaryTree {
   private tosumtree.BinaryTree.Node root;
   private int size;
   // $FF: synthetic field
   final tosumtree this$0;

   tosumtree$BinaryTree(tosumtree this$0, String s) {
      this.this$0 = this$0;
      this.root = null;
      this.size = 0;
      new Scanner(System.in);
      this.root = this.inputfromstring(s, (tosumtree.BinaryTree.Node)null);
   }

   private tosumtree.BinaryTree.Node inputfromstring(String s, tosumtree.BinaryTree.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         tosumtree.BinaryTree.Node node = new tosumtree.BinaryTree.Node(this, 0, (tosumtree.BinaryTree.Node)null, (tosumtree.BinaryTree.Node)null);
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

   private void display(tosumtree.BinaryTree.Node parent) {
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

   public void tosumtree() {
      this.tosumtree(this.root);
   }

   private int tosumtree(tosumtree.BinaryTree.Node parent) {
      if (parent == null) {
         return 0;
      } else {
         int left;
         if (parent.left == null && parent.right == null) {
            left = parent.data;
            parent.data = 0;
            return left;
         } else {
            left = this.tosumtree(parent.left);
            int right = this.tosumtree(parent.right);
            int temp = parent.data;
            parent.data = left + right;
            return parent.data + temp;
         }
      }
   }
}
