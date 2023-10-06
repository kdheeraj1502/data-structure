package binarysearchtree;

public class deletionandfindvalue {
   public static void main(String[] args) {
      deletionandfindvalue m = new deletionandfindvalue();
      int[] arr = new int[]{1, 2, 3, 4, 5, 7, 8};
      m.getClass();
      BST tree = new BST(m, arr);
      tree.display();
      System.out.println();
      tree.remove(4);
      tree.display();
   }
}
