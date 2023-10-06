package binarysearchtree;

public class flattenbst {
   public static void main(String[] args) {
      String s = "5(3(2(1))(4))(7(6)(8))";
      BST tree = new BST(s);
      tree.display();
      System.out.println();
      tree.flattenbst();
      tree.display();
   }
}
