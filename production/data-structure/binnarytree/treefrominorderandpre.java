package binnarytree;

public class treefrominorderandpre {
   public static void main(String[] args) {
      treefrominorderandpre m = new treefrominorderandpre();
      m.getClass();
      BinaryTree tree = new BinaryTree(m, "4(2(3)(1))(6(1))");
      tree.display();
      System.out.println();
      int[] in = new int[]{1, 6, 8, 7};
      int[] pre = new int[]{1, 6, 7, 8};
      tree.treefrominandpre(in, pre);
      tree.display();
   }
}
