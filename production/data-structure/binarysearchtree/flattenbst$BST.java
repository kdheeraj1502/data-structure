package binarysearchtree;

import java.util.Stack;

public class flattenbst$BST {
   private int size = 0;
   private flattenbst.BST.Node root = null;
   public static flattenbst.BST.Node prev = new flattenbst.BST.Node(-1, (flattenbst.BST.Node)null, (flattenbst.BST.Node)null);

   flattenbst$BST(int[] arr) {
      this.root = this.makeBST(arr, 0, arr.length - 1);
   }

   flattenbst$BST(String s) {
      this.root = this.inputfromstring(s, this.root);
   }

   private flattenbst.BST.Node makeBST(int[] arr, int lo, int hi) {
      if (lo > hi) {
         return null;
      } else {
         int mid = lo + (hi - lo) / 2;
         flattenbst.BST.Node parent = new flattenbst.BST.Node(arr[mid], (flattenbst.BST.Node)null, (flattenbst.BST.Node)null);
         parent.left = this.makeBST(arr, lo, mid - 1);
         parent.right = this.makeBST(arr, mid + 1, hi);
         return parent;
      }
   }

   private flattenbst.BST.Node inputfromstring(String s, flattenbst.BST.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         flattenbst.BST.Node node = new flattenbst.BST.Node(0, (flattenbst.BST.Node)null, (flattenbst.BST.Node)null);

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

   private void display(flattenbst.BST.Node parent) {
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

   public void flattenbst() {
      this.root = this.flattenbst(this.root);
   }

   private void flattenbstpre(flattenbst.BST.Node root) {
      if (root != null) {
         this.flattenbstpre(root.right);
         this.flattenbstpre(root.left);
         root.right = prev;
         root.left = null;
         prev = root;
      }
   }

   private flattenbst.BST.Node flattenbst(flattenbst.BST.Node root) {
      if (root == null) {
         return root;
      } else {
         flattenbst.BST.Node temp = new flattenbst.BST.Node(-1, (flattenbst.BST.Node)null, (flattenbst.BST.Node)null);
         prev = temp;
         this.inorder(root);
         prev.left = null;
         prev.right = null;
         flattenbst.BST.Node newRoot = temp.right;
         System.out.println(newRoot.data);
         return newRoot;
      }
   }

   private void inorder(flattenbst.BST.Node root) {
      if (root != null) {
         this.inorder(root.left);
         prev.left = null;
         prev.right = root;
         prev = root;
         this.inorder(root.right);
      }
   }
}
