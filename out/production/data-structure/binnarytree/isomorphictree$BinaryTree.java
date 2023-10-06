package binnarytree;

import java.util.Scanner;
import java.util.Stack;

public class isomorphictree$BinaryTree {
   private isomorphictree.BinaryTree.Node root;
   private int size;
   // $FF: synthetic field
   final isomorphictree this$0;

   isomorphictree$BinaryTree(isomorphictree this$0, String s) {
      this.this$0 = this$0;
      this.root = null;
      this.size = 0;
      new Scanner(System.in);
      this.root = this.inputfromstring(s, (isomorphictree.BinaryTree.Node)null);
   }

   private isomorphictree.BinaryTree.Node inputfromstring(String s, isomorphictree.BinaryTree.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         isomorphictree.BinaryTree.Node node = new isomorphictree.BinaryTree.Node(this, 0, (isomorphictree.BinaryTree.Node)null, (isomorphictree.BinaryTree.Node)null);

         int i;
         for(i = 0; i < s.length() && s.charAt(i) != '('; ++i) {
         }

         int start = i + 1;
         String no = s.substring(0, i);
         node.data = Integer.parseInt(no);
         if (i < s.length()) {
            Stack<Character> stack = new Stack();
            stack.push(s.charAt(i));
            ++i;

            for(; !stack.isEmpty() && i < s.length(); ++i) {
               if (s.charAt(i) == '(') {
                  stack.push(s.charAt(i));
               } else if (s.charAt(i) == ')') {
                  stack.pop();
               }
            }

            int end = i - 1;
            String leftsub = s.substring(start, end);
            node.left = this.inputfromstring(leftsub, node);
            if (end + 2 < s.length() - 1) {
               String rightsub = s.substring(end + 2, s.length() - 1);
               node.right = this.inputfromstring(rightsub, node);
            }
         }

         return node;
      }
   }

   public void display() {
      this.display(this.root);
   }

   private void display(isomorphictree.BinaryTree.Node parent) {
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

   public boolean isomorphic(isomorphictree$BinaryTree tree) {
      return this.isomorphic(this.root, tree.root);
   }

   private boolean isomorphic(isomorphictree.BinaryTree.Node parent1, isomorphictree.BinaryTree.Node parent2) {
      if (parent1 == null && parent2 == null) {
         return true;
      } else if (parent1 != null && parent2 != null) {
         if (parent1.data != parent2.data) {
            return false;
         } else {
            boolean a = this.isomorphic(parent1.left, parent2.left) && this.isomorphic(parent1.right, parent2.right);
            boolean b = this.isomorphic(parent1.left, parent2.right) && this.isomorphic(parent1.right, parent2.left);
            return a || b;
         }
      } else {
         return false;
      }
   }
}
