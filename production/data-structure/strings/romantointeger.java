package strings;

public class romantointeger {
   public static void main(String[] args) {
      roman("CMXVI");
   }

   public static void roman(String str) {
      int sum = 0;
      int oldvalue = Integer.MAX_VALUE;
      int currvalue = 0;

      for(int i = 0; i < str.length(); ++i) {
         if (str.charAt(i) == 'I') {
            currvalue = 1;
         } else if (str.charAt(i) == 'V') {
            currvalue = 5;
         } else if (str.charAt(i) == 'X') {
            currvalue = 10;
         } else if (str.charAt(i) == 'L') {
            currvalue = 50;
         } else if (str.charAt(i) == 'C') {
            currvalue = 100;
         } else if (str.charAt(i) == 'D') {
            currvalue = 500;
         } else if (str.charAt(i) == 'M') {
            currvalue = 1000;
         }

         if (currvalue <= oldvalue) {
            sum += currvalue;
         } else {
            sum = sum - 2 * oldvalue + currvalue;
         }

         oldvalue = currvalue;
      }

      System.out.println(sum);
   }
}
