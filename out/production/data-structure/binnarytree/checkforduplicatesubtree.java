package binnarytree;

public class checkforduplicatesubtree {
   public static void main(String[] args) {
      checkforduplicatesubtree m = new checkforduplicatesubtree();
      m.getClass();
      BinaryTree tree = new BinaryTree(m, "1(2(4)(5))(3(2(4)(5)))");
      tree.display();
      System.out.println();
      System.out.println(tree.checkduplicatesub());
   }
}
