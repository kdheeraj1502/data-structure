package strings;

public class RabinKarp_18 {
   public static int prime = 7;

   public static void main(String[] args) {
      String s = "ababcaababcaabc";
      String pat = "ababcaabc";
      rabinkarp(s, pat);
   }

   public static void detectpattern(String s, String pat) {
      int i = 0;
      int j = 0;

      for(int k = 0; i < s.length() && j < s.length(); k = 0) {
         while(k < pat.length() && j < s.length() && s.charAt(j) == pat.charAt(k)) {
            ++j;
            ++k;
         }

         if (k == pat.length()) {
            System.out.println("Pattern found at index " + i);
         }

         ++i;
         j = i;
      }

   }

   public static void rabinkarp(String s, String pat) {
      long pathash = hashfunction(pat, pat.length());
      long stringhash = hashfunction(s, pat.length());

      for(int i = 0; i <= s.length() - pat.length(); ++i) {
         if (pathash == stringhash) {
            if (checkpat(pat, s, i, i + pat.length() - 1)) {
               System.out.println("Pattern found at index " + i);
            }
         } else if (i < s.length() - pat.length()) {
            stringhash = rollinghashfunction(pat, i + pat.length(), i, s, stringhash);
         }
      }

   }

   public static long hashfunction(String pat, int patlength) {
      long result = 0L;

      for(int i = 0; i < patlength; ++i) {
         result += (long)pat.charAt(i) * (long)Math.pow((double)prime, (double)i);
      }

      return result;
   }

   public static long rollinghashfunction(String pat, int newindex, int oldindex, String s, long oldhash) {
      long newhash = oldhash - (long)s.charAt(oldindex);
      newhash /= (long)prime;
      newhash += (long)s.charAt(newindex) * (long)Math.pow((double)prime, (double)(pat.length() - 1));
      return newhash;
   }

   public static boolean checkpat(String pat, String s, int start, int end) {
      for(int k = 0; k < pat.length() && start <= end; ++start) {
         if (s.charAt(start) != pat.charAt(k)) {
            return false;
         }

         ++k;
      }

      return true;
   }
}
