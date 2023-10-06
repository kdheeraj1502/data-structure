package binarysearchtree;

public class morristraversal {
   public static void main(String[] args) {
      int[] arr1 = new int[]{2, 3, 4, 5, 6, 7, 8};
      BST tree1 = new BST(arr1);
      tree1.display();
      System.out.println();
      tree1.morristraversalinorder();
   }
}
