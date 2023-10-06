package com.hellokoding.datastructure;

public class AVLTree {
   public Node root;

   private int findHeight(Node node) {
      return node == null ? -1 : node.height;
   }

   private int findBalanceFactor(Node node) {
      return node == null ? 0 : this.findHeight(node.left) - this.findHeight(node.right);
   }

   private Node rotateRight(Node node) {
      Node pivot = node.left;
      node.left = pivot.right;
      pivot.right = node;
      node.height = 1 + Math.max(this.findHeight(node.left), this.findHeight(node.right));
      pivot.height = 1 + Math.max(this.findHeight(pivot.left), this.findHeight(pivot.right));
      return pivot;
   }

   private Node rotateLeft(Node node) {
      Node pivot = node.right;
      node.right = pivot.left;
      pivot.left = node;
      node.height = 1 + Math.max(this.findHeight(node.left), this.findHeight(node.right));
      pivot.height = 1 + Math.max(this.findHeight(pivot.left), this.findHeight(pivot.right));
      return pivot;
   }

   private Node insert(Node node, int key) {
      if (node == null) {
         return new Node(key);
      } else {
         if (key < node.key) {
            node.left = this.insert(node.left, key);
         } else {
            if (key <= node.key) {
               return node;
            }

            node.right = this.insert(node.right, key);
         }

         node.height = 1 + Math.max(this.findHeight(node.left), this.findHeight(node.right));
         int balanceFactor = this.findBalanceFactor(node);
         if (balanceFactor > 1 && key < node.left.key) {
            return this.rotateRight(node);
         } else if (balanceFactor < -1 && key > node.right.key) {
            return this.rotateLeft(node);
         } else if (balanceFactor > 1 && key > node.left.key) {
            node.left = this.rotateLeft(node.left);
            return this.rotateRight(node);
         } else if (balanceFactor < -1 && key < node.right.key) {
            node.right = this.rotateRight(node.right);
            return this.rotateLeft(node);
         } else {
            return node;
         }
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
      AVLTree tree = new AVLTree();
      tree.insert(7);
      tree.insert(2);
      tree.insert(3);
      tree.insert(1);
      tree.insert(9);
      tree.inTraversal(tree.root);
   }
}
