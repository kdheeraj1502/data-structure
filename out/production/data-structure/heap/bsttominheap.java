package heap;

public class bsttominheap {
   public static void main(String[] args) {
      String s = "4(2(1)(3))(6(5)(7))";
      BST tree = new BST(s);
      tree.display();
      System.out.println();
      tree.binarytobst();
      tree.display();
      System.out.println();
      tree.bsttoheap(heap.bsttominheap.BST.access$000(tree));
      tree.display();
   }
}
