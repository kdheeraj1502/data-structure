package binary.search;

public class ZeroAndOne {
   public static int getFirstOneIndex(int[] num) {
      System.out.println(BinarySearch.getFirst(num, 1));
      return BinarySearch.getLast(num, 1);
   }

   public static void main(String[] args) {
      int[] num = new int[]{0, 0, 0, 1, 1, 1, 1, 1};
      System.out.println(getFirstOneIndex(num));
   }
}
