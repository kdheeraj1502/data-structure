package binnarytree;

public class topview {
   public static void main(String[] args) {
      topview m = new topview();
      m.getClass();
      BinaryTree tree = new BinaryTree(m);
      tree.display();
      System.out.println();
      tree.topview();
   }
}
