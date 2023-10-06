package binnarytree;

public class tosumtree {
   public static void main(String[] args) {
      tosumtree m = new tosumtree();
      m.getClass();
      BinaryTree tree = new BinaryTree(m, "4(2(3)(1))(6(1))");
      tree.display();
      System.out.println();
      tree.tosumtree();
      tree.display();
   }
}
