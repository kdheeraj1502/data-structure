package binarysearchtree;

public class bstfrompreorder {
   public static void main(String[] args) {
      int[] arr = new int[]{2, 1, 3};
      BST tree = new BST(arr);
      tree.add(0);
      tree.display();
   }
}
