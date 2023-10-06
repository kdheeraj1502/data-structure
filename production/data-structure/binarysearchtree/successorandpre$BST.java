package binarysearchtree;

import java.util.Stack;

public class successorandpre$BST {
   private int size = 0;
   private successorandpre.BST.Node root = null;
   successorandpre.BST.Node suc = new successorandpre.BST.Node(this, -1, (successorandpre.BST.Node)null, (successorandpre.BST.Node)null);
   successorandpre.BST.Node pre = new successorandpre.BST.Node(this, -1, (successorandpre.BST.Node)null, (successorandpre.BST.Node)null);

   successorandpre$BST(int[] arr) {
      this.root = this.makeBST(arr, 0, arr.length - 1);
   }

   successorandpre$BST(String s) {
      this.root = this.inputfromstring(s, this.root);
   }

   private successorandpre.BST.Node makeBST(int[] arr, int lo, int hi) {
      if (lo > hi) {
         return null;
      } else {
         int mid = lo + (hi - lo) / 2;
         successorandpre.BST.Node parent = new successorandpre.BST.Node(this, arr[mid], (successorandpre.BST.Node)null, (successorandpre.BST.Node)null);
         parent.left = this.makeBST(arr, lo, mid - 1);
         parent.right = this.makeBST(arr, mid + 1, hi);
         return parent;
      }
   }

   private successorandpre.BST.Node inputfromstring(String s, successorandpre.BST.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         successorandpre.BST.Node node = new successorandpre.BST.Node(this, 0, (successorandpre.BST.Node)null, (successorandpre.BST.Node)null);

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

   private void display(successorandpre.BST.Node parent) {
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

   private boolean find(successorandpre.BST.Node parent, int n) {
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

   private successorandpre.BST.Node add(successorandpre.BST.Node parent, int n) {
      if (parent == null) {
         return new successorandpre.BST.Node(this, n, (successorandpre.BST.Node)null, (successorandpre.BST.Node)null);
      } else {
         if (n > parent.data) {
            parent.right = this.add(parent.right, n);
         } else if (n < parent.data) {
            parent.left = this.add(parent.left, n);
         }

         return parent;
      }
   }

   private successorandpre.BST.Node max(successorandpre.BST.Node parent) {
      if (parent == null) {
         return null;
      } else {
         return parent.right != null ? this.max(parent.right) : parent;
      }
   }

   private successorandpre.BST.Node min(successorandpre.BST.Node parent) {
      if (parent == null) {
         return null;
      } else {
         return parent.left != null ? this.min(parent.left) : parent;
      }
   }

   public void findPreSuc(int n) {
      this.findPreSuc(this.root, n);
   }

   public void findPreSuc(successorandpre.BST.Node root, int key) {
      if (root != null) {
         if (root.data == key) {
            if (root.left != null) {
               this.pre = this.max(root.left);
            }

            if (root.right != null) {
               this.suc = this.min(root.right);
            }

         } else {
            if (root.data > key) {
               this.suc = root;
               this.findPreSuc(root.left, key);
            } else {
               this.pre = root;
               this.findPreSuc(root.right, key);
            }

         }
      }
   }
}
