package binnarytree;

public class inorderiteration {
   public static void main(String[] args) {
      inorderiteration m = new inorderiteration();
      m.getClass();
      BinaryTree tree = new BinaryTree(m);
      tree.inorder();
      System.out.println();
      tree.inorderiterative();
   }
}
