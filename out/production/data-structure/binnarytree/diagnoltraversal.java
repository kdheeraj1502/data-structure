package binnarytree;

public class diagnoltraversal {
   public static void main(String[] args) {
      diagnoltraversal m = new diagnoltraversal();
      m.getClass();
      BinaryTree tree = new BinaryTree(m);
      tree.display();
      System.out.println();
      tree.diagnol();
      System.out.println(tree.map);
      System.out.println();
      tree.diagnolopti();
   }
}
