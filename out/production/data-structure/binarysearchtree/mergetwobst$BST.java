package binarysearchtree;

import java.util.ArrayList;
import java.util.Stack;

public class mergetwobst$BST {
   private int size = 0;
   private mergetwobst.BST.Node root = null;
   public static int i = 0;

   mergetwobst$BST(int[] arr) {
      this.root = this.makeBSTfrompreoptimised(arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
   }

   mergetwobst$BST(String s) {
      this.root = this.inputfromstring(s, this.root);
   }

   private mergetwobst.BST.Node makeBSTfrompreoptimised(int[] arr, int min, int max) {
      if (i < arr.length && arr[i] >= min && arr[i] <= max) {
         mergetwobst.BST.Node node = new mergetwobst.BST.Node(this, arr[i++], (mergetwobst.BST.Node)null, (mergetwobst.BST.Node)null);
         node.left = this.makeBSTfrompreoptimised(arr, min, node.data);
         node.right = this.makeBSTfrompreoptimised(arr, node.data, max);
         return node;
      } else {
         return null;
      }
   }

   private mergetwobst.BST.Node inputfromstring(String s, mergetwobst.BST.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         mergetwobst.BST.Node node = new mergetwobst.BST.Node(this, 0, (mergetwobst.BST.Node)null, (mergetwobst.BST.Node)null);

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

   private void display(mergetwobst.BST.Node parent) {
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

   public void inorder(mergetwobst.BST.Node parent, ArrayList<Integer> list) {
      if (parent != null) {
         this.inorder(parent.left, list);
         list.add(parent.data);
         this.inorder(parent.right, list);
      }
   }

   private mergetwobst.BST.Node makeBST(ArrayList<Integer> arr, int lo, int hi) {
      if (lo > hi) {
         return null;
      } else {
         int mid = lo + (hi - lo) / 2;
         mergetwobst.BST.Node parent = new mergetwobst.BST.Node(this, (Integer)arr.get(mid), (mergetwobst.BST.Node)null, (mergetwobst.BST.Node)null);
         parent.left = this.makeBST(arr, lo, mid - 1);
         parent.right = this.makeBST(arr, mid + 1, hi);
         return parent;
      }
   }

   public void mergebst(mergetwobst$BST tree) {
      this.root = this.mergebst(this.root, tree.root);
   }

   private mergetwobst.BST.Node mergebst(mergetwobst.BST.Node parent1, mergetwobst.BST.Node parent2) {
      ArrayList<Integer> list1 = new ArrayList();
      ArrayList<Integer> list2 = new ArrayList();
      this.inorder(parent1, list1);
      this.inorder(parent2, list2);
      ArrayList<Integer> list3 = new ArrayList();
      int i = 0;
      int j = 0;

      while(i < list1.size() && j < list2.size()) {
         if ((Integer)list1.get(i) < (Integer)list2.get(j)) {
            list3.add(list1.get(i));
            ++i;
         } else {
            list3.add(list2.get(j));
            ++j;
         }
      }

      if (i == list1.size()) {
         while(j < list2.size()) {
            list3.add(list2.get(j));
            ++j;
         }
      } else {
         while(i < list1.size()) {
            list3.add(list1.get(i));
            ++i;
         }
      }

      System.out.println(list3);
      return this.makeBST(list3, 0, list3.size() - 1);
   }
}
