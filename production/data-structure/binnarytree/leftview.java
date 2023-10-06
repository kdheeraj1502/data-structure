package binnarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class leftview {
   private Node root = null;
   private int size = 0;

   private Node input(Scanner scn, Node parent, Boolean isleftorright) {
      if (parent == null) {
         System.out.println("Enter data for the parent node");
      } else if (isleftorright) {
         System.out.println("Enter data for the left child of " + parent.data);
      } else {
         System.out.println("Enter data for the right child of " + parent.data);
      }

      int data = scn.nextInt();
      Node node = new Node(data, (Node)null, (Node)null);
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

   private void display(Node parent) {
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

   public ArrayList<Integer> leftview() {
      return this.leftview(this.root);
   }

   private ArrayList<Integer> leftview(Node parent) {
      Queue<Node> queue = new ArrayDeque();
      ArrayList<Integer> result = new ArrayList();
      queue.add(parent);

      while(!queue.isEmpty()) {
         int size = queue.size();

         for(int i = 1; i <= size; ++i) {
            Node temp = (Node)queue.remove();
            if (i == 1) {
               result.add(temp.data);
            }

            if (temp.left != null) {
               queue.add(temp.left);
            }

            if (temp.right != null) {
               queue.add(temp.right);
            }
         }
      }

      return result;
   }

   public static void main(String[] args) {
      Node root = new Node(10);
      root.right = new Node(30);
      root.left = new Node(20);
      root.left.left = new Node(40);
      root.left.right = new Node(60);
      leftview m = new leftview();
      m.root = root;
      System.out.println();
      System.out.println(m.leftview());
   }
}
