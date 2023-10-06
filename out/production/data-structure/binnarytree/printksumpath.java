package binnarytree;

public class printksumpath {
   public static void main(String[] args) {
      printksumpath m = new printksumpath();
      m.getClass();
      BinaryTree tree = new BinaryTree(m, "1(3(2)(1(1)))(-1(4(1)(2))(5(6)))");
      tree.display();
      System.out.println();
      tree.path(5);
   }
}
