package binarysearchtree;

import java.util.Stack;

public class morristraversal$BST {
   private int size = 0;
   private morristraversal.BST.Node root = null;

   morristraversal$BST(int[] arr) {
      this.root = this.makeBST(arr, 0, arr.length - 1);
   }

   morristraversal$BST(String s) {
      this.root = this.inputfromstring(s, this.root);
   }

   private morristraversal.BST.Node makeBST(int[] arr, int lo, int hi) {
      if (lo > hi) {
         return null;
      } else {
         int mid = lo + (hi - lo) / 2;
         morristraversal.BST.Node parent = new morristraversal.BST.Node(this, arr[mid], (morristraversal.BST.Node)null, (morristraversal.BST.Node)null);
         parent.left = this.makeBST(arr, lo, mid - 1);
         parent.right = this.makeBST(arr, mid + 1, hi);
         return parent;
      }
   }

   private morristraversal.BST.Node inputfromstring(String s, morristraversal.BST.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         morristraversal.BST.Node node = new morristraversal.BST.Node(this, 0, (morristraversal.BST.Node)null, (morristraversal.BST.Node)null);

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

   private void display(morristraversal.BST.Node parent) {
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

   private void morristraversalinorder(morristraversal.BST.Node root) {
      morristraversal.BST.Node current = root;

      while(true) {
         while(current != null) {
            if (current.left == null) {
               System.out.print(current.data + " ");
               current = current.right;
            } else {
               morristraversal.BST.Node pre;
               for(pre = current.left; pre.right != null && pre.right != current; pre = pre.right) {
               }

               if (pre.right == null) {
                  pre.right = current;
                  current = current.left;
               } else {
                  pre.right = null;
                  System.out.print(current.data + " ");
                  current = current.right;
               }
            }
         }

         return;
      }
   }
}
