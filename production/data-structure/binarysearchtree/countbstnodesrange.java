package binarysearchtree;

public class countbstnodesrange {
   public static void main(String[] args) {
      int[] arr1 = new int[]{1, 3, 6, 10, 11, 12, 13, 15, 18, 20};
      BST tree1 = new BST(arr1);
      tree1.display();
      System.out.println(tree1.getCount(binarysearchtree.countbstnodesrange.BST.access$000(tree1), 6, 11));
   }
}
