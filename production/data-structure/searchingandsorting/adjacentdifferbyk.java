package searchingandsorting;

public class adjacentdifferbyk {
   public static void main(String[] args) {
      int[] arr = new int[]{20, 40, 50, 70, 70, 60};
      int k = 20;
      int x = 70;
      search(arr, k, x);
   }

   public static void search(int[] arr, int k, int x) {
      for(int i = 0; i < arr.length; i += Math.max(1, Math.abs((arr[i] - x) / k))) {
         if (arr[i] == x) {
            System.out.println(i);
            break;
         }
      }

   }
}
