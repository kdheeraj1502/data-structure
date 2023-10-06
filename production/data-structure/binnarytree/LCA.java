package binnarytree;

public class LCA {
   public static void main(String[] args) {
      LCA m = new LCA();
      m.getClass();
      BinaryTree tree = new BinaryTree(m, "1(3(2)(4))(6)");
      tree.display();
      System.out.println();
      System.out.println(tree.roottonode(binnarytree.LCA.BinaryTree.access$000(tree), 2));
      System.out.println(tree.lca(2, 4));
   }
}
