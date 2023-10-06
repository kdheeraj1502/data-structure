package binnarytree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class LCA$BinaryTree {
   private LCA.BinaryTree.Node root;
   private int size;
   // $FF: synthetic field
   final LCA this$0;

   LCA$BinaryTree(LCA this$0, String s) {
      this.this$0 = this$0;
      this.root = null;
      this.size = 0;
      new Scanner(System.in);
      this.root = this.inputfromstring(s, (LCA.BinaryTree.Node)null);
   }

   private LCA.BinaryTree.Node inputfromstring(String s, LCA.BinaryTree.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         LCA.BinaryTree.Node node = new LCA.BinaryTree.Node(this, 0, (LCA.BinaryTree.Node)null, (LCA.BinaryTree.Node)null);

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

   private void display(LCA.BinaryTree.Node parent) {
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

   public ArrayList<Integer> roottonode(LCA.BinaryTree.Node parent, int n) {
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

   public int lca(int n1, int n2) {
      return this.lca(this.root, n1, n2);
   }

   private int lca(LCA.BinaryTree.Node parent, int n1, int n2) {
      ArrayList<Integer> listn1 = this.roottonode(parent, n1);
      ArrayList<Integer> listn2 = this.roottonode(parent, n2);
      int i = listn1.size() - 1;

      for(int j = listn2.size() - 1; i >= 0 && j >= 0 && listn1.get(i) == listn2.get(j); --j) {
         --i;
      }

      ++i;
      return (Integer)listn1.get(i);
   }

   // $FF: synthetic method
   static LCA.BinaryTree.Node access$000(LCA$BinaryTree x0) {
      return x0.root;
   }
}
