package binnarytree;

public class issumtree {
   public static void main(String[] args) {
      issumtree m = new issumtree();
      m.getClass();
      BinaryTree tree = new BinaryTree(m, "7(3(1)(2))(1(1))");
      tree.display();
      System.out.println();
      System.out.println(tree.issumtree());
   }
}
