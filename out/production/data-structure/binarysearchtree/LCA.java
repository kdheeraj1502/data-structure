package binarysearchtree;

public class LCA {
   public static void main(String[] args) {
      String s = "50(40(35)(45))(51)";
      BST tree = new BST(s);
      tree.display();
      tree.lca(binarysearchtree.LCA.BST.access$000(tree), 35, 51);
   }
}
