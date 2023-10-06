package backtracking;

public class balancedparanthesis {
   public static void main(String[] args) {
      print_1(2, "", 0, 0);
   }

   public static void print_1(int size, String ans, int openCount, int closeCount) {
      if (openCount <= size && closeCount <= size && closeCount <= openCount) {
         if (closeCount != openCount || size != openCount) {
            print_1(size, ans + ")", openCount, closeCount + 1);
            print_1(size, ans + "(", openCount + 1, closeCount);
         }
      }
   }

   public static void print(int size, String ans, int openCount, int closeCount) {
      if (openCount <= size && closeCount <= size && closeCount <= openCount) {
         if (openCount == closeCount && size == openCount) {
            System.out.println(ans);
         } else {
            print(size, ans + ')', openCount, closeCount + 1);
            print(size, ans + '(', openCount + 1, closeCount);
         }
      }
   }
}
