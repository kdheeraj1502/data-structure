package strings;

public class knuthmorispratt {
   public static void main(String[] args) {
      String s = "ababcaababcaabc";
      String pat = "ababcaabc";
      String a1 = "00012";
      String a2 = "12";
      System.out.println(a1.compareTo(a2));
   }

   public static void kmp(String s, String pat) {
      int[] pitable = pitable(pat);
      int i = 0;
      int j = 0;

      while(i < s.length()) {
         if (s.charAt(i) == pat.charAt(j)) {
            ++i;
            ++j;
         } else if (j != 0) {
            j = pitable[j - 1];
         } else {
            ++i;
         }

         if (j == pat.length()) {
            System.out.println("Patern is found at " + (i - j));
            break;
         }
      }

   }

   public static int[] pitable(String pat) {
      int[] pitable = new int[pat.length()];
      pitable[0] = 0;

      for(int i = 1; i < pitable.length; ++i) {
         int j;
         for(j = pitable[i - 1]; j > 0 && pat.charAt(i) != pat.charAt(j); j = pitable[j - 1]) {
         }

         if (pat.charAt(i) == pat.charAt(j)) {
            ++j;
         }

         pitable[i] = j;
      }

      return pitable;
   }
}
