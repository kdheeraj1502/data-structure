package binarysearchtree;

import java.util.Stack;

public class inordersuccessor$BST {
   private int size = 0;
   private inordersuccessor.BST.Node root = null;
   inordersuccessor.BST.Node suc = new inordersuccessor.BST.Node(this, -1, (inordersuccessor.BST.Node)null, (inordersuccessor.BST.Node)null);
   inordersuccessor.BST.Node pre = new inordersuccessor.BST.Node(this, -1, (inordersuccessor.BST.Node)null, (inordersuccessor.BST.Node)null);
   static inordersuccessor.BST.Node next = null;

   inordersuccessor$BST(int[] arr) {
      this.root = this.makeBST(arr, 0, arr.length - 1);
   }

   inordersuccessor$BST(String s) {
      this.root = this.inputfromstring(s, this.root);
   }

   private inordersuccessor.BST.Node makeBST(int[] arr, int lo, int hi) {
      if (lo > hi) {
         return null;
      } else {
         int mid = lo + (hi - lo) / 2;
         inordersuccessor.BST.Node parent = new inordersuccessor.BST.Node(this, arr[mid], (inordersuccessor.BST.Node)null, (inordersuccessor.BST.Node)null);
         parent.left = this.makeBST(arr, lo, mid - 1);
         parent.right = this.makeBST(arr, mid + 1, hi);
         return parent;
      }
   }

   private inordersuccessor.BST.Node inputfromstring(String s, inordersuccessor.BST.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         inordersuccessor.BST.Node node = new inordersuccessor.BST.Node(this, 0, (inordersuccessor.BST.Node)null, (inordersuccessor.BST.Node)null);

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

   private void display(inordersuccessor.BST.Node parent) {
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

   private boolean find(inordersuccessor.BST.Node parent, int n) {
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

   private inordersuccessor.BST.Node add(inordersuccessor.BST.Node parent, int n) {
      if (parent == null) {
         return new inordersuccessor.BST.Node(this, n, (inordersuccessor.BST.Node)null, (inordersuccessor.BST.Node)null);
      } else {
         if (n > parent.data) {
            parent.right = this.add(parent.right, n);
         } else if (n < parent.data) {
            parent.left = this.add(parent.left, n);
         }

         return parent;
      }
   }

   private inordersuccessor.BST.Node max(inordersuccessor.BST.Node parent) {
      if (parent == null) {
         return null;
      } else {
         return parent.right != null ? this.max(parent.right) : parent;
      }
   }

   private inordersuccessor.BST.Node min(inordersuccessor.BST.Node parent) {
      if (parent == null) {
         return null;
      } else {
         return parent.left != null ? this.min(parent.left) : parent;
      }
   }

   public static void populateNext(inordersuccessor.BST.Node node) {
      if (node != null) {
         populateNext(node.right);
         node.next = next;
         next = node;
         populateNext(node.left);
      }

   }

   public static void inorder(inordersuccessor.BST.Node parent) {
      if (parent != null) {
         inorder(parent.left);
         System.out.print(parent.data + "-> ");
         if (parent.next != null) {
            System.out.print(parent.next.data + " ");
         } else {
            System.out.print("-1 ");
         }

         inorder(parent.right);
      }
   }

   public void succ(inordersuccessor.BST.Node root, int n) {
      if (root != null) {
         if (root.data == n) {
            if (root.right != null) {
               this.suc = this.min(root.right);
            }

         } else {
            if (root.data > n) {
               this.suc = root;
               this.succ(root.left, n);
            }

         }
      }
   }

   // $FF: synthetic method
   static inordersuccessor.BST.Node access$000(inordersuccessor$BST x0) {
      return x0.root;
   }
}
