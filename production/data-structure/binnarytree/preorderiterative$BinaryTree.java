package binnarytree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class preorderiterative$BinaryTree {
   private preorderiterative.BinaryTree.Node root;
   // $FF: synthetic field
   final preorderiterative this$0;

   preorderiterative$BinaryTree(preorderiterative this$0) {
      this.this$0 = this$0;
      this.root = null;
      Scanner scn = new Scanner(System.in);
      this.root = this.input(scn, (preorderiterative.BinaryTree.Node)null, false);
   }

   private preorderiterative.BinaryTree.Node input(Scanner scn, preorderiterative.BinaryTree.Node parent, Boolean isleftorright) {
      if (parent == null) {
         System.out.println("Enter data for the parent node");
      } else if (isleftorright) {
         System.out.println("Enter data for the left child of " + parent.data);
      } else {
         System.out.println("Enter data for the right child of " + parent.data);
      }

      int data = scn.nextInt();
      preorderiterative.BinaryTree.Node node = new preorderiterative.BinaryTree.Node(this, data, (preorderiterative.BinaryTree.Node)null, (preorderiterative.BinaryTree.Node)null);
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

   private void display(preorderiterative.BinaryTree.Node parent) {
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

   public void preorder() {
      this.preorder(this.root);
   }

   private void preorder(preorderiterative.BinaryTree.Node parent) {
      if (parent != null) {
         System.out.print(parent.data + " ");
         this.preorder(parent.left);
         this.preorder(parent.right);
      }
   }

   public void postorder() {
      this.postorder(this.root);
   }

   private void postorder(preorderiterative.BinaryTree.Node parent) {
      if (parent != null) {
         this.postorder(parent.left);
         this.postorder(parent.right);
         System.out.print(parent.data + " ");
      }
   }

   public void preorderiterative() {
      this.preorderiterative(this.root);
   }

   private void preorderiterative(preorderiterative.BinaryTree.Node parent) {
      ArrayList<Integer> ans = new ArrayList();
      Stack<preorderiterative.BinaryTree.Node> stack = new Stack();
      stack.push(parent);
      preorderiterative.BinaryTree.Node node = parent;

      while(node != null) {
         ans.add(node.data);

         for(node = node.left; node == null && !stack.isEmpty(); node = node.right) {
            node = (preorderiterative.BinaryTree.Node)stack.pop();
         }

         stack.push(node);
      }

      Iterator var5 = ans.iterator();

      while(var5.hasNext()) {
         int val = (Integer)var5.next();
         System.out.print(val + " ");
      }

   }
}
