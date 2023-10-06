package com.hellokoding.datastructure;

public class BSTByLinkedList {
   public Node root;

   private Node insert(Node node, int data) {
      if (node == null) {
         return new Node(data);
      } else {
         if (data < node.data) {
            node.left = this.insert(node.left, data);
         } else if (data > node.data) {
            node.right = this.insert(node.right, data);
         }

         return node;
      }
   }

   public void insert(int data) {
      this.root = this.insert(this.root, data);
   }

   public void inTraversal(Node node) {
      if (node != null) {
         this.inTraversal(node.left);
         System.out.println(node);
         this.inTraversal(node.right);
      }
   }

   public static void main(String[] args) {
      BSTByLinkedList tree = new BSTByLinkedList();
      tree.insert(7);
      tree.insert(2);
      tree.insert(3);
      tree.insert(1);
      tree.insert(9);
      tree.inTraversal(tree.root);
   }
}
