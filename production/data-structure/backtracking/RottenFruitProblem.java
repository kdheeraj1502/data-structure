package backtracking;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenFruitProblem {
   int[] x = new int[]{0, 0, -1, 1};
   int[] y = new int[]{-1, 1, 0, 0};

   public int rottenFruit(int[][] num) {
      Queue<Pair> queue = new ArrayDeque();

      int days;
      int i;
      for(days = 0; days < num.length; ++days) {
         for(i = 0; i < num[days].length; ++i) {
            if (num[days][i] == 2) {
               queue.add(new Pair(this, days, i, 0));
            }
         }
      }

      days = 0;

      int j;
      while(!queue.isEmpty()) {
         Pair curr = (Pair)queue.poll();
         days = Math.max(days, curr.days);

         for(j = 0; j < this.x.length; ++j) {
            int row = curr.x + this.x[j];
            int col = curr.y + this.y[j];
            if (this.isValid(num, row, col) && num[row][col] == 1) {
               queue.add(new Pair(this, row, col, curr.days + 1));
               num[row][col] = 2;
            }
         }
      }

      for(i = 0; i < num.length; ++i) {
         for(j = 0; j < num[i].length; ++j) {
            if (num[i][j] == 1) {
               return -1;
            }
         }
      }

      return days;
   }

   public int orangesRotting(int[][] grid) {
      int R = grid.length;
      int C = grid[0].length;
      Queue<Pair> queue = new ArrayDeque();

      int days;
      int i;
      for(days = 0; days < R; ++days) {
         for(i = 0; i < C; ++i) {
            if (grid[days][i] == 2) {
               queue.add(new Pair(this, days, i, 0));
            }
         }
      }

      days = 0;

      int j;
      while(!queue.isEmpty()) {
         Pair cur = (Pair)queue.poll();
         days = Math.max(days, cur.days);

         for(j = 0; j < this.x.length; ++j) {
            int ro = cur.x + this.x[j];
            int co = cur.y + this.y[j];
            if (this.isValid(grid, ro, co) && grid[ro][co] == 1) {
               queue.add(new Pair(this, ro, co, cur.days + 1));
               grid[ro][co] = 2;
            }
         }
      }

      for(i = 0; i < R; ++i) {
         for(j = 0; j < C; ++j) {
            if (grid[i][j] == 1) {
               return -1;
            }
         }
      }

      return days;
   }

   public boolean isValid(int[][] grid, int i, int j) {
      return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
   }

   public static void main(String[] args) {
      int[][] num = new int[][]{{1, 0, 1, 1, 0}, {2, 1, 0, 1, 0}, {0, 0, 0, 2, 1}, {0, 2, 0, 0, 1}, {1, 1, 0, 0, 1}};
      RottenFruitProblem rfp = new RottenFruitProblem();
      System.out.println(rfp.rottenFruit(num));
   }
}
