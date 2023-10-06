package strings;

public class LongestCommonPrefix_27 {
   public static void main(String[] args) {
      String[] arr = new String[]{"flower", "flow", "flight"};
      System.out.println(prefix(arr));
   }

   public static String prefix(String[] arr) {
      if (arr.length != 0 && arr != null) {
         if (arr.length == 1) {
            return arr[0];
         } else {
            String temp = arr[0];
            String longest = temp;

            for(int i = 1; i < arr.length; ++i) {
               String prefix = checkprefixoptimised(temp, arr[i]);
               if (longest.length() > prefix.length()) {
                  longest = prefix;
               }
            }

            return longest;
         }
      } else {
         return "";
      }
   }

   public static String checkprefix(String s1, String s2) {
      int i = 0;
      int j = 0;

      String prefix;
      for(prefix = ""; i < s1.length() && j < s2.length() && s1.charAt(i) == s2.charAt(j); ++j) {
         prefix = prefix + s1.charAt(j);
         ++i;
      }

      return prefix;
   }

   public static String checkprefixoptimised(String s1, String s2) {
      int i = 0;
      int j = 0;

      String prefix;
      for(prefix = ""; i < s1.length() && j < s2.length() && s1.charAt(i) == s2.charAt(j); ++j) {
         ++i;
      }

      prefix = s1.substring(0, j);
      return prefix;
   }
}
