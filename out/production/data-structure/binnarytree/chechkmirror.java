package binnarytree;

public class chechkmirror {
   public static void main(String[] args) {
      chechkmirror m = new chechkmirror();
      m.getClass();
      BinaryTree tree = new BinaryTree(m, "1(2(4))(3)");
      m.getClass();
      BinaryTree tree2 = new BinaryTree(m, "1(3)(2)");
      System.out.println(tree.checkmirror(tree2));
   }
}
