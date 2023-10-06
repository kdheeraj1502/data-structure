package backtracking;

public class nqueens {
   public static void main(String[] args) {
      int[][] arr = new int[4][4];
      print(arr, 3, 0, 0, "");
   }

   public static void print(int[][] arr, int tq, int qp, int i, String ans) {
      if (qp == tq) {
         System.out.println(ans);
      } else if (i != arr.length) {
         for(int k = 0; k < arr.length; ++k) {
            if (check(arr, i, k)) {
               arr[i][k] = 1;
               print(arr, tq, qp + 1, i + 1, ans + " { " + i + " - " + k + " }");
               arr[i][k] = 0;
            }
         }

         print(arr, tq, qp, i + 1, ans);
      }
   }

   private static boolean check(int[][] arr, int i, int j) {
      int temp;
      for(temp = i - 1; temp >= 0; --temp) {
         if (arr[temp][j] == 1) {
            return false;
         }
      }

      temp = j - 1;

      int j2;
      for(j2 = i - 1; j2 >= 0 && temp >= 0; --j2) {
         if (arr[j2][temp] == 1) {
            return false;
         }

         --temp;
      }

      temp = j + 1;

      for(j2 = i - 1; j2 >= 0 && temp < arr[0].length; --j2) {
         if (arr[j2][temp] == 1) {
            return false;
         }

         ++temp;
      }

      return true;
   }

   public static void printopti(int n, int i, String ans, int[] col, int[] d1, int[] d2) {
      if (i == n) {
         System.out.println(ans);
      } else {
         for(int k = 0; k < n; ++k) {
            if (checkopti(n, i, k, col, d1, d2)) {
               col[k] = 1;
               d1[i + k] = 1;
               d2[i - k + n - 1] = 1;
               printopti(n, i + 1, ans + " { " + i + " - " + k + " }", col, d1, d2);
               col[k] = 0;
               d1[i + k] = 0;
               d2[i - k + n - 1] = 0;
            }
         }

      }
   }

   private static boolean checkopti(int n, int i, int j, int[] col, int[] d1, int[] d2) {
      if (col[j] == 1) {
         return false;
      } else if (d1[i + j] == 1) {
         return false;
      } else {
         return d2[i - j + n - 1] != 1;
      }
   }
}
