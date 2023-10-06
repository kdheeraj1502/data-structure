package binnarytree;

public class largestsubtreesum {
   public static void main(String[] args) {
      largestsubtreesum m = new largestsubtreesum();
      m.getClass();
      BinaryTree tree = new BinaryTree(m, "1(2(4))(3(1(2(1))))");
      int[] in = new int[]{4, -2, 5, 0, -6, 3, 2};
      int[] pre = new int[]{0, -2, 4, 5, 3, -6, 2};
      tree.treefrominandpre(in, pre);
      System.out.println(tree.sum());
      System.out.println(tree.maxsumsofar);
   }
}
