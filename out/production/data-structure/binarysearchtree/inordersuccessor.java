package binarysearchtree;

public class inordersuccessor {
   public static void main(String[] args) {
      String s = "50(40(35)(45))";
      BST tree = new BST(s);
      tree.display();
      binarysearchtree.inordersuccessor.BST.populateNext(binarysearchtree.inordersuccessor.BST.access$000(tree));
      binarysearchtree.inordersuccessor.BST.inorder(binarysearchtree.inordersuccessor.BST.access$000(tree));
   }
}
