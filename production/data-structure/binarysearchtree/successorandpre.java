package binarysearchtree;

public class successorandpre {
   public static void main(String[] args) {
      String s = "50(40(35)(45))";
      BST tree = new BST(s);
      tree.display();
      tree.findPreSuc(50);
      System.out.println(tree.pre.data + " " + tree.suc.data);
   }
}
