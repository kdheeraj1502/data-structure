package binarysearchtree;

import java.util.ArrayList;
import java.util.Stack;

public class LCA$BST {
   private int size = 0;
   private LCA.BST.Node root = null;
   LCA.BST.Node suc = new LCA.BST.Node(this, -1, (LCA.BST.Node)null, (LCA.BST.Node)null);
   LCA.BST.Node pre = new LCA.BST.Node(this, -1, (LCA.BST.Node)null, (LCA.BST.Node)null);

   LCA$BST(int[] arr) {
      this.root = this.makeBST(arr, 0, arr.length - 1);
   }

   LCA$BST(String s) {
      this.root = this.inputfromstring(s, this.root);
   }

   private LCA.BST.Node makeBST(int[] arr, int lo, int hi) {
      if (lo > hi) {
         return null;
      } else {
         int mid = lo + (hi - lo) / 2;
         LCA.BST.Node parent = new LCA.BST.Node(this, arr[mid], (LCA.BST.Node)null, (LCA.BST.Node)null);
         parent.left = this.makeBST(arr, lo, mid - 1);
         parent.right = this.makeBST(arr, mid + 1, hi);
         return parent;
      }
   }

   private LCA.BST.Node inputfromstring(String s, LCA.BST.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         LCA.BST.Node node = new LCA.BST.Node(this, 0, (LCA.BST.Node)null, (LCA.BST.Node)null);

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

   private void display(LCA.BST.Node parent) {
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

   private boolean find(LCA.BST.Node parent, int n) {
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

   private LCA.BST.Node add(LCA.BST.Node parent, int n) {
      if (parent == null) {
         return new LCA.BST.Node(this, n, (LCA.BST.Node)null, (LCA.BST.Node)null);
      } else {
         if (n > parent.data) {
            parent.right = this.add(parent.right, n);
         } else if (n < parent.data) {
            parent.left = this.add(parent.left, n);
         }

         return parent;
      }
   }

   private LCA.BST.Node max(LCA.BST.Node parent) {
      if (parent == null) {
         return null;
      } else {
         return parent.right != null ? this.max(parent.right) : parent;
      }
   }

   private LCA.BST.Node min(LCA.BST.Node parent) {
      if (parent == null) {
         return null;
      } else {
         return parent.left != null ? this.min(parent.left) : parent;
      }
   }

   public ArrayList<Integer> roottonode(LCA.BST.Node parent, int n) {
      if (parent == null) {
         return new ArrayList();
      } else {
         ArrayList left;
         if (parent.data == n) {
            left = new ArrayList();
            left.add(parent.data);
            return left;
         } else {
            if (parent.data > n) {
               left = this.roottonode(parent.left, n);
               if (left.size() > 0) {
                  left.add(parent.data);
                  return left;
               }
            } else {
               left = this.roottonode(parent.right, n);
               if (left.size() > 0) {
                  left.add(parent.data);
                  return left;
               }
            }

            return new ArrayList();
         }
      }
   }

   public void lca(LCA.BST.Node parent, int n1, int n2) {
      ArrayList<Integer> a = this.roottonode(parent, n1);
      ArrayList<Integer> b = this.roottonode(parent, n2);
      int i = a.size() - 1;

      for(int j = b.size() - 1; i >= 0 && j >= 0 && a.get(i) == b.get(j); --j) {
         --i;
      }

      ++i;
      System.out.println(a.get(i));
   }

   // $FF: synthetic method
   static LCA.BST.Node access$000(LCA$BST x0) {
      return x0.root;
   }
}
