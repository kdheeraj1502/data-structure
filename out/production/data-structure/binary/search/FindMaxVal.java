package binary.search;

public class FindMaxVal {
   public static int findMax(Node root, String side) {
      if (root == null) {
         System.out.println(side + " side val is " + null);
         return Integer.MIN_VALUE;
      } else {
         System.out.println(side + " side Value is " + root.val);
         int max = root.val;
         System.out.println(side + " side Max is " + max);
         int left = findMax(root.left, "left");
         System.out.println("left max is " + left + " and Root val was " + root.val);
         int right = findMax(root.right, "right");
         System.out.println("right max is " + right + " and Root val was " + root.val);
         if (max < left) {
            System.out.println("Max was " + max + " left is " + left + " root is " + root.val);
            max = left;
            System.out.println("Now max is " + left);
         }

         if (max < right) {
            System.out.println("Max was " + max + " right is " + right + " root is " + root.val);
            max = right;
            System.out.println("Now max is " + right);
         }

         System.out.println("returing max " + max);
         return max;
      }
   }
}
