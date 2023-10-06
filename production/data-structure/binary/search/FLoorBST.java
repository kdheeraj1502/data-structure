package binary.search;

public class FLoorBST {
   public static int floorBST(Node root, int val) {
      Node curr = root;
      int floor = Integer.MAX_VALUE;

      while(curr != null) {
         if (curr.val == val) {
            floor = curr.val;
            break;
         }

         if (curr.val > val) {
            curr = curr.left;
         } else {
            floor = curr.val;
            curr = curr.right;
         }
      }

      return floor;
   }
}
