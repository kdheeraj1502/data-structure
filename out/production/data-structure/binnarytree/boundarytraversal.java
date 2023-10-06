package binnarytree;

public class boundarytraversal {
   public static void main(String[] args) {
      boundarytraversal m = new boundarytraversal();
      m.getClass();
      BinaryTree tree = new BinaryTree(m);
      tree.display();
      System.out.println();
      System.out.println(tree.boundary());
   }
}
