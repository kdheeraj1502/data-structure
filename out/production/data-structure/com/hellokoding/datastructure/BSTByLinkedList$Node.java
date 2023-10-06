package com.hellokoding.datastructure;

public class BSTByLinkedList$Node {
   public int data;
   public BSTByLinkedList$Node left;
   public BSTByLinkedList$Node right;

   public BSTByLinkedList$Node(int data) {
      this.data = data;
   }

   public String toString() {
      return String.format("data: %d, left: %d, right: %d", this.data, this.left != null ? this.left.data : null, this.right != null ? this.right.data : null);
   }
}
