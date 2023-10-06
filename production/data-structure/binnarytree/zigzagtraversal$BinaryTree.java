package binnarytree;

import java.util.Scanner;
import java.util.Stack;

public class zigzagtraversal$BinaryTree {
   private zigzagtraversal.BinaryTree.Node root;
   private int size;
   // $FF: synthetic field
   final zigzagtraversal this$0;

   zigzagtraversal$BinaryTree(zigzagtraversal this$0) {
      this.this$0 = this$0;
      this.root = null;
      this.size = 0;
      Scanner scn = new Scanner(System.in);
      this.root = this.input(scn, (zigzagtraversal.BinaryTree.Node)null, false);
   }

   private zigzagtraversal.BinaryTree.Node input(Scanner scn, zigzagtraversal.BinaryTree.Node parent, Boolean isleftorright) {
      if (parent == null) {
         System.out.println("Enter data for the parent node");
      } else if (isleftorright) {
         System.out.println("Enter data for the left child of " + parent.data);
      } else {
         System.out.println("Enter data for the right child of " + parent.data);
      }

      int data = scn.nextInt();
      zigzagtraversal.BinaryTree.Node node = new zigzagtraversal.BinaryTree.Node(this, data, (zigzagtraversal.BinaryTree.Node)null, (zigzagtraversal.BinaryTree.Node)null);
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

   private void display(zigzagtraversal.BinaryTree.Node parent) {
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

   public void zigzag() {
      this.zigzag(this.root);
   }

   private void zigzag(zigzagtraversal.BinaryTree.Node parent) {
      Stack<zigzagtraversal.BinaryTree.Node> p = new Stack();
      Stack<zigzagtraversal.BinaryTree.Node> c = new Stack();
      p.push(parent);
      int level = 0;

      while(!p.isEmpty()) {
         zigzagtraversal.BinaryTree.Node node = (zigzagtraversal.BinaryTree.Node)p.pop();
         System.out.println(node.data + " ");
         if (level % 2 == 0) {
            if (node.left != null) {
               c.push(node.left);
            }

            if (node.right != null) {
               c.push(node.right);
            }
         } else {
            if (node.right != null) {
               c.push(node.right);
            }

            if (node.left != null) {
               c.push(node.left);
            }
         }

         if (p.size() == 0) {
            ++level;
            p = c;
            c = new Stack();
         }
      }

   }
}
