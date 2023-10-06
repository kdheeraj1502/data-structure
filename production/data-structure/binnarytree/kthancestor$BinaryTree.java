package binnarytree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class kthancestor$BinaryTree {
   private kthancestor.BinaryTree.Node root;
   private int size;
   // $FF: synthetic field
   final kthancestor this$0;

   kthancestor$BinaryTree(kthancestor this$0, String s) {
      this.this$0 = this$0;
      this.root = null;
      this.size = 0;
      new Scanner(System.in);
      this.root = this.inputfromstring(s, (kthancestor.BinaryTree.Node)null);
   }

   private kthancestor.BinaryTree.Node inputfromstring(String s, kthancestor.BinaryTree.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         kthancestor.BinaryTree.Node node = new kthancestor.BinaryTree.Node(this, 0, (kthancestor.BinaryTree.Node)null, (kthancestor.BinaryTree.Node)null);

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

   private void display(kthancestor.BinaryTree.Node parent) {
      String str = "";
      if (parent.left != null) {
         str = str + parent.left.data + " => ";
      } else {
         str = str + "End => ";
      }

      str = str + parent.data;
      if (parent.right != null) {
         str = str + " <= " + parent.right.data;
      } else {
         str = str + " <= End";
      }

      System.out.println(str);
      if (parent.left != null) {
         this.display(parent.left);
      }

      if (parent.right != null) {
         this.display(parent.right);
      }

   }

   public ArrayList<Integer> roottonode(kthancestor.BinaryTree.Node parent, int n) {
      if (parent == null) {
         return new ArrayList();
      } else {
         ArrayList listleft;
         if (parent.data == n) {
            listleft = new ArrayList();
            listleft.add(parent.data);
            return listleft;
         } else {
            listleft = this.roottonode(parent.left, n);
            ArrayList<Integer> listright = this.roottonode(parent.right, n);
            if (listleft.size() > 0) {
               listleft.add(parent.data);
               return listleft;
            } else if (listright.size() > 0) {
               listright.add(parent.data);
               return listright;
            } else {
               return new ArrayList();
            }
         }
      }
   }

   public int kthancestor(int n1, int k) {
      return this.kthancestor(this.root, n1, k);
   }

   private int kthancestor(kthancestor.BinaryTree.Node parent, int n1, int k) {
      ArrayList<Integer> listn1 = this.roottonode(parent, n1);

      int i;
      for(i = listn1.size() - 1; i >= 0 && i != k; --i) {
      }

      return i == k ? (Integer)listn1.get(i) : -1;
   }
}
