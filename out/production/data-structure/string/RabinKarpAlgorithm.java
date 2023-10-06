package string;

public class RabinKarpAlgorithm {
   public static final int CHAR_COUNT = 256;

   public static void search(String pat, String txt, int q) {
      int N = txt.length();
      int M = pat.length();
      int p = 0;
      int t = 0;
      int h = 1;

      int j;
      for(j = 0; j < M - 1; ++j) {
         h = h * 256 % q;
         System.out.println("h : " + h);
      }

      for(j = 0; j < M; ++j) {
         System.out.print("(256 * " + p + " + " + pat.charAt(j) + " ASCII is " + pat.charAt(j));
         System.out.print(") % " + q);
         p = (256 * p + pat.charAt(j)) % q;
         System.out.println(" Hash is :" + p);
         System.out.print("(256 * " + t + " + " + txt.charAt(j) + " ASCII is " + txt.charAt(j));
         System.out.print(") % " + q);
         t = (256 * t + txt.charAt(j)) % q;
         System.out.println(" Hash is : " + t);
      }

      int j = false;

      for(int i = 0; i <= N - M; ++i) {
         if (p == t) {
            for(j = 0; j < M && txt.charAt(i + j) == pat.charAt(j); ++j) {
            }

            if (j == M) {
               System.out.println("Pattern found at index " + i);
            }
         }

         if (i < N - M) {
            t = (256 * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
            if (t < 0) {
               t += q;
            }
         }
      }

   }

   public static void main(String[] args) {
      String text = "Dheeraj was in Army school";
      String pattern = "Army";
      int q = 101;
      System.out.println(text.length() + " " + pattern.length());
      search(pattern, text, q);
   }
}
