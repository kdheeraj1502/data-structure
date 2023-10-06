package strings;

public class CountAndSay_7 {
   public static void main(String[] args) {
      System.out.println(countAndSay(4));
   }

   public static String countAndSay_1(int n) {
      if (n == 1) {
         return "1";
      } else if (n == 2) {
         return "11";
      } else {
         String s = "11";

         for(int i = 3; i <= n; ++i) {
            String t = "";
            int count = 1;
            s = s + "$";

            for(int j = 1; j < s.length(); ++j) {
               if (s.charAt(j) != s.charAt(j - 1)) {
                  t = t + String.valueOf(count);
                  t = t + s.charAt(j - 1);
                  count = 1;
               } else {
                  ++count;
               }
            }

            s = t;
         }

         return s;
      }
   }

   public static String countAndSay(int n) {
      if (n == 1) {
         return "1";
      } else {
         String myAns = countAndSay(n - 1);
         int i = 0;
         StringBuilder finalAns = new StringBuilder();

         while(i < myAns.length()) {
            int count = 0;

            char c;
            for(c = myAns.charAt(i); i < myAns.length() && myAns.charAt(i) == c; ++count) {
               ++i;
            }

            finalAns.append(count);
            finalAns.append(c);
         }

         return finalAns.toString();
      }
   }
}
