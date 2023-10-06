package binarysearchtree;

import java.util.Stack;

public class bstfrompreorder$BST {
   private int size = 0;
   private bstfrompreorder.BST.Node root = null;
   public static int i = 0;
   bstfrompreorder.BST.Node suc = new bstfrompreorder.BST.Node(this, -1, (bstfrompreorder.BST.Node)null, (bstfrompreorder.BST.Node)null);
   bstfrompreorder.BST.Node pre = new bstfrompreorder.BST.Node(this, -1, (bstfrompreorder.BST.Node)null, (bstfrompreorder.BST.Node)null);

   bstfrompreorder$BST(int[] arr) {
      this.root = this.makeBSTfrompreoptimised(arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
   }

   bstfrompreorder$BST(String s) {
      this.root = this.inputfromstring(s, this.root);
   }

   private bstfrompreorder.BST.Node makeBSTfrompre(int[] arr, int lo, int hi) {
      bstfrompreorder.BST.Node parent = new bstfrompreorder.BST.Node(this, arr[0], (bstfrompreorder.BST.Node)null, (bstfrompreorder.BST.Node)null);

      for(int i = 1; i < arr.length; ++i) {
         this.add(parent, arr[i]);
      }

      return parent;
   }

   private bstfrompreorder.BST.Node makeBSTfrompreoptimised(int[] arr, int min, int max) {
      if (i < arr.length && arr[i] >= min && arr[i] <= max) {
         bstfrompreorder.BST.Node node = new bstfrompreorder.BST.Node(this, arr[i++], (bstfrompreorder.BST.Node)null, (bstfrompreorder.BST.Node)null);
         node.left = this.makeBSTfrompreoptimised(arr, min, node.data);
         node.right = this.makeBSTfrompreoptimised(arr, node.data, max);
         return node;
      } else {
         return null;
      }
   }

   private bstfrompreorder.BST.Node inputfromstring(String s, bstfrompreorder.BST.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         bstfrompreorder.BST.Node node = new bstfrompreorder.BST.Node(this, 0, (bstfrompreorder.BST.Node)null, (bstfrompreorder.BST.Node)null);

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

   private void display(bstfrompreorder.BST.Node parent) {
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

   public boolean find(int n) {
      return this.find(this.root, n);
   }

   private boolean find(bstfrompreorder.BST.Node parent, int n) {
      if (parent == null) {
         return false;
      } else {
         boolean ans = false;
         if (n > parent.data) {
            ans = this.find(parent.right, n);
         } else {
            if (n >= parent.data) {
               return true;
            }

            ans = this.find(parent.left, n);
         }

         return ans;
      }
   }

   public void add(int n) {
      this.root = this.add(this.root, n);
   }

   private bstfrompreorder.BST.Node add(bstfrompreorder.BST.Node parent, int n) {
      if (parent == null) {
         return new bstfrompreorder.BST.Node(this, n, (bstfrompreorder.BST.Node)null, (bstfrompreorder.BST.Node)null);
      } else {
         if (n > parent.data) {
            parent.right = this.add(parent.right, n);
         } else if (n < parent.data) {
            parent.left = this.add(parent.left, n);
         }

         return parent;
      }
   }

   private bstfrompreorder.BST.Node max(bstfrompreorder.BST.Node parent) {
      if (parent == null) {
         return null;
      } else {
         return parent.right != null ? this.max(parent.right) : parent;
      }
   }

   private bstfrompreorder.BST.Node min(bstfrompreorder.BST.Node parent) {
      if (parent == null) {
         return null;
      } else {
         return parent.left != null ? this.min(parent.left) : parent;
      }
   }
}
