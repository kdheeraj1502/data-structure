package binnarytree;

public class iterativeprepostinorder {
   public static void main(String[] args) {
      iterativeprepostinorder m = new iterativeprepostinorder();
      m.getClass();
      BinaryTree tree = new BinaryTree(m);
      tree.inorder();
      System.out.println();
      tree.iterative();
   }
}
