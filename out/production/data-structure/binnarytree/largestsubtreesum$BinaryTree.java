package binnarytree;

import java.util.Scanner;
import java.util.Stack;

public class largestsubtreesum$BinaryTree {
   private largestsubtreesum.BinaryTree.Node root;
   private int size;
   public int maxsumsofar;
   // $FF: synthetic field
   final largestsubtreesum this$0;

   largestsubtreesum$BinaryTree(largestsubtreesum this$0, String s) {
      this.this$0 = this$0;
      this.root = null;
      this.size = 0;
      this.maxsumsofar = Integer.MIN_VALUE;
      new Scanner(System.in);
      this.root = this.inputfromstring(s, (largestsubtreesum.BinaryTree.Node)null);
   }

   private largestsubtreesum.BinaryTree.Node inputfromstring(String s, largestsubtreesum.BinaryTree.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         largestsubtreesum.BinaryTree.Node node = new largestsubtreesum.BinaryTree.Node(this, 0, (largestsubtreesum.BinaryTree.Node)null, (largestsubtreesum.BinaryTree.Node)null);
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

   private void display(largestsubtreesum.BinaryTree.Node parent) {
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
      return this.sum(this.root);
   }

   private int sum(largestsubtreesum.BinaryTree.Node parent) {
      if (parent == null) {
         return 0;
      } else if (parent.left == null && parent.right == null) {
         return parent.data;
      } else {
         int left = this.sum(parent.left);
         int right = this.sum(parent.right);
         int mysum = left + right + parent.data;
         if (mysum > this.maxsumsofar) {
            this.maxsumsofar = mysum;
         }

         return mysum;
      }
   }

   public void treefrominandpre(int[] in, int[] pre) {
      this.root = this.treefrominandpre(in, 0, in.length - 1, pre, 0, pre.length - 1);
   }

   private largestsubtreesum.BinaryTree.Node treefrominandpre(int[] in, int inlo, int inhi, int[] pre, int prelo, int prehi) {
      if (inlo > inhi) {
         return null;
      } else {
         largestsubtreesum.BinaryTree.Node parent = new largestsubtreesum.BinaryTree.Node(this, pre[prelo], (largestsubtreesum.BinaryTree.Node)null, (largestsubtreesum.BinaryTree.Node)null);

         int i;
         for(i = inlo; i <= inhi && in[i] != pre[prelo]; ++i) {
         }

         int end = i - inlo;
         parent.left = this.treefrominandpre(in, inlo, inlo + end - 1, pre, prelo + 1, prelo + end);
         parent.right = this.treefrominandpre(in, inlo + end + 1, inhi, pre, prelo + end + 1, prehi);
         return parent;
      }
   }
}
