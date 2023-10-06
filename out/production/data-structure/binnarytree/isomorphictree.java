package binnarytree;

public class isomorphictree {
   public static void main(String[] args) {
      isomorphictree m = new isomorphictree();
      m.getClass();
      BinaryTree tree = new BinaryTree(m, "10(-20)");
      m.getClass();
      BinaryTree tree2 = new BinaryTree(m, "1(3)(2)");
      tree.display();
      System.out.println();
      System.out.println(tree.isomorphic(tree2));
   }
}
