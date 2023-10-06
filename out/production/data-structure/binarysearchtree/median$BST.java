package binarysearchtree;

import java.util.Stack;

public class median$BST {
   private int size = 0;
   private median.BST.Node root = null;
   public static int k = 0;
   public static int n = 0;

   median$BST(int[] arr) {
      this.root = this.makeBST(arr, 0, arr.length - 1);
   }

   median$BST(String s) {
      this.root = this.inputfromstring(s, this.root);
   }

   private median.BST.Node makeBST(int[] arr, int lo, int hi) {
      if (lo > hi) {
         return null;
      } else {
         int mid = lo + (hi - lo) / 2;
         median.BST.Node parent = new median.BST.Node(this, arr[mid], (median.BST.Node)null, (median.BST.Node)null);
         parent.left = this.makeBST(arr, lo, mid - 1);
         parent.right = this.makeBST(arr, mid + 1, hi);
         return parent;
      }
   }

   private median.BST.Node inputfromstring(String s, median.BST.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         median.BST.Node node = new median.BST.Node(this, 0, (median.BST.Node)null, (median.BST.Node)null);

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

   private void display(median.BST.Node parent) {
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

   public void morristraversalinorder() {
      this.morristraversalinorder(this.root);
   }

   private void morristraversalinorder(median.BST.Node root) {
      median.BST.Node current = root;

      while(true) {
         while(current != null) {
            if (current.left == null) {
               ++n;
               current = current.right;
            } else {
               median.BST.Node pre;
               for(pre = current.left; pre.right != null && pre.right != current; pre = pre.right) {
               }

               if (pre.right == null) {
                  pre.right = current;
                  current = current.left;
               } else {
                  pre.right = null;
                  ++n;
                  current = current.right;
               }
            }
         }

         return;
      }
   }

   public void findMedian(median.BST.Node root) {
      n = 0;
      k = 0;
      this.morristraversalinorder(root);
      int a;
      if (n % 2 == 0) {
         k = n / 2;
         System.out.println(k);
         a = kthsmallest(root);
         k = n / 2 + 1;
         System.out.println(k);
         int b = kthsmallest(root);
         System.out.println(b + "------------b");
         float ans = (float)(a + b) / 2.0F;
         System.out.println(ans);
      } else {
         k = (n + 1) / 2;
         a = kthsmallest(root);
         System.out.println(a);
      }

   }

   public static int kthsmallest(median.BST.Node root) {
      median.BST.Node current = root;
      int ans = Integer.MIN_VALUE;

      while(true) {
         while(current != null) {
            if (current.left == null) {
               --k;
               if (k == 0) {
                  ans = current.data;
               }

               current = current.right;
            } else {
               median.BST.Node pre;
               for(pre = current.left; pre.right != null && pre.right != current; pre = pre.right) {
               }

               if (pre.right == null) {
                  pre.right = current;
                  current = current.left;
               } else {
                  pre.right = null;
                  --k;
                  if (k == 0) {
                     ans = current.data;
                  }

                  current = current.right;
               }
            }
         }

         return ans;
      }
   }
}
