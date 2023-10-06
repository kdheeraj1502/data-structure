package binnarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class diagnoltraversal$BinaryTree {
   private diagnoltraversal.BinaryTree.Node root;
   private int size;
   Map<Integer, ArrayList<Integer>> map;
   // $FF: synthetic field
   final diagnoltraversal this$0;

   diagnoltraversal$BinaryTree(diagnoltraversal this$0) {
      this.this$0 = this$0;
      this.root = null;
      this.size = 0;
      this.map = new TreeMap();
      Scanner scn = new Scanner(System.in);
      this.root = this.input(scn, (diagnoltraversal.BinaryTree.Node)null, false);
   }

   private diagnoltraversal.BinaryTree.Node input(Scanner scn, diagnoltraversal.BinaryTree.Node parent, Boolean isleftorright) {
      if (parent == null) {
         System.out.println("Enter data for the parent node");
      } else if (isleftorright) {
         System.out.println("Enter data for the left child of " + parent.data);
      } else {
         System.out.println("Enter data for the right child of " + parent.data);
      }

      int data = scn.nextInt();
      diagnoltraversal.BinaryTree.Node node = new diagnoltraversal.BinaryTree.Node(this, data, (diagnoltraversal.BinaryTree.Node)null, (diagnoltraversal.BinaryTree.Node)null);
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

   private void display(diagnoltraversal.BinaryTree.Node parent) {
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

   public void diagnol() {
      this.diagnol(this.root, 0);
   }

   private void diagnol(diagnoltraversal.BinaryTree.Node parent, int d) {
      if (parent != null) {
         ArrayList list;
         if (this.map.containsKey(d)) {
            list = (ArrayList)this.map.get(d);
            list.add(parent.data);
            this.map.replace(d, list);
         } else {
            list = new ArrayList();
            list.add(parent.data);
            this.map.put(d, list);
         }

         this.diagnol(parent.left, d + 1);
         this.diagnol(parent.right, d);
      }
   }

   public void diagnolopti() {
      this.diagnolopti(this.root);
   }

   private void diagnolopti(diagnoltraversal.BinaryTree.Node parent) {
      LinkedList<diagnoltraversal.BinaryTree.Node> queue = new LinkedList();
      queue.addLast(parent);

      while(!queue.isEmpty()) {
         for(diagnoltraversal.BinaryTree.Node rv = (diagnoltraversal.BinaryTree.Node)queue.removeFirst(); rv != null; rv = rv.right) {
            System.out.print(rv.data + " ");
            if (rv.left != null) {
               queue.addLast(rv.left);
            }
         }
      }

   }
}
