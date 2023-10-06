package binarysearchtree;

import java.util.ArrayList;
import java.util.Stack;

public class targetsum2bst$BST {
   private int size = 0;
   private targetsum2bst.BST.Node root = null;

   targetsum2bst$BST(int[] arr) {
      this.root = this.makeBST(arr, 0, arr.length - 1);
   }

   targetsum2bst$BST(String s) {
      this.root = this.inputfromstring(s, this.root);
   }

   private targetsum2bst.BST.Node makeBST(int[] arr, int lo, int hi) {
      if (lo > hi) {
         return null;
      } else {
         int mid = lo + (hi - lo) / 2;
         targetsum2bst.BST.Node parent = new targetsum2bst.BST.Node(this, arr[mid], (targetsum2bst.BST.Node)null, (targetsum2bst.BST.Node)null);
         parent.left = this.makeBST(arr, lo, mid - 1);
         parent.right = this.makeBST(arr, mid + 1, hi);
         return parent;
      }
   }

   private targetsum2bst.BST.Node inputfromstring(String s, targetsum2bst.BST.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         targetsum2bst.BST.Node node = new targetsum2bst.BST.Node(this, 0, (targetsum2bst.BST.Node)null, (targetsum2bst.BST.Node)null);

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

   private void display(targetsum2bst.BST.Node parent) {
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

   public void inorder(targetsum2bst.BST.Node parent, ArrayList<Integer> list) {
      if (parent != null) {
         this.inorder(parent.left, list);
         list.add(parent.data);
         this.inorder(parent.right, list);
      }
   }

   public static int countPairs(targetsum2bst.BST.Node root1, targetsum2bst.BST.Node root2, int x) {
      if (root1 != null && root2 != null) {
         int ans = 0;
         ans += countPairs(root1.left, root2, x);
         int c = x - root1.data;
         if (find(root2, c)) {
            ++ans;
         }

         ans += countPairs(root1.right, root2, x);
         return ans;
      } else {
         return 0;
      }
   }

   public static boolean find(targetsum2bst.BST.Node root, int n) {
      if (root == null) {
         return false;
      } else {
         Boolean ans = false;
         if (n > root.data) {
            ans = find(root.right, n);
         } else {
            if (n >= root.data) {
               return true;
            }

            ans = find(root.left, n);
         }

         return ans;
      }
   }

   // $FF: synthetic method
   static targetsum2bst.BST.Node access$000(targetsum2bst$BST x0) {
      return x0.root;
   }
}
