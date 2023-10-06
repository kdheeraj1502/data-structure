package binnarytree;

public class longestpathsum {
   public static void main(String[] args) {
      longestpathsum m = new longestpathsum();
      m.getClass();
      BinaryTree tree = new BinaryTree(m, "1(2(4))(3(1(2(1))))");
      System.out.println(tree.sum());
   }
}
