package binnarytree;

public class printduplicatesubtree {
   public static void main(String[] args) {
      printduplicatesubtree m = new printduplicatesubtree();
      m.getClass();
      BinaryTree tree = new BinaryTree(m, "10(20(25))(30(20(25)))");
      tree.display();
      System.out.println();
      tree.printall();
   }
}
