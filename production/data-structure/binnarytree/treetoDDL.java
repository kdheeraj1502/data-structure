package binnarytree;

public class treetoDDL {
   public static void main(String[] args) {
      treetoDDL m = new treetoDDL();
      m.getClass();
      BinaryTree tree = new BinaryTree(m, "4(2(3)(1))(6)");
      tree.display();
      System.out.println();
   }
}
