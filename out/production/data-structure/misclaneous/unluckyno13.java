package misclaneous;

public class unluckyno13 {
   public static void main(String[] args) {
      un(14);
   }

   public static void un(int n) {
      int[] arr = new int[n + 1];
      arr[1] = 1;
      arr[2] = 3;
      int k = 3;

      int size;
      for(int start = 1; k < arr.length; start = size) {
         size = k;

         int j;
         String s;
         for(j = start; j < size && k < arr.length; ++j) {
            s = "1" + arr[j];
            arr[k] = Integer.parseInt(s);
            ++k;
         }

         for(j = start; j < size && k < arr.length; ++j) {
            s = "3" + arr[j];
            arr[k] = Integer.parseInt(s);
            ++k;
         }
      }

      for(size = 0; size < arr.length; ++size) {
         System.out.println(arr[size]);
      }

   }
}
