package binnarytree;

import java.util.Scanner;
import java.util.Stack;

public class treefrominorderandpre$BinaryTree {
   private treefrominorderandpre.BinaryTree.Node root;
   private int size;
   // $FF: synthetic field
   final treefrominorderandpre this$0;

   treefrominorderandpre$BinaryTree(treefrominorderandpre this$0, String s) {
      this.this$0 = this$0;
      this.root = null;
      this.size = 0;
      new Scanner(System.in);
      this.root = this.inputfromstring(s, (treefrominorderandpre.BinaryTree.Node)null);
   }

   private treefrominorderandpre.BinaryTree.Node inputfromstring(String s, treefrominorderandpre.BinaryTree.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         treefrominorderandpre.BinaryTree.Node node = new treefrominorderandpre.BinaryTree.Node(this, 0, (treefrominorderandpre.BinaryTree.Node)null, (treefrominorderandpre.BinaryTree.Node)null);
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

   private void display(treefrominorderandpre.BinaryTree.Node parent) {
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

   public void treefrominandpre(int[] in, int[] pre) {
      this.root = this.treefrominandpre(in, 0, in.length - 1, pre, 0, pre.length - 1);
   }

   private treefrominorderandpre.BinaryTree.Node treefrominandpre(int[] in, int inlo, int inhi, int[] pre, int prelo, int prehi) {
      if (inlo > inhi) {
         return null;
      } else {
         treefrominorderandpre.BinaryTree.Node parent = new treefrominorderandpre.BinaryTree.Node(this, pre[prelo], (treefrominorderandpre.BinaryTree.Node)null, (treefrominorderandpre.BinaryTree.Node)null);

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
