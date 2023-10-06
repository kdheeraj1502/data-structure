package strings;

public class duplicates {
   public static void main(String[] args) {
      duplicates("geeksforgeeks");
   }

   public static void duplicates(String s) {
      int[] count = new int[256];

      int i;
      for(i = 0; i < s.length(); ++i) {
         ++count[s.charAt(i)];
      }

      for(i = 0; i < count.length; ++i) {
         if (count[i] > 1) {
            System.out.println((char)i + " " + count[i]);
         }
      }

   }
}
