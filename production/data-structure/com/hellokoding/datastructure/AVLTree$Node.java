package com.hellokoding.datastructure;

public class AVLTree$Node {
   int key;
   int height;
   AVLTree$Node left;
   AVLTree$Node right;

   AVLTree$Node(int key) {
      this.key = key;
      this.height = 0;
   }

   public String toString() {
      return String.format("key: %d, height: %d, left: %d, right: %d", this.key, this.height, this.left != null ? this.left.key : null, this.right != null ? this.right.key : null);
   }
}
