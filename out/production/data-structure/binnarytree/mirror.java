package binnarytree;

public class mirror {
   public static void main(String[] args) {
      mirror m = new mirror();
      m.getClass();
      BinaryTree tree = new BinaryTree(m);
      tree.display();
      tree.mirror(tree);
      System.out.println();
      System.out.println();
      tree.display();
   }
}
