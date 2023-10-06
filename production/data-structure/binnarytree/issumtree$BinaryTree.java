package binnarytree;

import java.util.Scanner;
import java.util.Stack;

public class issumtree$BinaryTree {
   private issumtree.BinaryTree.Node root;
   private int size;
   // $FF: synthetic field
   final issumtree this$0;

   issumtree$BinaryTree(issumtree this$0, String s) {
      this.this$0 = this$0;
      this.root = null;
      this.size = 0;
      new Scanner(System.in);
      this.root = this.inputfromstring(s, (issumtree.BinaryTree.Node)null);
   }

   private issumtree.BinaryTree.Node inputfromstring(String s, issumtree.BinaryTree.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         issumtree.BinaryTree.Node node = new issumtree.BinaryTree.Node(this, 0, (issumtree.BinaryTree.Node)null, (issumtree.BinaryTree.Node)null);
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

   private void display(issumtree.BinaryTree.Node parent) {
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

   public boolean issumtree() {
      return this.issumtree(this.root).ans;
   }

   private issumtree.BinaryTree.pair issumtree(issumtree.BinaryTree.Node parent) {
      issumtree.BinaryTree.pair left;
      if (parent == null) {
         left = new issumtree.BinaryTree.pair(this, true, 0);
         return left;
      } else if (parent.left == null && parent.right == null) {
         left = new issumtree.BinaryTree.pair(this, true, parent.data);
         return left;
      } else {
         left = this.issumtree(parent.left);
         issumtree.BinaryTree.pair right = this.issumtree(parent.right);
         Boolean ans = false;
         issumtree.BinaryTree.pair mp = new issumtree.BinaryTree.pair(this, left.ans && right.ans && left.sum + right.sum == parent.data, left.sum + right.sum + parent.data);
         return mp;
      }
   }
}
