package strings;

public class sentencetonumber {
   public static void main(String[] args) {
      stn("geeksforgeeks");
   }

   public static void stn(String s) {
      String[] codes = new String[]{"2", "22", "222", "3", "33", "333", "4", "44", "444", "5", "55", "555", "6", "66", "666", "7", "77", "777", "7777", "8", "88", "888", "9", "99", "999", "9999"};
      String ans = "";

      for(int i = 0; i < s.length(); ++i) {
         ans = ans + codes[s.charAt(i) - 97];
      }

      System.out.println(ans);
   }
}
