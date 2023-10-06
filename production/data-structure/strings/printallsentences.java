package strings;

public class printallsentences {
   public static void main(String[] args) {
      String[][] arr = new String[][]{{"you", "we"}, {"have", "are"}, {"sleep", "eat", "drink"}};
      print(arr, "", 0);
   }

   public static void print(String[][] arr, String ans, int row) {
      if (row == arr.length) {
         System.out.println(ans);
      } else {
         for(int i = 0; i < arr[row].length; ++i) {
            print(arr, ans + arr[row][i] + " ", row + 1);
         }

      }
   }
}
