package binnarytree;

public class kthancestor {
   public static void main(String[] args) {
      kthancestor m = new kthancestor();
      m.getClass();
      BinaryTree tree = new BinaryTree(m, "1(2(3))");
      tree.display();
      System.out.println();
      System.out.println(tree.kthancestor(3, 1));
   }
}
