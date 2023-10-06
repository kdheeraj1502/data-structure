package binnarytree;

public class zigzagtraversal {
   public static void main(String[] args) {
      zigzagtraversal m = new zigzagtraversal();
      m.getClass();
      BinaryTree tree = new BinaryTree(m);
      tree.display();
      System.out.println();
      tree.zigzag();
   }
}
