package stack;

import java.util.Arrays;

public class RottenFruit {
   public static void rottenFruit(int[][] num, int[][] dp, int currCol, int currRow, int day) {
      if (currCol >= 0 && currRow >= 0 && currCol < num.length && currRow < num[currCol].length) {
         if (dp[currCol][currRow] > day && num[currCol][currRow] != 0) {
            dp[currCol][currRow] = day;
            rottenFruit(num, dp, currCol - 1, currRow, day + 1);
            rottenFruit(num, dp, currCol + 1, currRow, day + 1);
            rottenFruit(num, dp, currCol, currRow + 1, day + 1);
            rottenFruit(num, dp, currCol, currRow - 1, day + 1);
         }
      }
   }

   public static int rottenFruit(int[][] num) {
      int[][] dp = new int[num.length][num[0].length];
      int day = 0;

      int maxDay;
      int i;
      for(maxDay = 0; maxDay < num.length; ++maxDay) {
         for(i = 0; i < num[maxDay].length; ++i) {
            dp[maxDay][i] = Integer.MAX_VALUE;
         }
      }

      for(maxDay = 0; maxDay < num.length; ++maxDay) {
         for(i = 0; i < num[maxDay].length; ++i) {
            if (num[maxDay][i] == 2) {
               rottenFruit(num, dp, maxDay, i, day);
            }
         }
      }

      maxDay = 0;

      for(i = 0; i < num.length; ++i) {
         for(int j = 0; j < num[i].length; ++j) {
            if (num[i][j] == 1) {
               if (dp[i][j] == Integer.MAX_VALUE) {
                  return -1;
               }

               if (maxDay < dp[i][j]) {
                  maxDay = dp[i][j];
               }
            }
         }
      }

      return maxDay;
   }

   public static void rottenFruit_self(int[][] num, int[][] dp, int row, int col, int day) {
      if (col >= 0 && row >= 0 && row < num.length && col < num[row].length) {
         if (dp[row][col] > day && num[row][col] != 0) {
            dp[row][col] = day;
            rottenFruit(num, dp, row - 1, col, day + 1);
            rottenFruit(num, dp, row + 1, col, day + 1);
            rottenFruit(num, dp, row, col + 1, day + 1);
            rottenFruit(num, dp, row, col - 1, day + 1);
         }
      }
   }

   public static int rottenFruit_self(int[][] num) {
      int[][] visited = new int[num.length][num.length];

      int maxDay;
      for(maxDay = 0; maxDay < visited.length; ++maxDay) {
         Arrays.fill(visited[maxDay], Integer.MAX_VALUE);
      }

      int i;
      for(maxDay = 0; maxDay < num.length; ++maxDay) {
         for(i = 0; i < num[maxDay].length; ++i) {
            if (num[maxDay][i] == 2) {
               rottenFruit(num, visited, maxDay, i, 0);
            }
         }
      }

      maxDay = 0;

      for(i = 0; i < visited.length; ++i) {
         for(int j = 0; j < visited[i].length; ++j) {
            if (num[i][j] == 1) {
               if (visited[i][j] == Integer.MAX_VALUE) {
                  return -1;
               }

               if (maxDay < visited[i][j]) {
                  maxDay = visited[i][j];
               }
            }
         }
      }

      return maxDay;
   }

   public static void main(String[] args) {
      int[][] num = new int[][]{{1, 0, 1, 1, 0}, {2, 1, 0, 1, 0}, {0, 0, 0, 2, 1}, {0, 2, 0, 0, 1}, {1, 1, 0, 0, 1}};
      System.out.println(rottenFruit_self(num));
   }
}
