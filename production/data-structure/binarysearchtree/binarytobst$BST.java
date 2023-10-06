package binarysearchtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class binarytobst$BST {
   private int size = 0;
   private binarytobst.BST.Node root = null;
   public static int i = 0;
   public static int indx = 0;

   binarytobst$BST(int[] arr) {
      this.root = this.makeBSTfrompreoptimised(arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
   }

   binarytobst$BST(String s) {
      this.root = this.inputfromstring(s, this.root);
   }

   private binarytobst.BST.Node makeBSTfrompreoptimised(int[] arr, int min, int max) {
      if (i < arr.length && arr[i] >= min && arr[i] <= max) {
         binarytobst.BST.Node node = new binarytobst.BST.Node(this, arr[i++], (binarytobst.BST.Node)null, (binarytobst.BST.Node)null);
         node.left = this.makeBSTfrompreoptimised(arr, min, node.data);
         node.right = this.makeBSTfrompreoptimised(arr, node.data, max);
         return node;
      } else {
         return null;
      }
   }

   private binarytobst.BST.Node inputfromstring(String s, binarytobst.BST.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         binarytobst.BST.Node node = new binarytobst.BST.Node(this, 0, (binarytobst.BST.Node)null, (binarytobst.BST.Node)null);

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

   private void display(binarytobst.BST.Node parent) {
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

   public void inorder(binarytobst.BST.Node parent, ArrayList<Integer> list) {
      if (parent != null) {
         this.inorder(parent.left, list);
         list.add(parent.data);
         this.inorder(parent.right, list);
      }
   }

   public void binarytobst() {
      this.root = this.binarytobst(this.root);
   }

   public binarytobst.BST.Node binarytobst(binarytobst.BST.Node parent) {
      ArrayList<Integer> inorder = new ArrayList();
      this.inorder(parent, inorder);
      Collections.sort(inorder);
      this.inorder2(parent, inorder);
      return parent;
   }

   public void inorder2(binarytobst.BST.Node parent, ArrayList<Integer> list) {
      if (parent != null) {
         this.inorder2(parent.left, list);
         parent.data = (Integer)list.get(indx++);
         this.inorder2(parent.right, list);
      }
   }
}
