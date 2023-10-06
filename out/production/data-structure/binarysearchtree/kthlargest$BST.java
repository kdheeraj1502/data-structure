package binarysearchtree;

import java.util.ArrayList;
import java.util.Stack;

public class kthlargest$BST {
   private int size = 0;
   private kthlargest.BST.Node root = null;
   public static int i = 0;
   public static int k = 2;

   kthlargest$BST(int[] arr) {
      this.root = this.makeBSTfrompreoptimised(arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
   }

   kthlargest$BST(String s) {
      this.root = this.inputfromstring(s, this.root);
   }

   private kthlargest.BST.Node makeBSTfrompreoptimised(int[] arr, int min, int max) {
      if (i < arr.length && arr[i] >= min && arr[i] <= max) {
         kthlargest.BST.Node node = new kthlargest.BST.Node(this, arr[i++], (kthlargest.BST.Node)null, (kthlargest.BST.Node)null);
         node.left = this.makeBSTfrompreoptimised(arr, min, node.data);
         node.right = this.makeBSTfrompreoptimised(arr, node.data, max);
         return node;
      } else {
         return null;
      }
   }

   private kthlargest.BST.Node inputfromstring(String s, kthlargest.BST.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         kthlargest.BST.Node node = new kthlargest.BST.Node(this, 0, (kthlargest.BST.Node)null, (kthlargest.BST.Node)null);

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

   private void display(kthlargest.BST.Node parent) {
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

   public void inorder(kthlargest.BST.Node parent, ArrayList<Integer> list) {
      if (parent != null) {
         this.inorder(parent.left, list);
         list.add(parent.data);
         this.inorder(parent.right, list);
      }
   }

   public int kthlargest(kthlargest.BST.Node root) {
      if (root == null) {
         return Integer.MIN_VALUE;
      } else {
         int right = this.kthlargest(root.right);
         if (right != Integer.MIN_VALUE) {
            return right;
         } else {
            --k;
            if (k == 0) {
               return root.data;
            } else {
               int left = this.kthlargest(root.left);
               return left;
            }
         }
      }
   }

   // $FF: synthetic method
   static kthlargest.BST.Node access$000(kthlargest$BST x0) {
      return x0.root;
   }
}
