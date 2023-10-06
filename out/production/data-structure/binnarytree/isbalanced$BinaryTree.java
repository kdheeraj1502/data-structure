package binnarytree;

import java.util.Scanner;

public class isbalanced$BinaryTree {
   private isbalanced.BinaryTree.Node root;
   private int size;
   // $FF: synthetic field
   final isbalanced this$0;

   isbalanced$BinaryTree(isbalanced this$0) {
      this.this$0 = this$0;
      this.root = null;
      this.size = 0;
      Scanner scn = new Scanner(System.in);
      this.root = this.input(scn, (isbalanced.BinaryTree.Node)null, false);
   }

   private isbalanced.BinaryTree.Node input(Scanner scn, isbalanced.BinaryTree.Node parent, Boolean isleftorright) {
      if (parent == null) {
         System.out.println("Enter data for the parent node");
      } else if (isleftorright) {
         System.out.println("Enter data for the left child of " + parent.data);
      } else {
         System.out.println("Enter data for the right child of " + parent.data);
      }

      int data = scn.nextInt();
      isbalanced.BinaryTree.Node node = new isbalanced.BinaryTree.Node(this, data, (isbalanced.BinaryTree.Node)null, (isbalanced.BinaryTree.Node)null);
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

   private void display(isbalanced.BinaryTree.Node parent) {
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

   public boolean isbalanced() {
      return this.isbalanced(this.root).isbal;
   }

   private isbalanced.BinaryTree.pair isbalanced(isbalanced.BinaryTree.Node parent) {
      if (parent == null) {
         return new isbalanced.BinaryTree.pair(this, 0, true);
      } else {
         isbalanced.BinaryTree.pair left = this.isbalanced(parent.left);
         isbalanced.BinaryTree.pair right = this.isbalanced(parent.right);
         int mht = Math.max(left.ht, right.ht) + 1;
         boolean misbal = Math.abs(left.ht - right.ht) <= 1 && left.isbal && right.isbal;
         isbalanced.BinaryTree.pair myans = new isbalanced.BinaryTree.pair(this, mht, misbal);
         return myans;
      }
   }
}
