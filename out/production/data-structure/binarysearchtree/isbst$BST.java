package binarysearchtree;

import java.util.Stack;

public class isbst$BST {
   private int size = 0;
   private isbst.BST.Node root = null;

   isbst$BST(int[] arr) {
      this.root = this.makeBST(arr, 0, arr.length - 1);
   }

   isbst$BST(String s) {
      this.root = this.inputfromstring(s, this.root);
   }

   private isbst.BST.Node makeBST(int[] arr, int lo, int hi) {
      if (lo > hi) {
         return null;
      } else {
         int mid = lo + (hi - lo) / 2;
         isbst.BST.Node parent = new isbst.BST.Node(this, arr[mid], (isbst.BST.Node)null, (isbst.BST.Node)null);
         parent.left = this.makeBST(arr, lo, mid - 1);
         parent.right = this.makeBST(arr, mid + 1, hi);
         return parent;
      }
   }

   private isbst.BST.Node inputfromstring(String s, isbst.BST.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         isbst.BST.Node node = new isbst.BST.Node(this, 0, (isbst.BST.Node)null, (isbst.BST.Node)null);

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

   private void display(isbst.BST.Node parent) {
      if (parent != null) {
         String str = "";
         if (parent.left != null) {
            str = str + parent.left.data;
         }

         str = str + " => " + parent.data + " <= ";
         if (parent.right != null) {
            str = str + parent.right.data;
         }

         System.out.println(str);
         this.display(parent.left);
         this.display(parent.right);
      }
   }

   boolean isBST() {
      return this.isbst(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
   }

   boolean isbst(isbst.BST.Node root, int min, int max) {
      if (root == null) {
         return true;
      } else if (min < root.data && max > root.data) {
         if (!this.isbst(root.left, min, root.data)) {
            return false;
         } else {
            return this.isbst(root.right, root.data, max);
         }
      } else {
         return false;
      }
   }
}
