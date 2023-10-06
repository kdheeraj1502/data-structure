package binnarytree;

public class distancebw2nodes {
   public static void main(String[] args) {
      distancebw2nodes m = new distancebw2nodes();
      m.getClass();
      BinaryTree tree = new BinaryTree(m, "1(2)");
      tree.display();
      System.out.println();
      System.out.println(tree.distance(1, 2));
   }
}
