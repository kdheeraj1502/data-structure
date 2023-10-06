package binnarytree;

public class maxsumnonadjacentnodes {
   public static void main(String[] args) {
      maxsumnonadjacentnodes m = new maxsumnonadjacentnodes();
      m.getClass();
      BinaryTree tree = new BinaryTree(m, "40(2(1))(3(5)(2))");
      tree.display();
      System.out.println();
      System.out.println(tree.maxsum());
   }
}
