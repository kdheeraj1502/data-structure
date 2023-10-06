package binarysearchtree;

import java.util.Stack;

public class replacewithleastgreterelement$BST {
   private int size = 0;
   private replacewithleastgreterelement.BST.Node root = null;
   public static replacewithleastgreterelement.BST.Node succ = null;

   replacewithleastgreterelement$BST(int[] arr) {
      this.root = this.makeBST(arr, 0, arr.length - 1);
   }

   replacewithleastgreterelement$BST(String s) {
      this.root = this.inputfromstring(s, this.root);
   }

   private replacewithleastgreterelement.BST.Node makeBST(int[] arr, int lo, int hi) {
      if (lo > hi) {
         return null;
      } else {
         int mid = lo + (hi - lo) / 2;
         replacewithleastgreterelement.BST.Node parent = new replacewithleastgreterelement.BST.Node(arr[mid], (replacewithleastgreterelement.BST.Node)null, (replacewithleastgreterelement.BST.Node)null);
         parent.left = this.makeBST(arr, lo, mid - 1);
         parent.right = this.makeBST(arr, mid + 1, hi);
         return parent;
      }
   }

   private replacewithleastgreterelement.BST.Node inputfromstring(String s, replacewithleastgreterelement.BST.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         replacewithleastgreterelement.BST.Node node = new replacewithleastgreterelement.BST.Node(0, (replacewithleastgreterelement.BST.Node)null, (replacewithleastgreterelement.BST.Node)null);

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

   private void display(replacewithleastgreterelement.BST.Node parent) {
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

   public static replacewithleastgreterelement.BST.Node add(replacewithleastgreterelement.BST.Node parent, int n) {
      if (parent == null) {
         return new replacewithleastgreterelement.BST.Node(n, (replacewithleastgreterelement.BST.Node)null, (replacewithleastgreterelement.BST.Node)null);
      } else {
         if (n > parent.data) {
            parent.right = add(parent.right, n);
         } else {
            succ = parent;
            parent.left = add(parent.left, n);
         }

         return parent;
      }
   }

   public static void replace(int[] arr) {
      replacewithleastgreterelement.BST.Node root = null;

      int i;
      for(i = arr.length - 1; i >= 0; --i) {
         root = add(root, arr[i]);
         if (succ != null) {
            arr[i] = succ.data;
            succ = null;
         } else {
            arr[i] = -1;
         }
      }

      for(i = 0; i < arr.length; ++i) {
         System.out.println(arr[i]);
      }

   }
}
