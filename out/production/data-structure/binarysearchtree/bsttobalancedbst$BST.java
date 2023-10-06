package binarysearchtree;

import java.util.ArrayList;
import java.util.Stack;

public class bsttobalancedbst$BST {
   private int size = 0;
   private bsttobalancedbst.BST.Node root = null;
   public static int i = 0;

   bsttobalancedbst$BST(int[] arr) {
      this.root = this.makeBSTfrompreoptimised(arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
   }

   bsttobalancedbst$BST(String s) {
      this.root = this.inputfromstring(s, this.root);
   }

   private bsttobalancedbst.BST.Node makeBSTfrompreoptimised(int[] arr, int min, int max) {
      if (i < arr.length && arr[i] >= min && arr[i] <= max) {
         bsttobalancedbst.BST.Node node = new bsttobalancedbst.BST.Node(this, arr[i++], (bsttobalancedbst.BST.Node)null, (bsttobalancedbst.BST.Node)null);
         node.left = this.makeBSTfrompreoptimised(arr, min, node.data);
         node.right = this.makeBSTfrompreoptimised(arr, node.data, max);
         return node;
      } else {
         return null;
      }
   }

   private bsttobalancedbst.BST.Node inputfromstring(String s, bsttobalancedbst.BST.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         bsttobalancedbst.BST.Node node = new bsttobalancedbst.BST.Node(this, 0, (bsttobalancedbst.BST.Node)null, (bsttobalancedbst.BST.Node)null);

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

   private void display(bsttobalancedbst.BST.Node parent) {
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

   public void inorder(bsttobalancedbst.BST.Node parent, ArrayList<Integer> list) {
      if (parent != null) {
         this.inorder(parent.left, list);
         list.add(parent.data);
         this.inorder(parent.right, list);
      }
   }

   private bsttobalancedbst.BST.Node makeBST(ArrayList<Integer> arr, int lo, int hi) {
      if (lo > hi) {
         return null;
      } else {
         int mid = lo + (hi - lo) / 2;
         bsttobalancedbst.BST.Node parent = new bsttobalancedbst.BST.Node(this, (Integer)arr.get(mid), (bsttobalancedbst.BST.Node)null, (bsttobalancedbst.BST.Node)null);
         parent.left = this.makeBST(arr, lo, mid - 1);
         parent.right = this.makeBST(arr, mid + 1, hi);
         return parent;
      }
   }

   public void balancedbst() {
      this.root = this.balancedbst(this.root);
   }

   public bsttobalancedbst.BST.Node balancedbst(bsttobalancedbst.BST.Node parent) {
      ArrayList<Integer> list = new ArrayList();
      this.inorder(parent, list);
      return this.makeBST(list, 0, list.size() - 1);
   }
}
