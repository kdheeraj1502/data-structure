package strings;

public class splitstring01 {
   public static void main(String[] args) {
      split("0111100010");
   }

   public static void split(String str) {
      int count0 = 0;
      int count1 = 0;
      int total = 0;

      for(int i = 0; i < str.length(); ++i) {
         if (str.charAt(i) == '0') {
            ++count0;
         } else if (str.charAt(i) == '1') {
            ++count1;
         }

         if (count0 == count1) {
            ++total;
            count1 = 0;
            count0 = 0;
         }
      }

      System.out.println(total);
   }
}
