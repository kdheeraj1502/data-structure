package binnarytree;

import java.util.ArrayList;
import java.util.Scanner;

public class boundarytraversal$BinaryTree {
   private boundarytraversal.BinaryTree.Node root;
   private int size;
   // $FF: synthetic field
   final boundarytraversal this$0;

   boundarytraversal$BinaryTree(boundarytraversal this$0) {
      this.this$0 = this$0;
      this.root = null;
      this.size = 0;
      Scanner scn = new Scanner(System.in);
      this.root = this.input(scn, (boundarytraversal.BinaryTree.Node)null, false);
   }

   private boundarytraversal.BinaryTree.Node input(Scanner scn, boundarytraversal.BinaryTree.Node parent, Boolean isleftorright) {
      if (parent == null) {
         System.out.println("Enter data for the parent node");
      } else if (isleftorright) {
         System.out.println("Enter data for the left child of " + parent.data);
      } else {
         System.out.println("Enter data for the right child of " + parent.data);
      }

      int data = scn.nextInt();
      boundarytraversal.BinaryTree.Node node = new boundarytraversal.BinaryTree.Node(this, data, (boundarytraversal.BinaryTree.Node)null, (boundarytraversal.BinaryTree.Node)null);
      ++this.size;
      System.out.println("does " + node.data + " has left child");
      Boolean choice = false;
      choice = scn.nextBoolean();
      if (choice) {
         node.left = this.input(scn, node, true);
      }

      choice = false;
      System.out.println("does " + node.data + " has right child");
      choice = scn.nextBoolean();
      if (choice) {
         node.right = this.input(scn, node, false);
      }

      return node;
   }

   public void display() {
      this.display(this.root);
   }

   private void display(boundarytraversal.BinaryTree.Node parent) {
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

   private void boundaryleft(boundarytraversal.BinaryTree.Node parent, ArrayList<Integer> ans) {
      if (parent != null) {
         if (parent.left != null) {
            ans.add(parent.data);
            this.boundaryleft(parent.left, ans);
         } else if (parent.right != null) {
            ans.add(parent.data);
            this.boundaryleft(parent.right, ans);
         }

      }
   }

   private void boundaryleafnode(boundarytraversal.BinaryTree.Node parent, ArrayList<Integer> ans) {
      if (parent != null) {
         if (parent.left == null && parent.right == null) {
            ans.add(parent.data);
         } else {
            this.boundaryleafnode(parent.left, ans);
            this.boundaryleafnode(parent.right, ans);
         }
      }
   }

   private void boundaryright(boundarytraversal.BinaryTree.Node parent, ArrayList<Integer> ans) {
      if (parent != null) {
         if (parent.right != null) {
            this.boundaryright(parent.right, ans);
            ans.add(parent.data);
         } else if (parent.left != null) {
            this.boundaryright(parent.left, ans);
            ans.add(parent.data);
         }

      }
   }

   public ArrayList<Integer> boundary() {
      return this.boundary(this.root);
   }

   private ArrayList<Integer> boundary(boundarytraversal.BinaryTree.Node parent) {
      ArrayList<Integer> ans = new ArrayList();
      ans.add(parent.data);
      this.boundaryleft(parent.left, ans);
      this.boundaryleafnode(parent, ans);
      this.boundaryright(parent.right, ans);
      return ans;
   }
}
