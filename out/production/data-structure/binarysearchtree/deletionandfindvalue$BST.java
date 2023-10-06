package binarysearchtree;

public class deletionandfindvalue$BST {
   private int size;
   private deletionandfindvalue.BST.Node root;
   // $FF: synthetic field
   final deletionandfindvalue this$0;

   deletionandfindvalue$BST(deletionandfindvalue this$0, int[] arr) {
      this.this$0 = this$0;
      this.size = 0;
      this.root = null;
      this.root = this.makeBST(arr, 0, arr.length - 1);
   }

   private deletionandfindvalue.BST.Node makeBST(int[] arr, int lo, int hi) {
      if (lo > hi) {
         return null;
      } else {
         int mid = lo + (hi - lo) / 2;
         deletionandfindvalue.BST.Node parent = new deletionandfindvalue.BST.Node(this, arr[mid], (deletionandfindvalue.BST.Node)null, (deletionandfindvalue.BST.Node)null);
         parent.left = this.makeBST(arr, lo, mid - 1);
         parent.right = this.makeBST(arr, mid + 1, hi);
         return parent;
      }
   }

   public void display() {
      this.display(this.root);
   }

   private void display(deletionandfindvalue.BST.Node parent) {
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

   private boolean find(deletionandfindvalue.BST.Node parent, int n) {
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
      this.add(this.root, n);
   }

   private void add(deletionandfindvalue.BST.Node parent, int n) {
      if (n > parent.data) {
         if (parent.right != null) {
            this.add(parent.right, n);
         } else {
            parent.right = new deletionandfindvalue.BST.Node(this, n, (deletionandfindvalue.BST.Node)null, (deletionandfindvalue.BST.Node)null);
         }
      } else if (parent.left != null) {
         this.add(parent.left, n);
      } else {
         parent.left = new deletionandfindvalue.BST.Node(this, n, (deletionandfindvalue.BST.Node)null, (deletionandfindvalue.BST.Node)null);
      }

   }

   public int max() {
      return this.max(this.root);
   }

   private int max(deletionandfindvalue.BST.Node parent) {
      if (parent == null) {
         return 0;
      } else {
         return parent.right != null ? this.max(parent.right) : parent.data;
      }
   }

   public void remove(int n) {
      this.root = this.remove(this.root, n);
   }

   private deletionandfindvalue.BST.Node remove(deletionandfindvalue.BST.Node node, int n) {
      if (node == null) {
         return null;
      } else {
         if (n > node.data) {
            node.right = this.remove(node.right, n);
         } else {
            if (n >= node.data) {
               if (node.left == null && node.right == null) {
                  return null;
               }

               if (node.left != null && node.right == null) {
                  return node.left;
               }

               if (node.left == null && node.right != null) {
                  return node.right;
               }

               node.data = this.max(node.left);
               node.left = this.remove(node.left, node.data);
               return node;
            }

            node.left = this.remove(node.left, n);
         }

         return node;
      }
   }
}
