package binarysearchtree;

import java.util.Stack;

public class largestbst$BST {
   private int size = 0;
   private largestbst.BST.Node root = null;
   public static int i = 0;

   largestbst$BST(int[] arr) {
      this.root = this.makeBSTfrompreoptimised(arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
   }

   largestbst$BST(String s) {
      this.root = this.inputfromstring(s, this.root);
   }

   private largestbst.BST.Node makeBSTfrompre(int[] arr, int lo, int hi) {
      largestbst.BST.Node parent = new largestbst.BST.Node(this, arr[0], (largestbst.BST.Node)null, (largestbst.BST.Node)null);

      for(int i = 1; i < arr.length; ++i) {
         this.add(parent, arr[i]);
      }

      return parent;
   }

   private largestbst.BST.Node makeBSTfrompreoptimised(int[] arr, int min, int max) {
      if (i < arr.length && arr[i] >= min && arr[i] <= max) {
         largestbst.BST.Node node = new largestbst.BST.Node(this, arr[i++], (largestbst.BST.Node)null, (largestbst.BST.Node)null);
         node.left = this.makeBSTfrompreoptimised(arr, min, node.data);
         node.right = this.makeBSTfrompreoptimised(arr, node.data, max);
         return node;
      } else {
         return null;
      }
   }

   private largestbst.BST.Node inputfromstring(String s, largestbst.BST.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         largestbst.BST.Node node = new largestbst.BST.Node(this, 0, (largestbst.BST.Node)null, (largestbst.BST.Node)null);

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

   private void display(largestbst.BST.Node parent) {
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

   private boolean find(largestbst.BST.Node parent, int n) {
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

   private largestbst.BST.Node add(largestbst.BST.Node parent, int n) {
      if (parent == null) {
         return new largestbst.BST.Node(this, n, (largestbst.BST.Node)null, (largestbst.BST.Node)null);
      } else {
         if (n > parent.data) {
            parent.right = this.add(parent.right, n);
         } else if (n < parent.data) {
            parent.left = this.add(parent.left, n);
         }

         return parent;
      }
   }

   private largestbst.BST.Node max(largestbst.BST.Node parent) {
      if (parent == null) {
         return null;
      } else {
         return parent.right != null ? this.max(parent.right) : parent;
      }
   }

   private largestbst.BST.Node min(largestbst.BST.Node parent) {
      if (parent == null) {
         return null;
      } else {
         return parent.left != null ? this.min(parent.left) : parent;
      }
   }

   boolean isbst(largestbst.BST.Node root, int min, int max) {
      if (root == null) {
         return true;
      } else if (min < root.data && max > root.data) {
         if (!this.isbst(root.left, min, root.data)) {
            return false;
         } else {
            return this.isbst(root.right, root.data, max);
         }
      } else {
         return false;
      }
   }

   public int largestbst() {
      largestbst.BST.pair ans = this.largestbst(this.root);
      return ans.size;
   }

   private largestbst.BST.pair largestbst(largestbst.BST.Node root) {
      largestbst.BST.pair left;
      if (root == null) {
         left = new largestbst.BST.pair(this, 0, true);
         left.min = Integer.MAX_VALUE;
         left.max = Integer.MIN_VALUE;
         return left;
      } else {
         left = this.largestbst(root.left);
         largestbst.BST.pair right = this.largestbst(root.right);
         largestbst.BST.pair mp = new largestbst.BST.pair(this, 0, false);
         mp.isbst = left.isbst && right.isbst && root.data > left.max && root.data < right.min;
         mp.min = Math.min(root.data, Math.min(left.min, right.min));
         mp.max = Math.max(root.data, Math.max(left.max, right.max));
         if (mp.isbst) {
            mp.size = left.size + right.size + 1;
            mp.node = root;
         } else if (left.size > right.size) {
            mp.size = left.size;
            mp.node = left.node;
         } else {
            mp.size = right.size;
            mp.node = right.node;
         }

         return mp;
      }
   }
}
