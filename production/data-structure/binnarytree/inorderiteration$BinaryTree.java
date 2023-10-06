package binnarytree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class inorderiteration$BinaryTree {
   private inorderiteration.BinaryTree.Node root;
   private int size;
   // $FF: synthetic field
   final inorderiteration this$0;

   inorderiteration$BinaryTree(inorderiteration this$0) {
      this.this$0 = this$0;
      this.root = null;
      this.size = 0;
      Scanner scn = new Scanner(System.in);
      this.root = this.input(scn, (inorderiteration.BinaryTree.Node)null, false);
   }

   private inorderiteration.BinaryTree.Node input(Scanner scn, inorderiteration.BinaryTree.Node parent, Boolean isleftorright) {
      if (parent == null) {
         System.out.println("Enter data for the parent node");
      } else if (isleftorright) {
         System.out.println("Enter data for the left child of " + parent.data);
      } else {
         System.out.println("Enter data for the right child of " + parent.data);
      }

      int data = scn.nextInt();
      inorderiteration.BinaryTree.Node node = new inorderiteration.BinaryTree.Node(this, data, (inorderiteration.BinaryTree.Node)null, (inorderiteration.BinaryTree.Node)null);
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

   private void display(inorderiteration.BinaryTree.Node parent) {
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

   public void inorder() {
      this.inorder(this.root);
   }

   private void inorder(inorderiteration.BinaryTree.Node parent) {
      if (parent != null) {
         this.inorder(parent.left);
         System.out.print(parent.data + " ");
         this.inorder(parent.right);
      }
   }

   public void inorderiterative() {
      this.inorderiterative(this.root);
   }

   private void inorderiterative(inorderiteration.BinaryTree.Node parent) {
      ArrayList<Integer> ans = new ArrayList();
      Stack<inorderiteration.BinaryTree.Node> stack = new Stack();
      stack.push(parent);
      inorderiteration.BinaryTree.Node node = parent;

      while(node != null) {
         for(node = node.left; node == null && !stack.isEmpty(); node = node.right) {
            node = (inorderiteration.BinaryTree.Node)stack.pop();
            ans.add(node.data);
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
