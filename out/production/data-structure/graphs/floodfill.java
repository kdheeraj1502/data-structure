package graphs;

public class floodfill {
   public static void main(String[] args) {
      int[][] image = new int[][]{{0, 0, 0}, {0, 1, 1}};
      int sr = 1;
      int sc = 1;
      int pre = image[sr][sc];
      floodfill(image, sr, sc, 1, pre);

      for(int i = 0; i < image.length; ++i) {
         for(int j = 0; j < image[0].length; ++j) {
            System.out.print(image[i][j] + " ");
         }

         System.out.println();
      }

   }

   public static void floodfill(int[][] image, int i, int j, int nc, int pre) {
      if (i >= 0 && j >= 0 && i < image.length && j < image[0].length && image[i][j] == pre) {
         if (image[i][j] != nc) {
            image[i][j] = nc;
            floodfill(image, i + 1, j, nc, pre);
            floodfill(image, i - 1, j, nc, pre);
            floodfill(image, i, j + 1, nc, pre);
            floodfill(image, i, j - 1, nc, pre);
         }
      }
   }
}
