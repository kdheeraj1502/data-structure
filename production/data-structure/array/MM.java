package array;

class MM {
   public static void main(String[] args) {
      int a = 2;
      int b = 10;
      int size = Math.abs(b - a) + 1;
      int[] array = new int[size];

      int i;
      for(i = a; i <= b; ++i) {
         if (i % 2 == 0 || i % 5 == 0) {
            array[i - a] = 1;
         }
      }

      System.out.println("MULTIPLES of 2 and 5:");

      for(i = a; i <= b; ++i) {
         if (array[i - a] == 1) {
            System.out.printf(i + " ");
         }
      }

   }
}
