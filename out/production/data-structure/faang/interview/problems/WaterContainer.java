package faang.interview.problems;

public class WaterContainer {
   public int maxArea(int[] height) {
      int left = 0;
      int right = height.length - 1;
      int currArea = false;
      int maxArea = 0;
      int leftHeight = false;
      int rightHeight = false;

      while(left < right) {
         int leftHeight = height[left];
         int rightHeight = height[right];
         int currArea = Math.min(leftHeight, rightHeight) * (right - left);
         maxArea = Math.max(maxArea, currArea);
         if (leftHeight > rightHeight) {
            --right;
         } else {
            ++left;
         }
      }

      return maxArea;
   }

   public static void main(String[] args) {
      int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
      WaterContainer wc = new WaterContainer();
      System.out.println(wc.maxArea(height));
   }
}
