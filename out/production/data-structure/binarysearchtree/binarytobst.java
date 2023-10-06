package binarysearchtree;

public class binarytobst {
   public static void main(String[] args) {
      String s = "1(2)(3)";
      BST tree = new BST(s);
      tree.display();
      System.out.println();
      tree.binarytobst();
      tree.display();
   }
}
