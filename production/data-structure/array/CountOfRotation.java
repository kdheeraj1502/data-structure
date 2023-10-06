package array;

public class CountOfRotation {
   public static int countOfRotation(int[] num) {
      int max = MaxElementInArray.findMaxIndex(num);
      return max % num.length;
   }

   public static void main(String[] args) {
      int[] num = new int[]{3, 4, 5, 1, 2};
      System.out.println(countOfRotation(num));
   }
}
