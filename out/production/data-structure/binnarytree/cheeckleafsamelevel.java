package binnarytree;

public class cheeckleafsamelevel {
   public static void main(String[] args) {
      cheeckleafsamelevel m = new cheeckleafsamelevel();
      m.getClass();
      BinaryTree tree = new BinaryTree(m, "4(2(3(4))(1))(6(1))");
      tree.display();
      System.out.println();
      System.out.println(tree.checkleaf());
   }
}
