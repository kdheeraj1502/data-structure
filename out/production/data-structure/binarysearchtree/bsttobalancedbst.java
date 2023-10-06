package binarysearchtree;

public class bsttobalancedbst {
   public static void main(String[] args) {
      String s = "1()(3()(4()(5()(6))))";
      BST tree = new BST(s);
      tree.display();
      tree.balancedbst();
      System.out.println();
      tree.display();
   }
}
