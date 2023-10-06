package com.hellokoding.algorithm;

import com.hellokoding.datastructure.BSTByLinkedList;

public class TreeDepthFirstTraversalRecursively extends BSTByLinkedList {
   public void preTraversal(BSTByLinkedList.Node node) {
      if (node != null) {
         System.out.println(node);
         this.preTraversal(node.left);
         this.preTraversal(node.right);
      }
   }

   public void inTraversal(BSTByLinkedList.Node node) {
      if (node != null) {
         this.inTraversal(node.left);
         System.out.println(node);
         this.inTraversal(node.right);
      }
   }

   public void postTraversal(BSTByLinkedList.Node node) {
      if (node != null) {
         this.postTraversal(node.left);
         this.postTraversal(node.right);
         System.out.println(node);
      }
   }

   public static void main(String[] args) {
      TreeDepthFirstTraversalRecursively tree = new TreeDepthFirstTraversalRecursively();
      tree.insert(7);
      tree.insert(2);
      tree.insert(3);
      tree.insert(1);
      tree.insert(9);
      System.out.println("Pre-order Traversal");
      tree.preTraversal(tree.root);
      System.out.println();
      System.out.println("In-order Traversal");
      tree.inTraversal(tree.root);
      System.out.println();
      System.out.println("Post-order Traversal");
      tree.postTraversal(tree.root);
   }
}
