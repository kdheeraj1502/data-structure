package binnarytree;

public class bottomview {
   public static void main(String[] args) {
      bottomview m = new bottomview();
      m.getClass();
      BinaryTree tree = new BinaryTree(m);
      tree.display();
      System.out.println();
      tree.bottomview();
   }
}
