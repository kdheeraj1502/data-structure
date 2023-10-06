package binnarytree;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class maxsumnonadjacentnodes$BinaryTree {
   private maxsumnonadjacentnodes.BinaryTree.Node root;
   private int size;
   HashMap<maxsumnonadjacentnodes.BinaryTree.Node, Integer> map;
   // $FF: synthetic field
   final maxsumnonadjacentnodes this$0;

   maxsumnonadjacentnodes$BinaryTree(maxsumnonadjacentnodes this$0, String s) {
      this.this$0 = this$0;
      this.root = null;
      this.size = 0;
      this.map = new HashMap();
      new Scanner(System.in);
      this.root = this.inputfromstring(s, (maxsumnonadjacentnodes.BinaryTree.Node)null);
   }

   private maxsumnonadjacentnodes.BinaryTree.Node inputfromstring(String s, maxsumnonadjacentnodes.BinaryTree.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         maxsumnonadjacentnodes.BinaryTree.Node node = new maxsumnonadjacentnodes.BinaryTree.Node(this, 0, (maxsumnonadjacentnodes.BinaryTree.Node)null, (maxsumnonadjacentnodes.BinaryTree.Node)null);

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

            String leftsub = s.substring(start, i - 1);
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

   private void display(maxsumnonadjacentnodes.BinaryTree.Node parent) {
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

   private maxsumnonadjacentnodes.BinaryTree.Node treefrominandpre(int[] in, int inlo, int inhi, int[] pre, int prelo, int prehi) {
      if (inlo > inhi) {
         return null;
      } else {
         maxsumnonadjacentnodes.BinaryTree.Node parent = new maxsumnonadjacentnodes.BinaryTree.Node(this, pre[prelo], (maxsumnonadjacentnodes.BinaryTree.Node)null, (maxsumnonadjacentnodes.BinaryTree.Node)null);

         int i;
         for(i = inlo; i <= inhi && in[i] != pre[prelo]; ++i) {
         }

         int end = i - inlo;
         parent.left = this.treefrominandpre(in, inlo, inlo + end - 1, pre, prelo + 1, prelo + end);
         parent.right = this.treefrominandpre(in, inlo + end + 1, inhi, pre, prelo + end + 1, prehi);
         return parent;
      }
   }

   public int maxsum() {
      return this.maxsum(this.root);
   }

   private int maxsum(maxsumnonadjacentnodes.BinaryTree.Node parent) {
      if (parent == null) {
         return 0;
      } else if (this.map.containsKey(parent)) {
         return (Integer)this.map.get(parent);
      } else {
         int inc = parent.data;
         if (parent.left != null) {
            inc += this.maxsum(parent.left.left);
            inc += this.maxsum(parent.left.right);
         }

         if (parent.right != null) {
            inc += this.maxsum(parent.right.left);
            inc += this.maxsum(parent.right.right);
         }

         int exc = this.maxsum(parent.left) + this.maxsum(parent.right);
         int myans = Math.max(inc, exc);
         this.map.put(parent, myans);
         return myans;
      }
   }
}
