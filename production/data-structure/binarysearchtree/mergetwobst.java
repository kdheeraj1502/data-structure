package binarysearchtree;

public class mergetwobst {
   public static void main(String[] args) {
      String s = "1()(3()(4()(5()(6))))";
      BST tree = new BST(s);
      String s1 = "2()(7()(8()(10()(12))))";
      BST tree1 = new BST(s1);
      tree.mergebst(tree1);
      tree.display();
   }
}
