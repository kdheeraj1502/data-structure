package binnarytree;

import java.util.Scanner;
import java.util.Stack;

public class longestpathsum$BinaryTree {
   private longestpathsum.BinaryTree.Node root;
   private int size;
   // $FF: synthetic field
   final longestpathsum this$0;

   longestpathsum$BinaryTree(longestpathsum this$0, String s) {
      this.this$0 = this$0;
      this.root = null;
      this.size = 0;
      new Scanner(System.in);
      this.root = this.inputfromstring(s, (longestpathsum.BinaryTree.Node)null);
   }

   private longestpathsum.BinaryTree.Node inputfromstring(String s, longestpathsum.BinaryTree.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         longestpathsum.BinaryTree.Node node = new longestpathsum.BinaryTree.Node(this, 0, (longestpathsum.BinaryTree.Node)null, (longestpathsum.BinaryTree.Node)null);
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

   private void display(longestpathsum.BinaryTree.Node parent) {
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

   public int sum() {
      return this.sum(this.root, 0).sum;
   }

   private longestpathsum.BinaryTree.pair sum(longestpathsum.BinaryTree.Node parent, int d) {
      longestpathsum.BinaryTree.pair left;
      if (parent == null) {
         left = new longestpathsum.BinaryTree.pair(this);
         left.maxdepth = -1;
         left.sum = 0;
         return left;
      } else if (parent.left == null && parent.right == null) {
         left = new longestpathsum.BinaryTree.pair(this);
         left.maxdepth = d;
         left.sum = parent.data;
         return left;
      } else {
         left = this.sum(parent.left, d + 1);
         longestpathsum.BinaryTree.pair right = this.sum(parent.right, d + 1);
         longestpathsum.BinaryTree.pair mypair = new longestpathsum.BinaryTree.pair(this);
         mypair.maxdepth = Math.max(left.maxdepth, right.maxdepth);
         if (left.maxdepth > right.maxdepth) {
            mypair.sum = left.sum + parent.data;
         } else if (left.maxdepth < right.maxdepth) {
            mypair.sum = right.sum + parent.data;
         } else {
            mypair.sum = Math.max(left.sum, right.sum) + parent.data;
         }

         return mypair;
      }
   }
}
