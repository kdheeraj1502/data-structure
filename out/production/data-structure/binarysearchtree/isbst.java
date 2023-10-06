package binarysearchtree;

public class isbst {
   public static void main(String[] args) {
      String s = "50(40(35)(51))";
      BST tree = new BST(s);
      tree.display();
      System.out.println(tree.isBST());
   }
}
