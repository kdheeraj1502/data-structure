package binarysearchtree;

public class largestbst {
   public static void main(String[] args) {
      String s = "0(2(1)(3))";
      BST tree = new BST(s);
      tree.display();
      System.out.println(tree.largestbst());
   }
}
