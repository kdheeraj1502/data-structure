package misclaneous;

public class joshmirrortreequestion {
   public static void main(String[] args) {
      joshmirrortreequestion m = new joshmirrortreequestion();
      m.getClass();
      BinaryTree tree = new BinaryTree(m, "1(2(4(5)(6)))(3()(7(8)(9)))");
      tree.display();
      System.out.println(tree.checkmirrorstructure(misclaneous.joshmirrortreequestion.BinaryTree.access$000(tree).left, misclaneous.joshmirrortreequestion.BinaryTree.access$000(tree).right));
      tree.display();
   }
}
