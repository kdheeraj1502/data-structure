package binnarytree;

public class preorderiterative {
   public static void main(String[] args) {
      preorderiterative m = new preorderiterative();
      m.getClass();
      BinaryTree tree = new BinaryTree(m);
      tree.preorder();
      System.out.println();
      tree.preorderiterative();
   }
}
